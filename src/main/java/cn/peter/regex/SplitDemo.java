package cn.peter.regex;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Yu 2018/11/16 19:37
 */
public class SplitDemo {

    public static void main(String[] args) throws IOException {

        Pattern oldPath = Pattern.compile("(?<=([\\-]{3})).*(?=([(]revision))");
        Pattern newPath = Pattern.compile("(?<=([+]{3})).*(?=([(]revision))");
        Pattern fileModified = Pattern.compile("[^=]+(?=([=]))");
        Pattern sigleDiff = Pattern.compile("(Index:)((?!(Index:)).)*(?=(Index:))");

        String diffText = "Index: D:/SvnTest/total/svn-demo2/branches/branch01/src/main/java/cn/peter/demo/Demo4.java\n" +
                          "===================================================================\n" +
                          "--- D:/SvnTest/total/svn-demo2/branches/branch01/src/main/java/cn/peter/demo/Demo4.java\t(revision 27)\n" +
                          "+++ D:/SvnTest/total/svn-demo2/branches/branch01/src/main/java/cn/peter/demo/Demo4.java\t(revision 29)\n" +
                          "@@ -1,15 +0,0 @@\n" +
                          "-package cn.peter.demo;\n" +
                          "-\n" +
                          "-/**\n" +
                          "- * @author Peter Yu 2018/11/15 10:17\n" +
                          "- */\n" +
                          "-public class Demo4 {\n" +
                          "-\n" +
                          "-    public static void main(String[] args) {\n" +
                          "-\n" +
                          "-        // 2018-11-15 for merge test\n" +
                          "-        System.out.println(\"branch01\");\n" +
                          "-        System.out.println(\"branch01\");\n" +
                          "-        System.out.println(\"branch01\");\n" +
                          "-    }\n" +
                          "-}\n" ;

        /*Pattern pattern = Pattern.compile("(?<=Index:)[\\s\\S]*(?=(Index:))");
        Matcher matcher = pattern.matcher(diffText);
        while (matcher.find()){
            String group = matcher.group();
            System.out.println(":------------------------------------------------------------:");
            System.out.println(group);
        }*/

        Matcher matcher = fileModified.matcher(diffText);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        /*StringReader reader = new StringReader(text);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String buffer = "";
                    int i = 0;
                    while ((buffer = bufferedReader.readLine()) != null) {
                        switch (i){
                            case 0:
                                diffEntry.setFileName(buffer);
                                break;
                            case 2:
                                Matcher oldMatcher = oldPathPattern.matcher(buffer);
                                if (oldMatcher.find()) {
                                    diffEntry.setOldPath(oldMatcher.group());
                                }
                                break;
                            case 3:
                                Matcher newMatcher = newPathPattern.matcher(buffer);
                                if (newMatcher.find()) {
                                    diffEntry.setNewPath(newMatcher.group());
                                }
                        }
                        i++;
                    }*/
    }
}
