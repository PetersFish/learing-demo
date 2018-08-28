package cn.peter.annotation;

import javax.annotation.Nonnull;

/**
 * @author Peter Yu
 * @date 2018/6/6 16:46
 */
public class NonnullDemo {

    public static void main(String[] args) {
        String string = null;
        show(string);
        System.out.println("This is dev!");

    }

    public static void show(@Nonnull String str){
        System.out.println(str);
    }
}
