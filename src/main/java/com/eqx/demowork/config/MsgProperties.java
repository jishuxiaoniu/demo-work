package com.eqx.demowork.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午5:59 2018/7/31
 */
@Configuration
@ConfigurationProperties(prefix = "msg.event.code")
@Data
public class MsgProperties implements Serializable{

    private String msg1;

    private String msg2;

    private String msg3;
}
