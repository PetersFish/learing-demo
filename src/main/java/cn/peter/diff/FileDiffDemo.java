package cn.peter.diff;

import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Peter Yu 2018/11/26 17:53
 */
public class FileDiffDemo {

    public static void main(String[] args) throws Exception {
        String oldCode = "package cn.peter.demo;\n" +
                         "\n" +
                         "/**\n" +
                         " * @author Peter Yu 2018/11/8 16:29\n" +
                         " */\n" +
                         "public class Demo3 {\n" +
                         "\n" +
                         "    public static void main(String[] args) {\n" +
                         "        System.out.println(\"杩欐槸branch01鐨勪慨鏀癸細03\");\n" +
                         "    }\n" +
                         "}\n";
        String newCode = "package cn.peter.demo;\n" +
                         "\n" +
                         "/**\n" +
                         " * @author Peter Yu 2018/11/8 16:29\n" +
                         " */\n" +
                         "public class Demo4 {\n" +
                         "\n" +
                         "    public static void main(String[] args) {\n" +
//                         "        System.out.println(\"杩欐槸branch01鐨勪慨鏀癸細02\");\n" +
//                         "        System.out.println(\"rename and add 01\");\n" +
                         "    }\n" +
                         "}\n";
//        String newCode = "abc";
        List<String> oldList = parseCode(oldCode);
        List<String> newList = parseCode(newCode);

        Patch<String> diff = DiffUtils.diff(oldList, newList);

        for (Delta<String> delta : diff.getDeltas()) {
            System.out.println(delta);
        }
    }

    private static List<String> parseCode(String oldCode) throws IOException {
        LinkedList<String> list = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new StringReader(oldCode))){
            String buffer;
            while ((buffer = reader.readLine()) != null) {
                list.add(buffer);
            }
        }
        return list;
    }

}
