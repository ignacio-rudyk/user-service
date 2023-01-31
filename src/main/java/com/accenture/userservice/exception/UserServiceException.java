package com.accenture.userservice.exception;

public class UserServiceException extends Exception {

    private Integer code;

    private static String USER_SERVICE_EXCEPTION = "Hubo un error en el servicio";

    public UserServiceException() {
        this(USER_SERVICE_EXCEPTION, -1);
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
