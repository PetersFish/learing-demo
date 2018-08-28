package cn.peter.collections;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Peter Yu
 * @date 2018/6/25 18:34
 */
public class LinkedListInterator {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Iterator<Integer> iterator = list.descendingIterator();iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}
