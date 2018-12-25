package cn.peter.okhttp;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Peter Yu 2018/12/10 14:37
 */
public class RedirectDemo {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(new Interceptor() {
//
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        Request request = chain.request();
//                        List<String> cookies = request.headers("COOKIE");
//                        Response response = chain.proceed(request);
//                        return response.newBuilder()
//                                       .addHeader("COOKIE",
//                                                  cookies.toString().substring(1, cookies.toString().length() - 1)).build();
//                    }
//                })
                .build();

        Request request = new Request.Builder()
                .url("http://www.publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Example")
                .addHeader("COOKIE", "MyCookie1=123")
                .addHeader("COOKIE", "MyCookie2=456")
                .build();

        Response response = client.newCall(request).execute();
        List<String> cookies = response.headers("COOKIE");

        System.out.println("final cookies:" + cookies);

        response.body().close();
    }
}
