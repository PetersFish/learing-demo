package cn.peter.collections;

import java.util.HashMap;

/**
 * @author Peter Yu 2018/7/25 11:07
 */
public class MapDemo {

    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        map1.put("Peter",31);
        map1.put("Marry",26);
        map2.put("Marry",26);
//        map1.clear();
//        map1.putAll(map2);
        map1 = map2;
        System.out.println(map1);
    }
}
