package com.eqx.demowork.designPaterns.factory.client;

import com.eqx.demowork.designPaterns.factory.service.ExportDBOperate;
import com.eqx.demowork.designPaterns.factory.service.AbstractExportOperate;

/**
 * @Author duan
 * <p>
 * 何时选用工厂模式：
 * 1、如果一个类需要创建某个接口的对象，但是又不知道具体的实现，此时可以选用工厂模式，把创建对象的工作延迟到子类去实现
 * 2、如果一个类本身就希望由它的子类来创建所需的对象的时候，应该采用工厂方法
 *
 * @Description: 客户端调用
 * @Date: Created in 下午4:00 2018/7/11
 */
public class Client {

    public static void main(String[] args) {
        // 创建需要使用的Creator对象
        AbstractExportOperate operate = new ExportDBOperate();
        // 调用输出数据的功能方法
        operate.export("test data");
    }
}
