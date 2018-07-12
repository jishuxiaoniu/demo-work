package com.eqx.demowork.designPaterns.strategy.demo;

/**
 * @Author duan
 * @Description: 为普通用户计算商品价格
 * @Date: Created in 下午12:05 2018/7/12
 */
public class NormalCustomerStrategy implements PriceStategy {
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("普通用户没有折扣");
        return goodsPrice;
    }
}
