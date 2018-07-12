package com.eqx.demowork.designPaterns.abstractFactory.factory;

import com.eqx.demowork.designPaterns.abstractFactory.product.AbstractProductA;
import com.eqx.demowork.designPaterns.abstractFactory.product.AbstractProductB;

/**
 * @Author duan
 * @Description:    抽象工厂
 * @Date: Created in 上午11:02 2018/7/12
 */
public interface AbstractFactory {

    /**
     * 创建产品 A 的对象
     * @return
     */
    AbstractProductA createProductA();

    /**
     * 创建产品 B 的对象
     * @return
     */
    AbstractProductB createProductB();
}
