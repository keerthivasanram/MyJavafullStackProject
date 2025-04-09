package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public boolean authenticate(String username, String password) {
        User existingUser = userRepository.findByUsername(username);
        return existingUser != null && existingUser.getPassword().equals(password);
    }
}
