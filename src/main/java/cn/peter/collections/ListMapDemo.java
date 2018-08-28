package cn.peter.collections;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.ListMultimap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Peter Yu 2018/7/17 1:47
 */
public class ListMapDemo {

    public static void main(String[] args) {

        SortedLinkedList<Integer> list = new SortedLinkedList<>(false);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);
        System.out.println(list);
        int i = list.hasElement(2);
        System.out.println(i);
        System.out.println("getLast:"+list.getLast());
        System.out.println(list);
        System.out.println("pollLast:"+list.pollLast());
        System.out.println(list);
        System.out.println("getFirst:"+list.getFirst());

    }

    public static class SortedLinkedList<T> {

        private Comparator<T> comparator;

        private LinkedList<T> list = new LinkedList<>();

        private boolean accend = true;

        public SortedLinkedList() {}

        public SortedLinkedList(Comparator<T> comparator){
            this.comparator = comparator;
        }

        public SortedLinkedList(boolean accend) {
            this.accend = accend;
        }

        public boolean add(T target){

            if(accend){
                if(list.isEmpty()){
                    return list.add(target);
                }else {
                    if(comparator != null){
                        for (int i = list.size()-1; i >= 0; i--) {
                            if(comparator.compare(target,list.get(i)) < 0){
                                if(i == 0){
                                    list.add(i,target);
                                    return true;
                                }
                                continue;
                            }else {
                                list.add(i+1,target);
                                return true;
                            }

                        }
                    }else if(target instanceof Comparable) {
                        Comparable comparable = (Comparable) target;
                        for (int i = list.size()-1; i >= 0; i--) {

                            if(comparable.compareTo(list.get(i)) < 0){
                                if(i == 0){
                                    list.add(i,target);
                                    return true;
                                }
                                continue;
                            }else {
                                list.add(i+1,target);
                                return true;
                            }

                        }
                    }
                }
            }else {
                if(list.isEmpty()){
                    return list.add(target);
                }else {
                    if(comparator != null){
                        for (int i = 0; i < list.size(); i++) {
                            if(comparator.compare(target,list.get(i)) >= 0){
                                list.add(i,target);
                                return true;
                            }else if(i == list.size()-1){
                                list.add(i+1,target);
                                return true;
                            }
                        }
                    }else if(target instanceof Comparable){
                        Comparable comparable = (Comparable) target;
                        for (int i = 0; i < list.size(); i++) {
                            if(comparable.compareTo(list.get(i)) >= 0){
                                list.add(i,target);
                                return true;
                            }else if(i == list.size()-1){
                                list.add(i+1,target);
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }


        public T getFirst(){
            return list.getFirst();
        }

        public T getLast(){
            return list.getLast();
        }

        public T pollLast(){
            return list.pollLast();
        }

        public Iterator<T> iterator(){
            return list.iterator();
        }

        public int hasElement(T t) {
            if(list.size() == 0){
                return -1;
            }

            for (int i = list.size()-1; i >= 0; i--) {
                if(t instanceof Comparable){
                    Comparable comparable = (Comparable) t;
                    if(comparable.compareTo(list.get(i)) == 0){
                        return i;
                    }
                }
            }
            return -1;
        }

        public T remove(int index){
            return list.remove(index);
        }

        public boolean isAccend() {
            return accend;
        }

        public void setAccend(boolean accend) {
            this.accend = accend;
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }
}
