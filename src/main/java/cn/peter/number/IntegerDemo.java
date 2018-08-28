package cn.peter.number;

/**
 * @author Peter Yu 2018/7/16 0:28
 */
public class IntegerDemo {

    public static void main(String[] args) {
        Integer i = 236;
        Integer j = 2;
        Integer m = 234;
        j += m;
        System.out.println(j == i);
        System.out.println(j.equals(i));
    }
}
