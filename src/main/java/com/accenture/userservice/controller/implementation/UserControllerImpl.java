package com.accenture.userservice.controller.implementation;

import com.accenture.userservice.controller.UserController;
import com.accenture.userservice.exception.UserInexistentException;
import com.accenture.userservice.exception.UserServiceException;
import com.accenture.userservice.exception.ValidationException;
import com.accenture.userservice.model.ErrorResponse;
import com.accenture.userservice.model.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.accenture.userservice.service.UserService;

import java.util.List;
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public ResponseEntity<ErrorResponse> createUser(UserDTO newUser) {
        logger.info("[Microservice:User, Endpoint:createUser] new_user = " + newUser.toString());
        try{
            UserDTO userSaved = userService.saveUser(newUser);
            ErrorResponse errorResponse = new ErrorResponse(userSaved);
            return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.CREATED);
        } catch (ValidationException e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getCode(), e.getMessage()),HttpStatus.BAD_REQUEST);
        } catch (UserServiceException e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getCode(), e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Throwable e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(-1, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ErrorResponse> removeUser(Long id) {
        logger.info("[Microservice:User, Endpoint:removeUser] user_id = " + id);
        try {
            UserDTO userDeleted = userService.delete(id);
            ErrorResponse errorResponse = new ErrorResponse(userDeleted);
            return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
        } catch (UserInexistentException e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getCode(), e.getMessage()),HttpStatus.BAD_REQUEST);
        } catch (ValidationException e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getCode(), e.getMessage()),HttpStatus.BAD_REQUEST);
        } catch (UserServiceException e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getCode(), e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Throwable e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(-1, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ErrorResponse> getUser(Long id) {
        logger.info("[Microservice:User, Endpoint:getUser] user_id = " + id);
        try{
            UserDTO userFound = userService.findById(id);
            ErrorResponse errorResponse = new ErrorResponse(userFound);
            return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
        } catch (UserInexistentException e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getCode(), e.getMessage()),HttpStatus.NO_CONTENT);
        } catch (ValidationException e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getCode(), e.getMessage()),HttpStatus.BAD_REQUEST);
        } catch (UserServiceException e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getCode(), e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Throwable e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(-1, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ErrorResponse> existUser(Long id) {
        logger.info("[Microservice:User, Endpoint:existUser] user_id = " + id);
        try {
            Boolean exist = userService.existsById(id);
            ErrorResponse errorResponse = new ErrorResponse(exist);
            return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
        } catch (ValidationException e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getCode(), e.getMessage()),HttpStatus.BAD_REQUEST);
        } catch (UserServiceException e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getCode(), e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Throwable e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(-1, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ErrorResponse> list() {
        logger.info("[Microservice:User, Endpoint:list]");
        try {
            List<UserDTO> userList = userService.list();
            ErrorResponse errorResponse = new ErrorResponse(userList);
            return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
        } catch (Throwable t) {
            logger.error("[Error " + t.getClass() + "] " + t.getMessage());
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(-1, t.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
