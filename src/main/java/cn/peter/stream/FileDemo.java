package cn.peter.stream;

import java.io.File;

/**
 * @author Peter Yu 2018/7/31 19:33
 */
public class FileDemo {

    public static void main(String[] args) {
//        File file = new File("D:\\WorkSpace_Clion\\untitled\\main.c");
//        String name = file.getName();
//        System.out.println(name);
//        String preffix = getPreffix(name);
//        System.out.println(preffix);
//        String suffix = getSuffix(name);
//        System.out.println(suffix);
    }

    public static String getSuffix(String name) {
        int index = getLastDotIndex(name);
        if (index == -1) {
            return "";
        }
        return name.substring(index,name.length());
    }

    public static int getLastDotIndex(String name) {
        int index = name.lastIndexOf(".");
        return index;
    }

    public static String getPreffix(String name) {
        int index = getLastDotIndex(name);
        if (index == -1) {
            return name;
        }
        return name.substring(0,index);
    }
}
