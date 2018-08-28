package cn.peter.reflect;

import java.lang.reflect.Field;

/**
 * @author Peter Yu
 * @date 2018/5/14 20:24
 */
public class ReflectDemo {

    public static void main(String[] args) {
        Class<?> aClass = null;
        Field[] declaredFields = null;
        try {
            aClass = Class.forName("java.lang.System");
            declaredFields = aClass.getDeclaredFields();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
