package com.eqx.demowork.designPaterns.simpleFactory;

import com.eqx.demowork.designPaterns.simpleFactory.factory.Factory;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午3:58 2018/3/29
 */
public class Client {

    public static void main(String[] args) {
        // 通过简单工厂获取接口对象
        Api api = Factory.createApi(1);
        api.operation("正在使用简单工厂");
    }

}
