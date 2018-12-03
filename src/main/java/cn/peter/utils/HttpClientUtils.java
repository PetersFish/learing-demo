package cn.peter.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author Peter Yu 2018/12/3 17:49
 */
public class HttpClientUtils {

    private HttpClientUtils() {
    }

    private static OkHttpClient client = new OkHttpClient();

    public static String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    public static void main(String[] args) throws IOException {
        String url = "http://www.baidu.com";
        String content = get(url);
        System.out.println(content);
    }
}
