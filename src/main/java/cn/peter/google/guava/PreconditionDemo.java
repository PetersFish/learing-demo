package cn.peter.google.guava;

import cn.peter.pojo.Person;
import com.google.common.base.Preconditions;

/**
 * @author Peter Yu
 * @date 2018/5/23 17:21
 */
public class PreconditionDemo {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(32);
        person.setName("peter");
        int i = 1;
        person = null;
        //checkNotNull(person);

        Preconditions.checkArgument(i < 0,"%s must be negative", i);
        System.out.println("I'm here!");

    }

    private static void checkNotNull(Person person) {
        Person person1 = Preconditions.checkNotNull(person);
        System.out.println(person1);
    }
}
