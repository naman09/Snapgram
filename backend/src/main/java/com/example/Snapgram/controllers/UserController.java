package com.example.Snapgram.controllers;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Snapgram.models.User;
import com.example.Snapgram.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) throws SQLException {
        return userService.createUser(user);
    }

    @GetMapping
    public User getUser(@RequestParam String userId) throws SQLException {
        return userService.getUserById(userId);
    }
}
