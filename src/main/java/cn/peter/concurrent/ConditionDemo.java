package cn.peter.concurrent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Peter Yu 2018/11/28 10:36
 */
public class ConditionDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Display bigDisplay = new BigDisplay();
        Display smallDisplay = new SmallDisplay();

        Runnable bigJob = MyJob.builder()
                              .lock(lock)
                              .condition(condition)
                              .display(bigDisplay)
                              .build();
        Runnable smallJob = MyJob.builder()
                              .lock(lock)
                              .condition(condition)
                              .display(smallDisplay)
                              .build();
        Thread big1 = new Thread(bigJob);
        Thread big2 = new Thread(bigJob);
        Thread small1 = new Thread(smallJob);
        Thread small2 = new Thread(smallJob);
        big1.start();
        big2.start();
//        small1.start();
//        small2.start();

    }

    public interface Display {

        void show();
    }

    public static class BigDisplay implements Display {

        @Override
        public void show() {
            for (int i = 0; i < 10; i++) {
                System.out.println("big sleep...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("big wake up!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class SmallDisplay implements Display {

        @Override
        public void show() {
            for (int i = 0; i < 10; i++) {
                System.out.println("small sleep...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("small wake up!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MyJob implements Runnable {

        private Display display;

        private Lock lock;

        private Condition condition;

        @Override
        public void run() {
//            display.show();
            lock.lock();
            try {
                if (display instanceof BigDisplay) {
                    lock.unlock();
                }
                display.show();
            } finally {
                lock.unlock();
            }
        }
    }
}
