package com.eqx.demowork.webframe.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 上午11:51 2018/7/9
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "hello " + name + " , I am server!";
    }
}
