package com.springboot.backend.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springboot.backend.model.User;
import com.springboot.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> validateUser(@RequestBody User user) {
        Optional<User> authenticatedUser = userService.validateUser(user.getName(), user.getPassword());
        return authenticatedUser
            .map(userObj -> ResponseEntity.ok((Object) "Login successful"))
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body((Object) "Invalid credentials"));
    }

}
