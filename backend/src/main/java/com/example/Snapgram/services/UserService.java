package com.example.Snapgram.services;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.example.Snapgram.dao.UserDao;
import com.example.Snapgram.models.User;

@Service
public class UserService {
    UserDao userDao;
    UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    public User createUser(User user) throws SQLException {
        return userDao.createUser(user);
    }
    public User getUserById(String userId) throws SQLException {
        return userDao.getUserById(userId);
    }
}