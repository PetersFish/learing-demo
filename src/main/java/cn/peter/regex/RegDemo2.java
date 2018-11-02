package cn.peter.regex;

import java.util.regex.Matcher;

/**
 * @author Peter Yu 2018/8/2 17:39
 */
public class RegDemo2 {

    public static void main(String[] args) {

        String code = " memset( final, 0, sizeof( final));/* lalalalalal */";

        Matcher startMatcher = CommentMatcher.START_MATCHER.resetMatcher(code);
        boolean matches = startMatcher.matches();
        System.out.println(matches);

        Matcher matcher = CommentMatcher.END_MATCHER.resetMatcher(code);
        boolean matches1 = matcher.matches();
        System.out.println(matches1);
    }
}
