package com.eqx.demowork.service;

import com.eqx.demowork.model.Order;
import com.eqx.demowork.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by on 2017/3/1.
 */
@Service
@Slf4j
public class RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public String getStr(String key) {
        stringRedisTemplate.opsForValue().set(key, key + "_value");
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Cacheable(value = "eqxiu", key = "'order_' + #id", condition = "#id > 0")
    public Order getUser(Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setTitle("你好");
        order.setUserId(12);
        log.info("order={}", order);
        return order;
    }

    @CacheEvict(value = "eqxiu", key = "'order_' + #id")
    public void delUser(Integer id) {
        log.info("删除数据库id为{}的数据, 并更新缓存", id);
    }
}