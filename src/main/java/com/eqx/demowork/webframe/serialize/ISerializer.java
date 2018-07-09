package com.eqx.demowork.webframe.serialize;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午3:14 2018/7/9
 */
public interface ISerializer {

    /**
     * 序列化
     *
     * @param obj
     * @param <T>
     * @return
     */
    <T> byte[] serialize(T obj);

    /**
     * 反序列化
     *
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T deserialize(byte[] data, Class<T> clazz);
}
