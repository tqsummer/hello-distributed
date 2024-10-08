package com.study.hello.distributed.mybatis.framework.commons.exception;

public class ApiInputException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ApiInputException(String message) {
        super(message);
    }

    public ApiInputException(String message, Throwable cause) {
        super(message, cause);
    }

}
