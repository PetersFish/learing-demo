package cn.peter.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Peter Yu 2018/9/27 16:25
 */
public class HttpClient {

    public static String get(String url){
        try {
            boolean connect = false;
            URL u = new URL(url);
            try {
                HttpURLConnection uConnection = (HttpURLConnection) u.openConnection();
                try {
                    uConnection.connect();
                    System.out.println(uConnection.getResponseCode());
                    connect = true;
                    InputStream is = uConnection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    StringBuilder sb = new StringBuilder();
                    while(br.read() != -1){
                        sb.append(br.readLine());
                    }
                    String content = new String(sb);
                    content = new String(content.getBytes("GBK"), "ISO-8859-1");
                    System.out.println(content);
                    br.close();
                } catch (Exception e) {
                    connect = false;
                    e.printStackTrace();
                    System.out.println("connect failed");
                }
            } catch (IOException e) {
                System.out.println("build failed");
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            System.out.println("build url failed");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        get("http://www.baidu.com");
    }
}
