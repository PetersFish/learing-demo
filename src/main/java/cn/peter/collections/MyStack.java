package cn.peter.collections;

import java.util.LinkedList;

/**
 * @author Peter Yu
 * @date 2018/6/8 19:52
 */
public class MyStack {

    private LinkedList<Integer> linkedList = new LinkedList<>();

    public boolean push(Integer num){
        return linkedList.add(num);
    }

    public Integer pop(){
        if(linkedList.size() == 0){
            return null;
        }
        return linkedList.getLast();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        Integer pop = myStack.pop();
        System.out.println(pop);
    }

}

