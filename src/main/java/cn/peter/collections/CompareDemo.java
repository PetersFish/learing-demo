package cn.peter.collections;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Peter Yu 2018/8/21 17:25
 */
public class CompareDemo {

    public static void main(String[] args) {
        new TreeSet<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
