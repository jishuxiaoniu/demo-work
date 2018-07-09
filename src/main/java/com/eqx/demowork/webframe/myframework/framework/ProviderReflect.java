package com.eqx.demowork.webframe.myframework.framework;

import org.apache.commons.lang.reflect.MethodUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午2:37 2018/7/9
 */
public class ProviderReflect {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    /**
     * 服务发布
     *
     * @param service
     * @param port
     * @throws Exception
     */
    public static void provider(final Object service, int port) throws Exception {

        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            final Socket socket = serverSocket.accept();
            EXECUTOR_SERVICE.execute(() -> {
                try {
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    try {
                        try {
                            String methodName = inputStream.readUTF();
                            Object[] args = (Object[]) inputStream.readObject();
                            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                            try {
                                Object result = MethodUtils.invokeExactMethod(service, methodName, args);
                                outputStream.writeObject(result);
                            } finally {
                                outputStream.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            inputStream.close();
                        }
                    } finally {
                        serverSocket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
