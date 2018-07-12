package com.eqx.demowork.designPaterns.strategy.main;

/**
 * @Author duan
 * @Description: 上下文对象，通常会持有一个具体的策略对象
 * @Date: Created in 下午12:00 2018/7/12
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        // 调用具体的策略对象进行算法运算
        strategy.algorithmInterface();
    }
}
