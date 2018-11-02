package cn.peter.pojo;

/**
 * @author Peter Yu 2018/10/26 19:00
 */
public class ConstructorDemo {

    public ConstructorDemo() throws Exception {
        System.out.println("开始创建");
        throw new Exception("lalala");
    }

    public static void main(String[] args){
        ConstructorDemo constructorDemo = null;
        try {
            constructorDemo = new ConstructorDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(constructorDemo);
    }
}
