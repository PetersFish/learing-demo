package cn.peter.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Peter Yu
 * @date 2018/5/11 9:19
 */
public class KeySetDemo {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("Peter",31);
        map.put("Lily",22);
        map.put("Mary",50);
        Set<String> stringSet = map.keySet();
        //stringSet.add("David");
        stringSet.remove("Peter");
        stringSet.clear();
        /*Collection<Integer> values = map.values();
        values.remove(31);
        values.clear();*/
        System.out.println(map);
    }
}
