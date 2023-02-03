package com.accenture.userservice.controller;

import com.accenture.userservice.model.ErrorResponse;
import com.accenture.userservice.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user")
public interface UserController {

    @PostMapping(value = "/createUser")
    ResponseEntity<ErrorResponse> createUser(@RequestBody UserDTO newUser);

    @DeleteMapping("/removeUser/{id}")
    ResponseEntity<ErrorResponse> removeUser(@PathVariable(name="id") Long id);

    @GetMapping("/getUser/{id}")
    ResponseEntity<ErrorResponse> getUser(@PathVariable(name="id") Long id);

    @GetMapping("/existUser/{id}")
    ResponseEntity<ErrorResponse> existUser(@PathVariable(name="id") Long id);

    @GetMapping("/list")
    ResponseEntity<ErrorResponse> list();

}
