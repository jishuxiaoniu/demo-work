package com.eqx.demowork.webframe.myframework.invoke;


import com.eqx.demowork.webframe.myframework.framework.ProviderReflect;
import com.eqx.demowork.webframe.myframework.service.HelloService;
import com.eqx.demowork.webframe.myframework.service.HelloServiceImpl;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午2:46 2018/7/9
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        ProviderReflect.provider(helloService, 8083);
    }
}
