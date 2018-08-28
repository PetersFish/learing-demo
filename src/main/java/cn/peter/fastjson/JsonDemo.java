package cn.peter.fastjson;

import cn.peter.pojo.Person;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * @author Peter Yu
 * @date 2018/5/22 18:32
 */
public class JsonDemo {

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.setAge(31);
        p1.setName("Peter");
        p2.setAge(28);
        p2.setName("Lucy");
        Person[] arr = {p1, p2};

        // 测试Object to String
        /*String jsonString = JSON.toJSONString(p1);
        System.out.println(jsonString);*/

        // 测试String to Object
        /*Person person = JSON.parseObject(jsonString, Person.class);
        System.out.println(person);*/

        // 测试Generic
        String arrString = JSON.toJSONString(arr);
        System.out.println(arrString);
       /* Type type = new TypeReference<List<Person>>() {

        }.getType();
        List<Person> personList = JSON.parseObject(arrString, type);
        System.out.println(personList);*/

        // 测试JSONArray
        JSONArray objects = JSON.parseArray(arrString);
        System.out.println(objects);
        Object o = objects.get(0);
        System.out.println(o);
        Person per = objects.getObject(0, Person.class);
        System.out.println(per);
    }
}
