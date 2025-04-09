package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")  // Allow React Frontend Access
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        boolean isAuthenticated = userService.authenticate(user.getUsername(), user.getPassword());
    
        if (isAuthenticated) {
            response.put("message", "Login successful");
            response.put("status", "success");
        } else {
            response.put("message", "Invalid username or password");
            response.put("status", "failed");
        }
        return response;
    }
    

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.saveUser(user);
    }
    
}
