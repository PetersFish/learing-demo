package cn.peter.concurrent.timetask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Peter Yu
 * @date 2018/5/9 19:49
 */
public class TimerDemo {

    public static class MyTimeTask extends TimerTask{

        public void run() {
            System.out.println("Bombing!");
            //new Timer().schedule(new MyTimeTask(),2000);
        }
    }
    public static void main(String[] args) {
        new Timer().schedule(new MyTimeTask(),5000,6000);
        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
