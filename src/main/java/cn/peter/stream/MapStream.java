package cn.peter.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Peter Yu 2019/1/25 16:25
 */
public class MapStream {

    public static void main(String[] args) {
        Map<String, Integer> map = createMap();
        Set<String> set = map.keySet();

//        testMap(map);
//        testMapCompute(map);
//        testComputeSet(set);
//        testSetToMap(set);
//        testEntryRemove(map);
        testSelectMapAndToSet(map);
    }

    private static void testSelectMapAndToSet(Map<String, Integer> map) {
        Set<String> set = map.entrySet().stream()
                                 .filter(e -> e.getValue() < 20)
                                 .map(e -> e.getKey())
                                 .collect(Collectors.toSet());
        System.out.println(set);
    }

    private static void testEntryRemove(Map<String, Integer> map) {
        Map<String, Integer> newMap = map.entrySet().stream()
                                         .filter(e -> e.getValue() < 20)
                                         .collect(Collectors.toMap(t -> t.getKey(), v -> v.getValue()));
        System.out.println(newMap);
    }

    private static void testSetToMap(Set<String> set) {
        Map<String, String> map = set.stream().collect(Collectors.toMap(t -> t, v -> v + "1"));
        System.out.println(map);
    }

    private static void testMapCompute(Map<String, Integer> map) {
        map.forEach((k, v) -> {
            map.compute(k, (key, value) -> value + 1);
        });
        System.out.println(map);
    }

    private static void testComputeSet(Set<String> set) {
        Set<String> collect = set.stream().map(k -> k + "1").collect(Collectors.toSet());
        System.out.println(collect);
    }

    private static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("peter", 31);
        map.put("marry", 12);
        map.put("jack", 24);
        map.put("wangcai", 66);
        map.put("xiaoqiang", 5);
        return map;
    }

    private static void testMap(Map<String, Integer> map) {
        map.forEach((k, v) -> {
            map.put(k, v * 2);
        });
        System.out.println(map);
    }
}
