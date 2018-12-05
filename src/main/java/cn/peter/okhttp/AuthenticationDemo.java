package cn.peter.okhttp;

import okhttp3.*;

import java.io.IOException;

/**
 * @author Peter Yu 2018/12/5 11:53
 */
public class AuthenticationDemo {
    private static final OkHttpClient client;

    private static Request request;

    static {
        client = new OkHttpClient.Builder()
                .authenticator(new Authenticator() {
                    @Override public Request authenticate(Route route, Response response) throws IOException {
                        if (response.request().header("Authorization") != null) {
                            return null; // Give up, we've already attempted to authenticate.
                        }

//                        System.out.println("Authenticating for response: " + response);
//                        System.out.println("Challenges: " + response.challenges());
//                        String credential = Credentials.basic("jesse", "password1");
//                        return response.request().newBuilder()
//                                       .header("Authorization", credential)
//                                       .build();
                        return null;
                    }
                })
                .build();

        String credential = Credentials.basic("jesse", "password1");
        request = new Request.Builder()
                .url("http://publicobject.com/secrets/hellosecret.txt")
                .header("Authorization", credential)
                .build();
    }

    public static void run() throws Exception {


        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        }
    }

    public static void main(String[] args) throws Exception {
        run();
        run();
    }
}
