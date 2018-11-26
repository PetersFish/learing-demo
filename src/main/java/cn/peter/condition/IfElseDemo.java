package cn.peter.condition;

import java.util.Random;

/**
 * @author Peter Yu 2018/11/19 11:10
 */
public class IfElseDemo {

    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(10);
        if (i == 5) {
            System.out.println("You win!");
            System.out.println("You win2!");
        }else {
            System.out.println("You lose!");
        }
    }
}
