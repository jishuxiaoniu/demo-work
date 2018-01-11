package com.eqx.demowork.singleton;

import java.io.Serializable;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 上午11:16 2018/1/9
 */
public class SingleTon implements Serializable {

    private SingleTon(){
        // 防止反射调用
        if (getInstance()!=null)
            throw new RuntimeException("");
    }

    private static class Single {
        public static SingleTon singleTon = new SingleTon();
    }

    public static SingleTon getInstance() {
        return Single.singleTon;
    }

    // 如果对象实现了序列化接口，防止反序列化生成新对象
    public Object readResolve(){
        return getInstance();
    }
}
