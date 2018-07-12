package com.eqx.demowork.designPaterns.abstractFactory;

import com.eqx.demowork.designPaterns.abstractFactory.factory.AbstractFactory;
import com.eqx.demowork.designPaterns.abstractFactory.factory.ConcreteFactory1;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 上午11:09 2018/7/12
 */
public class Client {

    public static void main(String[] args) {
        AbstractFactory af = new ConcreteFactory1();
        // 通过抽象工厂来获取一系列的对象，如产品 A 和产品 B
        af.createProductA();
        af.createProductB();
    }
}
