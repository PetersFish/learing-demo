package cn.peter.number;

import java.util.Objects;

/**
 * @author Peter Yu 2018/7/19 0:50
 */
public class IntegerDemo2 {

    public static void main(String[] args) {
        Integer i = 1000;
        short j = 1000;
        Integer k = j + 0;

        System.out.println("i.equals(j):"+i.equals(j));
        System.out.println("i == j:"+(i == j));
        System.out.println("i.equals(k):"+i.equals(k));
        System.out.println("i == k:"+(i == k));

        Objects.equals(i,k);

    }
}
