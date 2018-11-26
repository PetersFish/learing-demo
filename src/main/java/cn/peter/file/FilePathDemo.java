package cn.peter.file;

import java.io.File;
import java.io.IOException;

/**
 * @author Peter Yu 2018/11/13 18:42
 */
public class FilePathDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/cache");
        boolean mkdir = file.mkdir();
        System.out.println("success:"+mkdir);
        String canonicalPath = file.getCanonicalPath();
        String path = file.getPath();
        String absolutePath = file.getAbsolutePath();
        System.out.println("canonicalPath:"+canonicalPath);
        System.out.println("path:"+path);
        System.out.println("absolutePath:"+absolutePath);

    }
}
