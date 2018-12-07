package cn.peter.wildcards;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Peter Yu 2018/12/6 17:59
 */
public class SuperGarden {

    static <T> List<T> createList(Class<T> clazz){
        List<T> list = new LinkedList<>();
        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = createList(Apple.class);
        List<Pear> list1 = createList(Pear.class);
    }
}
