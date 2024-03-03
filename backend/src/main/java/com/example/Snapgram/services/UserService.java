package com.example.Snapgram.services;

import org.springframework.stereotype.Service;

import com.example.Snapgram.dao.UserDao;
import com.example.Snapgram.models.User;

@Service
public class UserService {
    UserDao userDao;
    UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    public User createUser(User user) {
        return userDao.createUser(user);
    }
}