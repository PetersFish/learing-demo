package cn.peter.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter Yu
 * @date 2018/5/9 14:40
 */
public class SublistDemo {

    public static void main(String[] args) {
        List<String> dadList = new ArrayList<String>();
        dadList.add("Peter");
        dadList.add("Marry");
        dadList.add("Lily");
        List<String> subList = dadList.subList(0, 1);
        System.out.println(dadList);
        System.out.println(subList);

       /* dadList.add("Duck");
        System.out.println(dadList);
        System.out.println(subList);*/

        subList.set(0,"PeterFish");
        System.out.println(dadList);
        System.out.println(subList);

        dadList.remove("Lily");
        System.out.println(dadList);
        System.out.println(subList);
    }
}
