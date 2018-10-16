package cn.peter.file;

import java.io.File;

/**
 * @author Peter Yu 2018/9/19 15:48
 */
public class FileDeleteDemo {

    public static void main(String[] args) {
        File file = new File("D:\\test1");

        deletFile(file);
    }

    private static void deletFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File subFile : files) {
                deletFile(subFile);
            }
            file.delete();
        }
        if (file.isFile()){
            file.delete();
        }

    }
}
