package cn.peter.regex;

import cn.peter.kit.DiffKit;
import cn.peter.kit.FileStatus;

/**
 * @author Peter Yu 2018/8/2 19:12
 */
public class RegDemo4 {

    public static void main(String[] args) {

        String diffTxt = "Index: D:/TestEnv/svn-demo2-wangcai/svn-demo2/branches/branch02/src/main/java/cn/peter/demo/Demo4.java\n" +
                         "===================================================================\n" +
                         "--- D:/TestEnv/svn-demo2-wangcai/svn-demo2/branches/branch02/src/main/java/cn/peter/demo/Demo4.java\t(revision 0)\n" +
                         "+++ D:/TestEnv/svn-demo2-wangcai/svn-demo2/branches/branch02/src/main/java/cn/peter/demo/Demo4.java\t(revision 36)\n" +
                         "@@ -0,0 +1,11 @@\n" +
                         "+package cn.peter.demo;\n" +
                         "+\n" +
                         "+/**\n" +
                         "+ * @author Peter Yu 2018/11/8 15:02\n" +
                         "+ */\n" +
                         "+public class Demo4 {\n" +
                         "+\n" +
                         "+    public static void main(String[] args) {\n" +
                         "+        System.out.println(\"这是trunk提交：01\");\n" +
                         "+    }\n" +
                         "+}";
        String newDiff = diffTxt.replaceAll("\\(revision[^\n]*\\)\n", "\n");
        System.out.println(newDiff);
    }

//    public static String trimDiff(String diffText) {
//        String tempDiff = diffText.replaceFirst("(revision[^\n]*)\n","\n");
//        FileStatus fileStatus = DiffKit.getFileStatus(tempDiff);
//        if (fileStatus.isAdd()) {
//            tempDiff = tempDiff.replaceFirst("[\\-]{3}[^\n]*\n","--- /dev/null\n");
//        }else if(fileStatus.isDelete()){
//            tempDiff = tempDiff.replaceFirst("[+]{3}[^\n]*\n","--- /dev/null\n");
//        }
//        return tempDiff;
//    }
}
