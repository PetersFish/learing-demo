package cn.peter.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Peter Yu 2018/11/7 14:47
 */
public class ReturnNullDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Integer integer = map.get("Peter");
        System.out.println(integer);
    }
}
