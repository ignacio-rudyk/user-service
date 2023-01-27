package com.accenture.userservice.exception;

public class UserDAOException extends Exception{

    private Integer code;

    public UserDAOException(Integer code) {
        this.code = code;
    }

    public UserDAOException(String message, Integer code) {
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
