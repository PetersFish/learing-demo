package cn.peter.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.concurrent.TimeUnit;

/**
 * @author Peter Yu 2018/12/5 9:57
 */
public class TimeOutDemo {
    private final OkHttpClient client;

    public TimeOutDemo() throws Exception {
        client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS) // can be changed for test
                .build();
    }

    public void run() throws Exception {
        Request request = new Request.Builder()
                .url("http://httpbin.org/delay/2") // This URL is served with a 2 second delay.
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("Response completed: " + response);
        }
    }

    public static void main(String[] args) throws Exception {
        new TimeOutDemo().run();
    }
}
