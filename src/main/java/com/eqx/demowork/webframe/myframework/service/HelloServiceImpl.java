package com.eqx.demowork.webframe.myframework.service;


/**
 * @Author duan
 * @Description:
 * @Date: Created in 上午11:51 2018/7/9
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("The result is ----> name = " + name);
        return "hello " + name + " , I am server!";
    }
}
