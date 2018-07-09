package com.eqx.demowork.webframe.serialize.impl;

import com.eqx.demowork.model.User;
import com.eqx.demowork.webframe.serialize.ISerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午3:16 2018/7/9
 */
public class DefaultJavaSerializer implements ISerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(obj);
            outputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DefaultJavaSerializer javaSerializer = new DefaultJavaSerializer();
        User user = User.builder().age(11).name("张三").address("北京").build();
        System.out.println("The result is ----> " + javaSerializer.deserialize(javaSerializer.serialize(user), User.class));
    }
}
