package com.eqx.demowork.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException {

    private int code;

    private String message;

    Throwable throwable;

    public ServiceException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(int code, Throwable throwable) {
        this.code = code;
        this.throwable = throwable;
    }
}
