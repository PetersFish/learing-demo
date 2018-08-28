package cn.peter.test;

/**
 * @author Peter Yu
 * @date 2018/5/25 15:52
 */
public class NullStringConcat {

    public static void main(String[] args) {
        String NULL = null;
        String result = "["+NULL+"]";
        String result2 = "["+null+"]";
        System.out.println(result);
        System.out.println(result2);
    }
}
