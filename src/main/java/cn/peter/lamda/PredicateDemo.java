package cn.peter.lamda;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Peter Yu 2019/1/28 10:42
 */
public class PredicateDemo {

    public static class MyCollection<R>{

        private Collection<R> collection;

        public MyCollection(Collection<R> collection) {
            this.collection = collection;
        }

        public Collection<R> filter(Predicate<R> t){
            collection.removeIf(r -> !t.test(r));
            return collection;
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>(Arrays.asList(1,3,5,7,2,4));
        MyCollection<Integer> myCollection = new MyCollection<>(list);
        Collection<Integer> filter = myCollection.filter(t -> t > 4);
        System.out.println(filter);

    }
}
