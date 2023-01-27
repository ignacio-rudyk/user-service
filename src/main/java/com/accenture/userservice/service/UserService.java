package com.accenture.userservice.service;

import com.accenture.userservice.model.dto.UserDTO;

import java.util.List;


public interface UserService {

    UserDTO saveUser(UserDTO newUser);

    void delete(Long id);

    UserDTO findById(Long id);

    Boolean existsById(Long id);

    List<UserDTO> list();

}
