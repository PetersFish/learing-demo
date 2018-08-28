package cn.peter.collections;

import java.util.HashSet;

/**
 * @author Peter Yu
 * @date 2018/6/13 19:43
 */
public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<Integer> integers = new HashSet<>();
        boolean add = integers.add(1);
        boolean add2 = integers.add(1);
        System.out.println(add+":"+add2);

    }
}
