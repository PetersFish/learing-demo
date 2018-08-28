package cn.peter.collections;

import cn.peter.pojo.Person;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author Peter Yu 2018/7/13 14:07
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        Person peter = new Person("Peter", 1);
        Person marry = new Person("Marry", 2);
        Person jack = new Person("Jack", 3);
        TreeMap<Integer, Person> treeMap = new TreeMap<>();
        treeMap.put(3,peter);
        treeMap.put(2,marry);
        treeMap.put(1,jack);
        treeMap.put(4,jack);
        System.out.println(treeMap);
        Integer integer = treeMap.firstKey();
        System.out.println(integer);
        Integer key = treeMap.lastKey();
        System.out.println(key);
        for (Map.Entry<Integer, Person> entry : treeMap.entrySet()) {
            Integer key1 = entry.getKey();
            Person value = entry.getValue();
            System.out.println(key1+":"+value);
        }
        NavigableMap<Integer, Person> navigableMap = treeMap.descendingMap();
        for (Map.Entry<Integer, Person> entry : navigableMap.entrySet()) {
            Integer key1 = entry.getKey();
            Person value = entry.getValue();
            System.out.println(key1+":"+value);
        }
    }
}
