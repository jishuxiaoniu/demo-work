package com.eqx.demowork.webframe.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 上午11:58 2018/7/9
 */
public class Server {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(8801);
        // 指定通信端口，防止被防火墙拦截
        RMISocketFactory.setSocketFactory(new CustormerSocketFactory());
        HelloService helloService = new HelloServiceImpl();
        Naming.bind("rmi://localhost:8801/helloService", helloService);
        System.out.println("The result is ----> someone find me");
    }
}
