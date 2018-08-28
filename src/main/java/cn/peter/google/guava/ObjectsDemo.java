package cn.peter.google.guava;

import cn.peter.pojo.Person;
import com.google.common.base.Objects;

/**
 * @author Peter Yu
 * @date 2018/5/23 17:33
 */
public class ObjectsDemo {

    public static void main(String[] args) {
        Person person1 = new Person("Peter",31);
        Person person2 = new Person("Peter",31);
        String pName = person2.getName();
        String name = "Peter";
        String name2 = "Peter ";



        //hashGenerate(person1, person2);


        //nullAllowEqual(pName, name);

        
    }

    private static void hashGenerate(Person person1, Person person2) {
        int i = Objects.hashCode(person1);
        int j = Objects.hashCode(person2);
        System.out.println(i == j);
        System.out.println(i);
        System.out.println(j);
    }

    private static void nullAllowEqual(String pName, String name) {
        if(Objects.equal(pName, name)){
            System.out.println("success!");
        }else {
            System.out.println("fail!");
        }
    }
}
