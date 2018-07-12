package com.eqx.demowork.designPaterns.strategy.demo;

import com.eqx.demowork.designPaterns.strategy.main.Strategy;

/**
 * @Author duan
 * @Description: 价格管理，完成计算向客户的报价功能
 * @Date: Created in 下午1:35 2018/7/12
 */
public class Price {

    private PriceStategy priceStategy = null;

    public Price(PriceStategy priceStategy) {
        this.priceStategy = priceStategy;
    }

    /**
     * 报价
     *
     * @param goodsPrice
     * @return
     */
    public double quote(double goodsPrice) {
        return priceStategy.calcPrice(goodsPrice);
    }
}
