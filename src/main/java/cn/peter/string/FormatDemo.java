package cn.peter.string;

/**
 * @author Peter Yu 2018/9/29 11:09
 */
public class FormatDemo {

    public static void main(String[] args) {
        double price = 10.8789;
        String priceString = String.format("%.2f",price);
        System.out.println(priceString);
    }
}
