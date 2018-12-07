package cn.peter.okhttp;

import okhttp3.*;

import java.io.IOException;

/**
 * @author Peter Yu 2018/12/6 14:18
 */
public class EventsDemo {

    private static OkHttpClient client = getClient();

    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .eventListener(new MyEventListener())
                .build();
    }

    public static class MyEventListener extends EventListener {

        @Override
        public void callStart(Call call) {
            System.out.println("Call start...");
            super.callStart(call);
        }

        @Override
        public void callEnd(Call call) {
            System.out.println("Call end...");
            super.callEnd(call);
        }
    }

    public static void main(String[] args) throws IOException {
        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        }
    }

}
