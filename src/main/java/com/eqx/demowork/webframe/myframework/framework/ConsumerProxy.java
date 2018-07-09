package com.eqx.demowork.webframe.myframework.framework;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午2:05 2018/7/9
 */
public class ConsumerProxy {

    public static <T> T consume(final Class<T> interfaceClass, final String host, final int port) throws Exception {

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket(host, port);
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    try {
                        outputStream.writeUTF(method.getName());
                        outputStream.writeObject(args);
                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                        try {
                            Object result = inputStream.readObject();
                            if (result instanceof Throwable){
                                throw (Throwable) result;
                            }
                            return result;
                        } finally {
                            inputStream.close();
                        }
                    } finally {
                        outputStream.close();
                    }
                } finally {
                    socket.close();
                }
            }
        });
    }
}
