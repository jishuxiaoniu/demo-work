package com.eqx.demowork.designPaterns.strategy.demo;

/**
 * @Author duan
 * @Description: 策略模式的中心不是如何来实现算法，而是如何组织、调用这些算法，从而让程序结构更灵活，具有更好的维护性和扩展性
 * @Date: Created in 下午1:37 2018/7/12
 */
public class Client {
    public static void main(String[] args) {
        // 1、选择需要使用的策略对象
        PriceStategy priceStategy = new LargeCustomerStrategy();
        // 2、创建上下文
        Price ctx = new Price(priceStategy);
        // 3、计算报价
        double quote = ctx.quote(1000);
    }
}
