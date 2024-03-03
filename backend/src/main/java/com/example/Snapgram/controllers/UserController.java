package com.example.Snapgram.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Snapgram.models.User;
import com.example.Snapgram.services.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
