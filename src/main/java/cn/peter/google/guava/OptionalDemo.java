package cn.peter.google.guava;

import cn.peter.pojo.Person;
import com.google.common.base.Optional;

/**
 * @author Peter Yu
 * @date 2018/5/23 17:14
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(32);
        person.setName("peter");
        person = null;
        Optional<Person> of = Optional.fromNullable(person);
        System.out.println(of);
    }
}
