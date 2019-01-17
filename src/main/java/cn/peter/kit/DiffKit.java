package cn.peter.kit;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Peter Yu 2019/1/8 16:24
 */
public class DiffKit {

    private DiffKit() {
    }

    /**
     * 获取diff文件的修改状态
     *
     * @param diffText diff文本
     * @return 文件状态：A（新增），M（修改），D（删除）
     */
    public static FileStatus getFileStatus(String diffText) {
        Set<String> symbols = new HashSet<>();
        String validDiffText = StringKit.trimByRegex(diffText, "(?<=@@[\\s\\S]{2,16}@@\n)[\\s\\S]*");
        List<String> lines = StringKit.stringToLines(validDiffText);
        for (String line : lines) {
            String firstChar = line.substring(0, 1);
            symbols.add(firstChar);
        }
        return checkStatus(symbols);
    }

    private static FileStatus checkStatus(Set<String> symbols) {
        if (symbols.size() != 1) {
            return FileStatus.MODIFY;
        }
        if (symbols.contains("+")) {
            return FileStatus.ADD;
        }
        if (symbols.contains("-")) {
            return FileStatus.DELETE;
        }
        throw new IllegalArgumentException("Illegal diff text!");
    }
}
