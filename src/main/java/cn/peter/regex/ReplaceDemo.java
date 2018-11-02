package cn.peter.regex;

import org.apache.commons.lang.StringUtils;

/**
 * @author Peter Yu 2018/10/17 19:12
 */
public class ReplaceDemo {

    public static void main(String[] args) {
        /**
       wwwww  *
         */
//        String content = "xixi;//* hahahha";
//        String content = "xixi;// ";
        String content = " * h ";
        boolean notBlank = notBlank(content);
        System.out.println(notBlank);
    }

    private static boolean notBlank(String content) {

        content = content.trim();

        // 单行注释判断
        int slashIndex = content.indexOf("//");
        if (slashIndex >= 0) {
            content = content.substring(slashIndex+2,content.length());
            return StringUtils.isNotBlank(content);
        }

        // 多行注释判断
        int leftIndex = content.indexOf("/*");
        if (leftIndex >= 0) {
            content = content.substring(leftIndex)
                             .replaceFirst("/\\*", "")
                             .replaceAll("\\*", "");
            return StringUtils.isNotBlank(content);
        }

        if (content.startsWith("*") && !content.startsWith("*/")) {
            content = content.replaceAll("\\*", "");
            return StringUtils.isNotBlank(content);
        }

        int rightIndex = content.indexOf("*/");
        if (rightIndex >= 0) {
            content = content.replaceFirst("\\*/", "")
                             .replaceAll("\\*", "");
            return StringUtils.isNotBlank(content);
        }

        return StringUtils.isNotBlank(content);
    }
}
