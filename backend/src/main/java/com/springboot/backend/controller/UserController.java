package com.springboot.backend.controller;

import java.util.*;
import org.springframework.http.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.backend.model.User;
import com.springboot.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getUserFromSession(HttpServletRequest request) {
        var session = request.getSession(false);
        if (session == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        var email = (String) session.getAttribute("email");
        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        var user = userService.getUser(email);
        return (user != null)
            ? ResponseEntity.ok(user)
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> validateUser(@RequestBody User user) {
        Optional<User> authenticatedUser = userService.validateUser(user.getEmail(), user.getPassword());
        return authenticatedUser
            .map(userObj -> ResponseEntity.ok((Object) "Login successful"))
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body((Object) "Invalid credentials"));
    }

    @PostMapping("/session/login")
    public ResponseEntity<String> sessionLogin(@RequestBody User user, HttpServletRequest request) {
        User dbUser = userService.getUser(user.getEmail());
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            var session = request.getSession(true); // 🔹 Creates a session if not exists
            session.setAttribute("email", user.getEmail());
            return ResponseEntity.ok("Login successful - session active");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials - session");
    }

    @GetMapping("/session/logout")
    public ResponseEntity<String> sessionLogout(HttpServletRequest request) {
        var session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok("Logout successful - session terminated");
    }
}
