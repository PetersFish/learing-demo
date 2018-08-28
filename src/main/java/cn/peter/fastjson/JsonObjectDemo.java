package cn.peter.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Peter Yu
 * @date 2018/5/25 14:24
 */
public class JsonObjectDemo {

    public static void main(String[] args) {
        Integer[] arr = {1, 2};
        Integer[] arr1 = {1, 2, 3};
        JSONObject myArray = new JSONObject();
        myArray.put("integerArray",arr);
        JSONObject fatherObject = new JSONObject();
        fatherObject.putAll(myArray);
        System.out.println(fatherObject.toString());
        myArray.put("integerArray",arr1);
        fatherObject.putAll(myArray);
        System.out.println(fatherObject.toString());

    }
}
