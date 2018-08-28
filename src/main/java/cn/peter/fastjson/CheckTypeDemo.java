package cn.peter.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONToken;

/**
 * @author Peter Yu
 * @date 2018/6/5 12:46
 */
public class CheckTypeDemo {

    public static void main(String[] args) {

        String str = "{}";
        Object parse = JSON.parse(str);

        System.out.println(parse);
    }
}
