package cn.peter.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter Yu
 * @date 2018/5/9 15:05
 */
public class ToArrayDemo {

    public static void main(String[] args) {
        List<String> orgList = new ArrayList<String>();
        orgList.add("Peter");
        orgList.add("Marry");
        orgList.add("Lily");

        String[] strArr = new String[orgList.size()];
        String[] newArr = orgList.toArray(strArr);
        System.out.println(newArr == strArr);
    }
}
