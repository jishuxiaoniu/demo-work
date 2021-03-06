package com.eqx.demowork.designPaterns.abstractFactory.factory;

import com.eqx.demowork.designPaterns.abstractFactory.product.AbstractProductA;
import com.eqx.demowork.designPaterns.abstractFactory.product.AbstractProductB;
import com.eqx.demowork.designPaterns.abstractFactory.product.ProductA1;
import com.eqx.demowork.designPaterns.abstractFactory.product.ProductB2;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 上午11:08 2018/7/12
 */
public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
