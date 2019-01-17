package cn.peter.concurrent;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Peter Yu 2018/11/12 16:42
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        String local = stringLocal.get();
        if (local == null) {
            stringLocal.set("Hello");
        }
        stringLocal.remove();
        System.out.println(stringLocal.get());
    }
}
