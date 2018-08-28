package cn.peter.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Yu 2018/8/2 17:39
 */
public enum CommentMatcher {
    START_MATCHER("[\\s\\S&&[^\n]]*(/\\*)[\\s\\S&&[^\n]]*"),
    END_MATCHER("[\\s\\S&&[^\n]]*(\\*/)[\\s\\S&&[^\n]]*");

    private Matcher matcher;

    CommentMatcher(String reg) {
        matcher = Pattern.compile(reg).matcher("");
    }

    public Matcher getMatcher(){
        return matcher;
    }

    public Matcher getMatcher(String target){
        return matcher.reset(target);
    }
}
