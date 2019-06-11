package com.eqx.demowork.fastjson;

import com.alibaba.fastjson.JSON;
import com.eqx.demowork.model.User;

/**
 * @ClassName FastJsonTest
 * @Description test
 * @Author duanhuazhen
 * @Date 09:32 2019-04-17
 * @Version 1.0
 **/
public class FastJsonTest {

    public static void main(String[] args) {

        User user = new User();
        user.setId(1);
        user.setName("123");
        String s = JSON.toJSONString(user);
        System.out.println("The result is ----> " + s);
    }
}
