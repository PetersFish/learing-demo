package cn.peter.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import okhttp3.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * @author Peter Yu 2018/12/7 10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpRunner<Body> implements HttpMethod {

    private static final OkHttpClient client = new OkHttpClient();

    private String url;

    @Builder.Default
    private String mode = GET;

    private Map<String, String> cookiesMap;

    private Map<String, String> headersMap;

    private String proxy;

    private String mediaType;

    private Body mediaContent;

    public Response run() throws IOException {

        OkHttpClient.Builder clientBuilder = client.newBuilder();
        addProxy(clientBuilder, proxy);
        OkHttpClient myClient = clientBuilder.build();

        RequestBody requestBody = parseRequestBody(mediaType, mediaContent);

        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .headers(Headers.of(headersMap))
                .method(mode.toUpperCase(), requestBody);

        addCookies(requestBuilder, cookiesMap);

        Request request = requestBuilder.build();
        return myClient.newCall(request).execute();
    }

    /**
     * 如果存在代理，加入代理
     *
     * @param clientBuilder
     * @param proxy
     */
    private void addProxy(OkHttpClient.Builder clientBuilder, String proxy) {
        if (proxy == null) {
            return;
        }
        byte[] ip = new byte[4];
        String[] arr = proxy.split("\\.");
        for (int i = 0; i < 4; i++) {
            int tmp = Integer.valueOf(arr[i]);
            ip[i] = (byte) tmp;
        }
        try {
            clientBuilder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(InetAddress.getByAddress(ip), 80)));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成请求体
     *
     * @param mediaType
     * @param mediaContent
     * @return
     */
    private RequestBody parseRequestBody(String mediaType, Body mediaContent) {

        return null;
    }

    private void addCookies(Request.Builder requestBuilder, Map<String, String> cookiesMap) {
        if (cookiesMap == null) {
            return;
        }
        String cookies = cookiesMap.toString();
        requestBuilder.addHeader("Cookie", cookies.substring(1, cookies.length() - 1));
    }

}
