package cn.peter.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Peter Yu
 * @date 2018/5/11 13:42
 */
public class VolatileDemo2 {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Factory.Terminator terminator = factory.getTerminator();
        Factory.Worker worker = factory.getWorker();

        Thread t1 = new Thread(worker, "印度阿三");
        Thread t2 = new Thread(terminator, "监工");
        t1.start();
        t2.start();

    }
}



class Factory{
    private boolean stop = false;

    private Worker worker = new Worker();
    private Terminator terminator = new Terminator();

    public Worker getWorker() {
        return worker;
    }

    public Terminator getTerminator() {
        return terminator;
    }

    class Worker implements Runnable{

        private int count = 0;

        @Override
        public void run() {
            while (!stop){
                count++;
                System.out.println(Thread.currentThread().getName()+"I'm working!---"+count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Terminator implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop = true;

            try {
                throw new Exception("监工挂啦！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
