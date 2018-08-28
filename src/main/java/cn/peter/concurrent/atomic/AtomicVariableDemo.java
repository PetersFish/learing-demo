package cn.peter.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Peter Yu
 * @Date 2018/5/4 19:15
 */
public class AtomicVariableDemo {

    static AtomicInteger count = new AtomicInteger(300);
    //static int count = 300;

    static class TicketSalor implements Runnable{

        public void run() {
            try {
                saleTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void saleTicket() throws InterruptedException {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(10);
                count.addAndGet(-1);
                //count --;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new TicketSalor();
        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");
        Thread t3 = new Thread(r,"线程3");
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(2000);
        System.out.println(count.get());
    }
}
