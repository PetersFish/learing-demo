package cn.peter.stream;

import com.google.common.collect.ImmutableList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Peter Yu 2019/1/25 19:39
 */
public class CollectDemo {

    public static void main(String[] args) {
        Map<String, List<Integer>> myScoreMap = new HashMap<>();
        myScoreMap.put("peter", ImmutableList.of(1, 3, 5, 7));
        myScoreMap.put("marry", ImmutableList.of(2, 4, 6, 8));

        LinkedList<Integer> list = myScoreMap.values().stream()
                                             .collect(LinkedList::new,
                                                      LinkedList::addAll,
                                                      LinkedList::addAll);
        System.out.println(list);
    }
}
