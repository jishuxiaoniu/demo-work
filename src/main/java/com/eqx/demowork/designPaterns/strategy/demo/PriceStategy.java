package com.eqx.demowork.designPaterns.strategy.demo;

/**
 * @Author duan
 * @Description: 价格策略接口
 * @Date: Created in 下午12:04 2018/7/12
 */
public interface PriceStategy {

    /**
     * 计算相应的价格
     *
     * @param goodsPrice 商品原价
     * @return
     */
    double calcPrice(double goodsPrice);
}
