package cn.peter.collections;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Peter Yu 2018/7/17 9:47
 */
public class LinkedListDemo2 {

    public static void main(String[] args) {
        LinkedStack<String> list = new LinkedStack<>();
        list.push("1");
        list.push("22");
        list.push("22");
        list.push("13");
        list.push("44");
        System.out.println(list);


    }
}
