package com.eqx.demowork.webframe.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 上午11:58 2018/7/9
 */
public class Server {
    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        LocateRegistry.createRegistry(8801);
        Naming.bind("rmi://localhost:8801/helloService", helloService);
        System.out.println("The result is ----> someone find me");
    }
}
