package com.eqx.demowork.webframe.serialize.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午3:47 2018/7/9
 */
public enum SerializeType {

    DefaultJavaSerializer("DefaultJavaSerializer");

    private String serializeType;

    private SerializeType(String serializeType) {
        this.serializeType = serializeType;
    }

    public static SerializeType queryByType(String serializeType) {
        if (StringUtils.isBlank(serializeType)) {
            return null;
        }
        for (SerializeType serialize : SerializeType.values()) {
            if (StringUtils.equals(serializeType, serialize.getSerializeType())) {
                return serialize;
            }
        }
        return null;
    }

    public String getSerializeType() {
        return serializeType;
    }
}
