package com.accenture.userservice.service;

import com.accenture.userservice.exception.UserDAOException;
import com.accenture.userservice.exception.UserServiceException;
import com.accenture.userservice.model.dto.UserDTO;

import java.util.List;


public interface UserService {

    UserDTO saveUser(UserDTO newUser) throws UserServiceException, UserDAOException;

    UserDTO delete(Long id) throws UserServiceException;

    UserDTO findById(Long id) throws UserServiceException;

    Boolean existsById(Long id) throws UserServiceException;

    List<UserDTO> list();

}
