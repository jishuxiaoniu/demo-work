package com.eqx.demowork.exception;

import lombok.Data;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午4:05 2018/4/12
 */
@Data
public class AuthException extends RuntimeException {

    private String message;

    public AuthException(String message) {
        this.message = message;
    }
}
