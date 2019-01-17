package cn.peter.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Peter Yu 2019/1/17 20:38
 */
public class ListToSet {

    public  static <T> Set<T> listToSet(List<T> list){
        Set<T> set = new HashSet<>();
        set.addAll(list);
        return set;
    }
}
