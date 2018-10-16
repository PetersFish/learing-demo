package cn.peter.utils;

import org.apache.commons.lang3.ObjectUtils;

/**
 * @author Peter Yu 2018/8/29 15:30
 */
public class NullDemo {

    public static void main(String[] args) {
        String name = "Marry";
        String newName = ObjectUtils.defaultIfNull(name, "Peter");
        System.out.println(newName);
    }
}
