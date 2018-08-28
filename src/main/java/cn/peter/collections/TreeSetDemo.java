package cn.peter.collections;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Peter Yu 2018/7/18 14:27
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(1);
        integers.add(4);
        integers.add(2);
        integers.add(3);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }
}
