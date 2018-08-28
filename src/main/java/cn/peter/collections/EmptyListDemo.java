package cn.peter.collections;

import java.util.Collections;
import java.util.List;

/**
 * @author Peter Yu
 * @date 2018/5/9 14:22
 */
public class EmptyListDemo {

    public static void main(String[] args) {
        List<String> list = Collections.emptyList();
        System.out.println(list);
        boolean peter = list.add("peter");
        System.out.println(list);
    }
}
