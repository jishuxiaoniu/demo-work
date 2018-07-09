package com.eqx.demowork.webframe.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 上午11:50 2018/7/9
 */
public interface HelloService extends Remote {

    String sayHello(String name) throws RemoteException;
}
