package cn.peter.okhttp;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

/**
 * @author Peter Yu 2018/12/10 14:34
 */
public class CookieInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        List<String> cookie = request.headers("COOKIE");
        System.out.println("cookies:"+cookie);
        return chain.proceed(request);
    }
}
