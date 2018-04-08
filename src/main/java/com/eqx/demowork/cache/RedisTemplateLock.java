package com.eqx.demowork.cache;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * @Author duan
 * @Description: redis分布式锁
 * @Date: Created in 下午4:12 2018/2/27
 */
@Slf4j
@Component
public class RedisTemplateLock {

    @Autowired
    private RedisTemplate redisTemplate;

    public String lock(String lockKey) {
        return tryLock(lockKey, 3000L, 3000L);
    }

    /**
     * 获取锁
     *
     * @param lockKey
     * @param acquireTimeout
     * @param timeout
     * @return
     */
    public String tryLock(String lockKey, long acquireTimeout, long timeout) {
        String retIdentifier = null;
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisConnection redisConnection = connectionFactory.getConnection();
        // 获取连接, 随机生成一个value
        String identifier = UUID.randomUUID().toString();
        // 超时时间，上锁后超过此时间则自动释放锁
        int lockExpire = (int) (timeout / 1000);
        // 获取锁的超时时间，超过这个时间则放弃获取锁
        long end = System.currentTimeMillis() + acquireTimeout;
        while (System.currentTimeMillis() < end) {
            if (redisConnection.setNX(lockKey.getBytes(), identifier.getBytes())) {
                redisConnection.expire(lockKey.getBytes(), lockExpire);
                // 返回value值，用于释放锁时间确认
                retIdentifier = identifier;
                log.info("加锁成功，key={}, threadId={}", lockKey, Thread.currentThread().getId());
                RedisConnectionUtils.releaseConnection(redisConnection, connectionFactory);
                return retIdentifier;
            }
            // 返回-1代表key没有设置超时时间，为key设置一个超时时间
            if (redisConnection.ttl(lockKey.getBytes()) == -1) {
                redisConnection.expire(lockKey.getBytes(), lockExpire);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                log.warn("获取到分布式锁：线程中断！");
                Thread.currentThread().interrupt();
            }
        }
        RedisConnectionUtils.releaseConnection(redisConnection, connectionFactory);
        return retIdentifier;
    }

    /**
     * 释放锁
     *
     * @param lockKey    锁的key
     * @param identifier 释放锁的标识
     * @return
     */
    public boolean unlock(String lockKey, String identifier) {
        if (identifier == null || "".equals(identifier)) {
            return false;
        }
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisConnection redisConnection = connectionFactory.getConnection();
        boolean releaseFlag = false;
        while (true) {
            try {
                // 监视lock，准备开始事务
                redisConnection.watch(lockKey.getBytes());
                // 通过前面返回的value值判断是不是该锁，若是该锁，则删除，释放锁
                byte[] valueBytes = redisConnection.get(lockKey.getBytes());
                if (valueBytes == null) {
                    redisConnection.unwatch();
                    releaseFlag = false;
                    break;
                }
                String identifierValue = new String(valueBytes);
                if (identifier.equals(identifierValue)) {
                    redisConnection.multi();
                    redisConnection.del(lockKey.getBytes());
                    log.info("解锁成功，key={}, threadId={}", lockKey, Thread.currentThread().getId());
                    List<Object> results = redisConnection.exec();
                    if (results == null) {
                        continue;
                    }
                    releaseFlag = true;
                }
                redisConnection.unwatch();
                break;
            } catch (Exception e) {
                log.warn("释放锁异常, e=", e);
                e.printStackTrace();
            }
        }
        RedisConnectionUtils.releaseConnection(redisConnection, connectionFactory);
        return releaseFlag;
    }
}
