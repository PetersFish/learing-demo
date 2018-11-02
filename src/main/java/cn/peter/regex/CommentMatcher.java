package cn.peter.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Yu 2018/8/2 17:39
 */
public enum CommentMatcher {

    START_MATCHER("[\\s\\S&&[^\n]]*([^\"]*/\\*)[\\s\\S&&[^\n]]*"),
    END_MATCHER("[\\s\\S&&[^\n]]*(\\*/)[\\s\\S&&[^\n]]*"),
    SLASH_MATCHER("[\\s\\S&&[^\n]]*//[\\s\\S&&[^\n]]*[\\S]+");

    private Matcher matcher;

    CommentMatcher(String reg) {
        matcher = Pattern.compile(reg).matcher("");
    }

    public Matcher getMatcher(){
        return matcher;
    }

    public Matcher resetMatcher(String target){
        return matcher.reset(target);
    }

    public static void main(String[] args) {
        String code = "AegisUser aegisUser = (AegisUser) rundata.getRequest().getAttribute(SSOConstants.AEGIS_USER);\n" +
                      "\t\t\t// if (aegisUser == null) {\n" +
                      "\t\t\t// return;\n" +
                      "\t\t\t// }\n" +
                      "\t\t\t//判断公司Id\n" +
                      "\t\t\tif (buId == null && aegisUser != null) {\n" +
                      "\t\t\t\tbuId = aegisUser.getGroupId().intValue();\n" +
                      "\t\t\t} else {\n" +
                      "\t\t\t\tbuId = 1;\n" +
                      "\t\t\t}";
        Matcher matcher = CommentMatcher.SLASH_MATCHER.resetMatcher(code);
        while (matcher.find()){
            System.out.println(matcher.group());;
        }

    }
}
