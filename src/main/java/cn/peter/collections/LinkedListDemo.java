package cn.peter.collections;

import java.util.LinkedList;

/**
 * @author Peter Yu
 * @date 2018/6/8 10:02
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(null);
        list.add(null);
        System.out.println(list);

    }
}
