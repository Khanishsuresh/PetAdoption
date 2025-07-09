package com.springboot.backend.service;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.backend.model.User;
import com.springboot.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> validateUser(String email , String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }
}
