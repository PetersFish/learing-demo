package cn.peter.string;

import com.google.common.base.Preconditions;

/**
 * @author Peter Yu 2018/12/25 20:00
 */
public class SubStringDemo {

    public static void main(String[] args) {
        String s = "l*s";
        String substring = s.substring(1);
        substring = null;
        System.out.println(substring);
        Preconditions.checkNotNull(substring,"Element is null!");

    }
}
