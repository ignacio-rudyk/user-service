package com.accenture.userservice.exception;

public class UserDAOException extends Exception {

    private static String USER_DAO_EXCEPTION = "Hubo un error al acceder a los datos";

    public UserDAOException() {
        this(USER_DAO_EXCEPTION);
    }

    public UserDAOException(String message) {
        super(message);
    }

}
