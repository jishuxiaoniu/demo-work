package com.eqx.demowork.designPaterns.simpleFactory.impl;

import com.eqx.demowork.designPaterns.simpleFactory.Api;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午3:52 2018/3/29
 */
public class ImplA implements Api {
    @Override
    public void operation(String s) {
        // 代码实现
        System.out.println("i am impl A");
    }
}
