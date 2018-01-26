package com.eqx.demowork.controller;

import com.eqx.demowork.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/{id}")
    public String redis(@PathVariable long id) {
        long time = System.currentTimeMillis();
        String value = redisService.getStr(id + "");
        log.info("value={}, redis耗时：", value, (System.currentTimeMillis() - time));
        return "SUCCESS";
    }
}
