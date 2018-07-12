package com.eqx.demowork.designPaterns.strategy.demo;

/**
 * @Author duan
 * @Description: 为大客户计算商品价格
 * @Date: Created in 下午12:05 2018/7/12
 */
public class LargeCustomerStrategy implements PriceStategy {
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("大客户，统一折扣10%");
        return goodsPrice * (1 - 0.1);
    }
}
