package cn.peter.kit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String工具类，
 * 为了区别与apache的StringUtils，命名为StringKit
 *
 * @author Peter Yu 2019/1/8 11:07
 */
public class StringKit {

    private static final Logger logger = LoggerFactory.getLogger(StringKit.class);

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private static final String EMPTY_STRING = "";

    private StringKit() {
    }

    public static String trimHead(String origin, String start, boolean includeStart) {
        int index = origin.indexOf(start);
        if (includeStart) {
            return origin.substring(index);
        }
        return origin.substring(index + start.length());
    }

    public static String trimTail(String origin, String end, boolean includeEnd) {
        int index = origin.indexOf(end);
        if (includeEnd) {
            return origin.substring(0, index + end.length());
        }
        return origin.substring(0, index);
    }

    public static String trimByRegex(String origin, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(origin);
        if (matcher.find()) {
            return matcher.group();
        }
        return EMPTY_STRING;
    }

    /**
     * 将文件转换为listString
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static List<String> fileToLines(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return toLines(reader);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return Collections.emptyList();
    }

    /**
     * 将String转换为listString
     *
     * @param string
     * @return
     * @throws IOException
     */
    public static List<String> stringToLines(String string) {
        try (BufferedReader br = new BufferedReader(new StringReader(string))) {
            return toLines(br);
        }catch (IOException e){
            logger.error(e.getMessage());
        }
        return Collections.emptyList();
    }

    private static List<String> toLines(BufferedReader reader) throws IOException {
        List<String> lines = new LinkedList<>();
        String buff = "";
        while ((buff = reader.readLine()) != null) {
            lines.add(buff);
        }
        return lines;
    }

    public static String linesToString(List<String> originalFile) {
        StringBuilder sb = new StringBuilder();
        for (String line : originalFile) {
            sb.append(line).append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

    public static List<String> stringToLines2(String string) {
        return new LinkedList<String>(Arrays.asList(string.split("\n")));
    }

}
