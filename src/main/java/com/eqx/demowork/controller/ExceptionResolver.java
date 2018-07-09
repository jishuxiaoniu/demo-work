package com.eqx.demowork.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午4:27 2018/5/21
 */
public class ExceptionResolver {

    public static <T> Integer resolver(CompletableFuture<T> future) {
        try {
            return (Integer) future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
