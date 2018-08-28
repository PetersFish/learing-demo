package cn.peter.concurrent;

/**
 * @author Peter Yu
 * @date 2018/5/11 11:53
 */
public class VolatileDemo {

    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        Thread t1 = new Thread(sellTicket, "aaaaa");
        Thread t2 = new Thread(sellTicket, "bbbbb");
        Thread t3 = new Thread(sellTicket, "ccccc");
        t1.start();
        t2.start();
        t3.start();
    }
}

class SellTicket implements Runnable{

    private volatile int count = 0;
    private volatile boolean flag = true;
    private Object object = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (object){
                count++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"售出一张票，已卖："+count);
        }
    }
}
