package cn.peter.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Yu 2018/7/31 14:09
 */
public class LookingAtDemo {

    private static final String BASE_TYPE = "(?:int|float|double|char|wchar_t|bool|void)";
    private static final String ANY_CHAR = "[\\s\\S]";

    public static void main(String[] args) {

        String target =
                        "WriteLog( DEBUG_LVL0, \"pscode:[%ld],dbdate:[%s]\",pscode,dbdate);\n" +
                        "\n" +
                        "\t\tEXEC SQL SELECT count(*) INTO :count\n" +
                        "\t\t\tFROM T_PB_DELAY\n" +
                        "\t\t\tWHERE PSCODE = :pscode and substr(sdatetime,1,8) = :dbdate;\n" +
                        "\t\tif(SQLCODE)";
//        String target = "int EDWT_EB_YGT_CebThree(char *Fname, char *Fsize)";
        StringBuilder temp = new StringBuilder(target);

        int start = -1;
        int end = 0;

//        Pattern compile = Pattern.compile("(?<=[\\w]{1,50}\\([^\\n\\r]{1,50}\\)\n)[^\\{\\}\\/]*?(?=\n\\{)");
//        Pattern compile = Pattern.compile("(?:([^\\)\n][^\\(\\)\\{\\}]+;)|(#[^\n\r]+))+(?=\n\\{)");
//        Pattern compile = Pattern.compile("([^\\)\n][^\\(\\)\\{\\}]+;)(\n#[\\w]+)?(?=\n\\{)");
        Pattern compile = Pattern.compile("[^\n]"+ ANY_CHAR + "*?"+ "\\([\\s]*\\*[\\s]*\\)");
//        Pattern compile = Pattern.compile("[\\s]((?!char)[^\\s])+(?=[\\s][\\w]{1,50}\\([\\s\\S]{0,50}\\))");
//        Pattern compile = Pattern.compile("^[^\n\r]*"+BASE_TYPE+"[^\n\r]*\\([^\n\r]*\\)$");
        Matcher matcher = compile.matcher("");

//        findMatch(temp, matcher);
        lookingAtMatch(temp, matcher);
    }

    private static void findMatch(StringBuilder temp, Matcher matcher) {
        matcher.reset(temp);
        while (true){
            boolean find = matcher.find();
            if (find) {
                System.out.println(matcher.group());
                System.out.println("===============");
            }else {
                break;
            }
        }
    }

    private static void lookingAtMatch(StringBuilder temp, Matcher matcher) {
        int start;
        int end;
        while (true) {
            matcher.reset(temp);
            boolean lookingAt = matcher.lookingAt();
            if (lookingAt) {
                start = matcher.start();
                end = matcher.end();
                System.out.println(matcher.group());
                temp.delete(start,end);
            }else {
                if (temp.length() > 0) {
                    temp.deleteCharAt(0);
                }else {
                    break;
                }
            }
        }
    }
}
