package cn.peter.collections;

import java.util.HashMap;

/**
 * @author Peter Yu
 * @date 2018/6/20 15:36
 */
public class MapNullKey {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(null,"Peter");
        map.put(1,"Marry");
        String nil = map.get(null);
        String one = map.get(1);
        System.out.println(nil);
        System.out.println(one);
    }
}
