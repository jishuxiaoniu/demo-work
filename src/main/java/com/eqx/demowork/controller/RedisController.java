package com.eqx.demowork.controller;

import com.eqx.demowork.model.Order;
import com.eqx.demowork.model.User;
import com.eqx.demowork.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/get")
    public String redis() {
        return redisService.getStr("aaa");
    }

    @GetMapping("/get/{id}")
    public Order getUser(@PathVariable Integer id){
        return redisService.getUser(id);
    }

    @GetMapping("/del/{id}")
    public void delUser(@PathVariable Integer id){
        redisService.delUser(id);
    }
}
