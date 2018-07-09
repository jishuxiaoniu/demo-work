package com.eqx.demowork.webframe.rmi;

import java.rmi.Naming;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午12:01 2018/7/9
 */
public class Client {
    public static void main(String[] args) throws Exception {
        HelloService helloService = (HelloService) Naming.lookup("rmi://localhost:8801/helloService");
        System.out.println("The result is ----> " + helloService.sayHello("张三"));
    }
}
