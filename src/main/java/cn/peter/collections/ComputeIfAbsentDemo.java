package cn.peter.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author Peter Yu 2018/10/30 10:28
 */
public class ComputeIfAbsentDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Peter", 31);
        map.computeIfAbsent("Marry", k -> 24);
        Integer integer = map.computeIfPresent("Peter",(k, v)->28);
        System.out.println(map);
    }
}
