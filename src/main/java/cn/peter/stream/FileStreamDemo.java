package cn.peter.stream;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Yu 2018/7/31 18:37
 */
public class FileStreamDemo {

    private static final String BASE_TYPE = "(?:int|float|double|char|wchar_t|bool|void)";

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\WorkSpace_Clion\\untitled\\main.c");

        String path = file.getParent();
        System.out.println(path);

        filePreprocess(file);

    }

    private static void filePreprocess(File file) throws IOException {
        String regStart = "^[^\n\r]*" + BASE_TYPE + "[^\n\r]*\\([^\n\r]*\\)$";
        String regEnd = "^\\{";
        Pattern startCompile = Pattern.compile(regStart);
        Pattern endCompile = Pattern.compile(regEnd);
        boolean addComment = false;

        File tempFile = File.createTempFile(FileDemo.getPreffix(file.getName()), FileDemo.getSuffix(file.getName()),
                                            new File(file.getParent()));

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(
            new InputStreamReader(new FileInputStream(file), "utf-8"));
            writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(tempFile), "utf-8"));

            String read = null;
            StringBuilder sb = new StringBuilder();
            while ((read = reader.readLine()) != null) {

                // 如果满足正则，则下一句可能要加注释
                Matcher startMatcher = startCompile.matcher(read);
                if (startMatcher.matches()) {
                    addComment = true;
                    writer.write(read);
                    writer.newLine();
                    writer.flush();
                    continue;
                }
                if (addComment) {
                    Matcher endMatcher = endCompile.matcher(read);
                    if (!endMatcher.matches()) {
                        read = "//"+read;

                    }else {
                        addComment = false;
                    }
                }
                writer.write(read);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
