package cn.peter.concurrent;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Peter Yu 2018/11/12 16:42
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Set<Integer>> setThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

    }
}
