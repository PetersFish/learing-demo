package cn.peter.utils;

import okhttp3.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Peter Yu 2018/12/3 17:49
 */
public class HttpClientUtils {

    private static final OkHttpClient client = createClient();

    private static final OkHttpClient cacheClient;

    static {
        int size = 10*1024*1024;
        File file = new File("temp/cache");
        Cache cache = new Cache(file, size);
        cacheClient = new OkHttpClient.Builder()
                .cache(cache)
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
        String url = "http://www.baidu.com/s";
        Map<String, String> params = new HashMap<>();
        params.put("wd", "java");

        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        String response1Body;
        try (Response response1 = cacheClient.newCall(request).execute()) {
            if (!response1.isSuccessful()) throw new IOException("Unexpected code " + response1);

            response1Body = response1.body().string();
            System.out.println("Response 1 response:          " + response1);
            System.out.println("Response 1 cache response:    " + response1.cacheResponse());
            System.out.println("Response 1 network response:  " + response1.networkResponse());
        }

        String response2Body;
        try (Response response2 = cacheClient.newCall(request).execute()) {
            if (!response2.isSuccessful()) throw new IOException("Unexpected code " + response2);

            response2Body = response2.body().string();
            System.out.println("Response 2 response:          " + response2);
            System.out.println("Response 2 cache response:    " + response2.cacheResponse());
            System.out.println("Response 2 network response:  " + response2.networkResponse());
        }

        System.out.println("Response 2 equals Response 1? " + response1Body.equals(response2Body));
    }
}
