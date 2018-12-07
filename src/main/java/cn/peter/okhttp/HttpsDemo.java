package cn.peter.okhttp;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;

import java.util.Arrays;

/**
 * @author Peter Yu 2018/12/6 10:37
 */
public class HttpsDemo {

    OkHttpClient client = new OkHttpClient.Builder()
            .connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS))
            .build();
}
