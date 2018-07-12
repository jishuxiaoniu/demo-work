package com.eqx.demowork.designPaterns.strategy.demo;

/**
 * @Author duan
 * @Description: 为老用户计算商品价格
 * @Date: Created in 下午12:05 2018/7/12
 */
public class OldCustomerStrategy implements PriceStategy {
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("老用户，统一折扣5%");
        return goodsPrice * (1 - 0.05);
    }
}
