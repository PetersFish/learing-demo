package cn.peter.condition;

/**
 * @author Peter Yu 2018/9/4 9:46
 */
public class IfDemo {

    public static void main(String[] args) {
        /*String s = null;
        boolean flag = s != null&&equals(s,"Peter");
        System.out.println(flag);*/
    }

    private static boolean equals(String s, String p) {
        System.out.println("start compare...");
        if(s != null&&p != null)
            return p.equals(s);
        return false;
    }
}
