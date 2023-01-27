package com.accenture.userservice.exception;

public class UserServiceException extends Exception {

    private Integer code;

    public UserServiceException(Integer code) {
        this.code = code;
    }

    public UserServiceException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
