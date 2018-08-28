package cn.peter.debug;

/**
 * @author Peter Yu
 * @date 2018/5/22 10:57
 */
public class ThreadDebugDemo {

    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread thread1 = new Thread(myRun, "thread1");
        Thread thread2 = new Thread(myRun, "thread2");
        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getName()+":=======================");
    }
}

class MyRun implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":=======================");
    }
}
