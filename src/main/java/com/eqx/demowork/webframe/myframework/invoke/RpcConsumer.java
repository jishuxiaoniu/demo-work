package com.eqx.demowork.webframe.myframework.invoke;

import com.eqx.demowork.webframe.myframework.framework.ConsumerProxy;
import com.eqx.demowork.webframe.myframework.service.HelloService;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午2:48 2018/7/9
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        HelloService service = ConsumerProxy.consume(HelloService.class, "127.0.0.1", 8083);
        for (int i = 0; i < 1000; i++) {
            String hello = service.sayHello("zhangsan_" + i);
            System.out.println("The result is ----> " + hello);
            Thread.sleep(1000L);
        }
    }
}
