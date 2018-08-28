package cn.peter.pojo;

/**
 * @author Peter Yu
 * @date 2018/5/22 18:33
 */
public class Person implements Comparable<Person>{

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
    }

    @Override
    public int compareTo(Person o) {
        if(age != null&&o.age != null){
            return age - o.age;
        }
        return 0;
    }
}
