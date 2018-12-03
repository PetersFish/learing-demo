package cn.peter.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Peter Yu 2018/11/28 16:52
 */
public class AddAllDemo {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("Peter");
        Set<String> set2 = new HashSet<>();
        set2.add("Peter");
        set1.addAll(set2);
        System.out.println(set1);
    }
}
