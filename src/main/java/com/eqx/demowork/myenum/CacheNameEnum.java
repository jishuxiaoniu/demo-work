package com.eqx.demowork.myenum;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午3:52 2018/8/13
 */
public enum CacheNameEnum {


    USER_INFO("user_info", "用户信息"),
    COMPANY_INFO("company_info", "用户信息");

    private String msg;

    private String key;

    private CacheNameEnum(String key, String msg){
        this.key=key;
        this.msg=msg;
    }

    @Override
    public String toString() {
        return "CacheNameEnum{" +
                "msg='" + msg + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
