package com.eqx.demowork.webframe.rmi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午1:42 2018/7/9
 */
public class CustormerSocketFactory extends RMISocketFactory {
    // 指定通信端口，防止被防火墙拦截
    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return new Socket(host, port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        if (port == 0) {
            port = 8501;
        }
        return new ServerSocket(port);
    }
}
