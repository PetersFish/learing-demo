package cn.peter.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Yu 2018/11/16 11:37
 */
public class DenyDemo {

    public static void main(String[] args) {
        String a = "+\"// hahah";
        String b = "+\"; // hahah";

        String regex = "[\\s\\S]((?!\"[^;]).)*[^\"]*//[\\s\\S]*";
        boolean matches = Pattern.compile(regex).matcher(a).matches();
        boolean matches2 = Pattern.compile(regex).matcher(b).matches();
        System.out.println(matches);
        System.out.println(matches2);
    }
}
