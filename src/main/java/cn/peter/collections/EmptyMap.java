package cn.peter.collections;


import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.map.*;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Peter Yu 2019/1/18 13:48
 */
public class EmptyMap {

    public static void main(String[] args) {
        LinkedMap<Integer,String> map = new LinkedMap<>();
        map.put(3,"a");
        map.put(2,"c");
        map.put(1,"b");

        System.out.println(map.get((Object) 3));

    }
}
