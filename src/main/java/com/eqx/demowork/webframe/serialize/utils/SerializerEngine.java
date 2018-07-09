package com.eqx.demowork.webframe.serialize.utils;

import com.eqx.demowork.webframe.serialize.ISerializer;
import com.eqx.demowork.webframe.serialize.impl.DefaultJavaSerializer;
import com.google.common.collect.Maps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午3:45 2018/7/9
 */
public class SerializerEngine {

    public static final Map<SerializeType, ISerializer> SERIALIZER_MAP = Maps.newConcurrentMap();

    static {
        SERIALIZER_MAP.put(SerializeType.DefaultJavaSerializer, new DefaultJavaSerializer());
    }

    /**
     * 序列化
     *
     * @param obj
     * @param serializeType
     * @param <T>
     * @return
     */
    public <T> byte[] serialize(T obj, String serializeType) {
        SerializeType serialize = SerializeType.queryByType(serializeType);
        if (serialize == null) {
            throw new RuntimeException("serialize is null");
        }
        ISerializer serializer = SERIALIZER_MAP.get(serialize);
        if (serializer == null) {
            throw new RuntimeException("serialize error");
        }
        try {
            return serializer.serialize(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 反序列化
     *
     * @param data
     * @param clazz
     * @param serializeType
     * @param <T>
     * @return
     */
    public <T> T deserialize(byte[] data, Class<T> clazz, String serializeType) {
        SerializeType serialize = SerializeType.queryByType(serializeType);
        if (serialize == null) {
            throw new RuntimeException("serialize is null");
        }
        ISerializer serializer = SERIALIZER_MAP.get(serialize);
        if (serializer == null) {
            throw new RuntimeException("serialize error");
        }
        try {
            return serializer.deserialize(data, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
