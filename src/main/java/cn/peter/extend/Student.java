package cn.peter.extend;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Peter Yu 2018/10/29 11:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends Human {

    private String clazz;

    @Builder
    public Student(String name, Integer age, String clazz) {
        super(name, age);
        this.clazz = clazz;
    }

    public static void main(String[] args) {
        Student peter = Student.builder()
                               .name("Peter")
//                               .age(31)
                               .clazz("1701")
                               .build();
        System.out.println(peter);
    }

}
