package cn.peter.utils;

import okhttp3.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.*;

/**
 * @author Peter Yu 2018/12/3 17:49
 */
public class HttpClientUtils {

    private static final OkHttpClient client = createClient();

    private static final OkHttpClient cacheClient = createCacheClient();

    private static final OkHttpClient httpsClient = createHttpsClient();

    private static final OkHttpClient certificateClient = createCertificateClient();

    private static final OkHttpClient connectionSpecClient = createConnectionSpecClient();

    private static OkHttpClient createConnectionSpecClient() {ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
            .tlsVersions(TlsVersion.TLS_1_2)
            .cipherSuites(
                    CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                    CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                    CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
            .build();

        return  new OkHttpClient.Builder()
                .connectionSpecs(Collections.singletonList(spec))
                .build();

    }

    private static OkHttpClient createCertificateClient() {
        return new OkHttpClient.Builder()
                .certificatePinner(new CertificatePinner.Builder()
                                           .add("publicobject.com",
                                                "sha256/afwiKY3RxoMmLkuRW1l7QsPZTJPwDS2pdDROQjXw8ig=")
                                           .build())
                .build();
    }

    private static OkHttpClient createCacheClient() {
        int size = 10 * 1024 * 1024;
        File file = new File("temp/cache");
        Cache cache = new Cache(file, size);
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    private static OkHttpClient createHttpsClient() {
        return new OkHttpClient.Builder()
                .connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS))
                .build();
    }

    private HttpClientUtils() {
    }

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

    public static String get(String url) throws IOException {
        return get(url, null, null);
    }

    public static String get(String url, Map<String, String> params) throws IOException {
        return get(url, params, null);
    }

    public static String get(String url, Map<String, String> params, Map<String, String> headers) throws IOException {
        url = appendUrlWithParam(url, params);
        Request request = createRequest(url, headers);
        return getResponseContent(request);
    }

    private static String appendUrlWithParam(String url, Map<String, String> params) {
        String paramString = createParamString(params);
        if (StringUtils.isNotBlank(paramString) && !url.endsWith("?")) {
            url += "?";
        }
        url += createParamString(params);
        return url;
    }

    private static String createParamString(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> paramSet = params.entrySet();
        for (Map.Entry<String, String> enter : paramSet) {
            nameValuePairs.add(new BasicNameValuePair(enter.getKey(), enter.getValue()));
        }
        return URLEncodedUtils.format(nameValuePairs, "UTF-8");
    }

    private static Request createRequest(String url, Map<String, String> headers) {
        Request.Builder builder = new Request.Builder().url(url);
        if (!(headers == null) && !headers.isEmpty()) {
            builder.headers(Headers.of(headers));
        }
        return builder.build();
    }

    private static String getResponseContent(Request request) throws IOException {
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return getResponseContent(request);
    }

    public static String post(String url, Map<String, String> formEntries) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : formEntries.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return getResponseContent(request);
    }

    private static OkHttpClient createClient() {
        return new OkHttpClient();
    }

    public static void main(String[] args) throws IOException {
        String url = "https://kyfw.12306.cn/otn/";
//        Map<String, String> params = new HashMap<>();
//        params.put("wd", "java");

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());

            for (Certificate certificate : response.handshake().peerCertificates()) {
                System.out.println(CertificatePinner.pin(certificate));
            }
        } else {
            System.out.println("request failed!");
        }
    }
}
