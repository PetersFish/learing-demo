package cn.peter.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Peter Yu 2018/12/7 12:38
 */
public class MapToString {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Peter","31");
        map.put("Lily","31");

        System.out.println(map.toString().substring(1, map.toString().length()-1));
    }
}
