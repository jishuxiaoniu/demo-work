package com.eqx.demowork.designPaterns.simpleFactory.factory;

import com.eqx.demowork.designPaterns.simpleFactory.Api;
import com.eqx.demowork.designPaterns.simpleFactory.impl.ImplA;
import com.eqx.demowork.designPaterns.simpleFactory.impl.ImplB;

/**
 * @Author duan
 * @Description: 工厂类，创建api对象
 * <p>
 * 简单工厂内部主要实现的功能是：选择合适的实现类
 * @Date: Created in 下午3:53 2018/3/29
 */
public class Factory {

    /**
     * 创建具体的Api对象
     *
     * @param condition
     * @return
     */
    public static Api createApi(int condition) {
        // 根据外部传入的条件选择创建哪一个具体对象
        Api api = null;
        if (condition == 1) {
            api = new ImplA();
        } else if (condition == 2) {
            api = new ImplB();
        }

        return api;
    }

}
