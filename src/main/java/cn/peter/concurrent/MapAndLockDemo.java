package cn.peter.concurrent;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Peter Yu
 * @date 2018/5/23 18:34
 */
public class MapAndLockDemo {



    //建立Map，将元素放进去
    static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    //并考虑将键值对放入entry
    static LinkedBlockingQueue<Map.Entry> entries = new LinkedBlockingQueue<>();

    static class MyRun implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(20);
                Map.Entry entry = entries.take();
                System.out.println(Thread.currentThread().getName()+":==========:"+entry+":==========:"+new Date().getTime()/1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyRun myRun = new MyRun();
        map.put("class1","Peter");
        map.put("class2","Jack");
        map.put("class4","Marry");
        map.put("class4","Lily");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            entries.put(next);
        }
        System.out.println(entries);
        /*for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(myRun, "thread" + i);
            thread.start();

        }*/
    }
}


