package cn.peter.appache.commons;

import cn.peter.pojo.Person;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Peter Yu
 * @date 2018/5/23 15:15
 */
public class StringUtilsDemo {

    public static void main(String[] args) {

        //checkEmpty();

        //removeWhiteSpace();

        //checkBlank();

        String str1 = null;
        String str2 = "";
        String str3 = "Peter Yu";
        Person person = new Person();
        person.setName(null);
        person.setAge(null);
        //person = null;

        Object o = ObjectUtils.firstNonNull(str1, person, str3);
        System.out.println(o);

    }


    private static void checkBlank() {
        String emtpy = null;
        boolean empty = StringUtils.isBlank(emtpy);
        //boolean empty = StringUtils.isEmpty(emtpy);
        System.out.println(empty);
    }

    private static void removeWhiteSpace() {
        String name = "Peter Yu Best";
        String s = StringUtils.deleteWhitespace(name);
        System.out.println(s);
    }

    private static void checkEmpty() {
        String emtpy = "";
        boolean empty = StringUtils.isEmpty(emtpy);
        System.out.println(empty);
    }
}
