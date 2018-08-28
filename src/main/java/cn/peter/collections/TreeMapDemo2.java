package cn.peter.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Peter Yu 2018/7/17 1:48
 */
public class TreeMapDemo2 {

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1,"Peter");
        treeMap.put(2,"Peter");
        treeMap.put(4,"Peter");
        System.out.println(treeMap);
        Map.Entry<Integer, String> entry = treeMap.pollFirstEntry();
        System.out.println(entry);
        System.out.println(treeMap);
    }
}
