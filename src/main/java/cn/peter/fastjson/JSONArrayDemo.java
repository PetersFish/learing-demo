package cn.peter.fastjson;

import com.alibaba.fastjson.JSONArray;

/**
 * @author Peter Yu 2018/7/4 14:13
 */
public class JSONArrayDemo {

    public static void main(String[] args) {
        JSONArray array = new JSONArray();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        System.out.println(array.toJSONString());
        System.out.println(array.toString());
    }
}
