package com.eqx.demowork.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author duan
 * @Description: mq consumer
 * @Date: Created in 下午1:48 2018/1/15
 */
@Component
@Slf4j
public class Comsumer {

    @JmsListener(destination = Producer.QUEUE)
    public void receiveQueue(String text) {
        log.info(text);
    }
}
