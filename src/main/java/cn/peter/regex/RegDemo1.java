package cn.peter.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Yu 2018/7/23 14:46
 */
public class RegDemo1 {

    public static void main(String[] args) {

        String s = "int EDWT_EB_YGT_CebThree(char *Fname, char *Fsize)\n" +
                   "int aaaa;\n" +
                   "{\n" +
                   "\n" +
                   "return 0;\n" +
                   "}" +
                   "int EDWT_EB_YGT_CebThree(char *Fname, char *Fsize)\n" +
                   "int bbbbb;\n" +
                   "{\n" +
                   "\n" +
                   "return 0;\n" +
                   "}";

        StringBuilder sb = new StringBuilder(s);

//        Pattern compile = Pattern.compile("(?<=[\\w]{1,50}\\([^\\n\\r]{1,50}\\)\n)[^\\{\\}\\/]*?(?=\n\\{)");
        Pattern compile = Pattern.compile("[\\w]{1,50}\\([^\\n\\r]{1,50}\\)\n[^\\{\\}\\/]*?(?=\n\\{)");
        Matcher matcher = compile.matcher(s);
        String[] split = compile.split(s);
        boolean lookingAt = matcher.lookingAt();
        System.out.println(lookingAt);
        while (matcher.find()) {

            int end = matcher.end();
            int start = matcher.start();

            String substring = s.substring(start, end);
            System.out.println(substring);
        }

//        System.out.println(Arrays.toString(split));
    }
}
