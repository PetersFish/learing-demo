package cn.peter.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter Yu
 * @date 2018/5/11 9:58
 */
public class GenericDemo {

    public static void main(String[] args) {
        Object obj = new Object();
        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();

        List<Object> objList = new ArrayList<>();
        List<Animal> animalList = new ArrayList<>();
        List<Cat> catList = new ArrayList<>();
        List<Dog> dogList = new ArrayList<>();

        objList.add(obj);
        animalList.add(animal);
        animalList.add(cat);
        animalList.add(dog);
        catList.add(cat);
        dogList.add(dog);



    }

    public static void show1(List<? extends Animal> list){
        Object obj = new Object();
        Animal animal = list.get(0);
    }
    public static void show2(List<? super Animal> list){
        Object obj = new Object();
        Animal animal = new Animal();
        Object object = list.get(0);
        list.add(animal);
    }
}
