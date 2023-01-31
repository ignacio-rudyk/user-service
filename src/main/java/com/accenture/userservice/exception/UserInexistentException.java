package com.accenture.userservice.exception;

public class UserInexistentException extends UserServiceException {

    private static Integer CODE = -2;

    private static String USER_INEXISTENT_EXCEPTION_MSG = "El usuario solicitado no existe";

    public UserInexistentException() {
        super(USER_INEXISTENT_EXCEPTION_MSG, CODE);
    }
}
