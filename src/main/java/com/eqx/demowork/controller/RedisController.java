package com.eqx.demowork.controller;

import com.eqx.demowork.cache.RedisTemplateLock;
import com.eqx.demowork.model.Order;
import com.eqx.demowork.model.User;
import com.eqx.demowork.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisTemplateLock redisTemplateLock;

    @RequestMapping("/get")
    public String redis() {
        return redisService.getStr("aaa");
    }

    @GetMapping("/get/{id}")
    public Order getUser(@PathVariable Integer id) {
        return redisService.getUser(id);
    }

    @GetMapping("/del/{id}")
    public void delUser(@PathVariable Integer id) {
        redisService.delUser(id);
    }

    int num = 0;

    @GetMapping("/lock")
    public void lock() {
        Executor executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            Future<Integer> future = CompletableFuture.supplyAsync(() -> {
                String retIdentifier = redisTemplateLock.lock("testLock");
                int a = addNum();
                redisTemplateLock.unlock("testLock", retIdentifier);
                log.info("num={}", a);
                return a;
            }, executor);
        }
    }

    public int addNum() {
        return ++num;
    }
}
