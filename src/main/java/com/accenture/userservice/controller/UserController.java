package com.accenture.userservice.controller;

import com.accenture.userservice.model.dto.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public interface UserController {

    @PostMapping(value = "/createUser")
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO newUser);

    @DeleteMapping("/removeUser/{id}")
    ResponseEntity<String> removeUser(@PathVariable(name="id") Long id);

    @GetMapping("/getUser/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable(name="id") Long id);

    @GetMapping("/existUser/{id}")
    ResponseEntity<Boolean> existUser(@PathVariable(name="id") Long id);

    @GetMapping("/list")
    ResponseEntity<List<UserDTO>> list();

}
