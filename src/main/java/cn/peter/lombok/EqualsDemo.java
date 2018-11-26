package cn.peter.lombok;

/**
 * @author Peter Yu 2018/11/13 16:34
 */
public class EqualsDemo {

    public static void main(String[] args) {
        Student peter1 = Student.builder()
                                .name("Peter")
                                .clazz("1709")
                                .build();
        Student peter2 = Student.builder()
                                .name("Peter")
                                .clazz("1709")
                                .build();
        System.out.println(peter1.equals(peter2));
    }
}
