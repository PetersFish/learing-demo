package cn.peter.collections;

import java.util.HashMap;

/**
 * @author Peter Yu 2018/9/21 14:37
 */
public class TimeConsume {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            map.put("haha"+i,"xixi"+i);
        }

        long start = System.currentTimeMillis();
        boolean b = map.containsKey(10001);
        long end = System.currentTimeMillis();
        String s = map.get(10002);
        long end2 = System.currentTimeMillis();

        System.out.println("contains time:"+(end - start));
        System.out.println("get time:"+(end2 - end));

    }
}
