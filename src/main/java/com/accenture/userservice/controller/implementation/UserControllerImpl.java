package com.accenture.userservice.controller.implementation;

import com.accenture.userservice.controller.UserController;
import com.accenture.userservice.model.dto.UserDTO;
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

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO newUser) {
        UserDTO userSaved = userService.saveUser(newUser);
        return new ResponseEntity<UserDTO>(userSaved,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> removeUser(Long id) {
        userService.delete(id);
        ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<UserDTO> getUser(Long id) {
        UserDTO result = userService.findById(id);
        return new ResponseEntity<UserDTO>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> existUser(Long id) {
        Boolean result = userService.existsById(id);
        ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<List<UserDTO>> list() {
        List<UserDTO> result = userService.list();
        ResponseEntity<List<UserDTO>> response = new ResponseEntity<List<UserDTO>>(result, HttpStatus.OK);
        return response;
    }

}
