package cn.peter.regex;

/**
 * @author Peter Yu 2018/8/2 19:12
 */
public class RegDemo3 {

    public static void main(String[] args) {

        String comment = "/*ffffff*/";/*hahahahha
        biibli
        */
        boolean startsWith = comment.startsWith("/\\*");
        System.out.println(startsWith);
    }
}
