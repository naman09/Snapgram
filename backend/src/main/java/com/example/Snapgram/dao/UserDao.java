package com.example.Snapgram.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.Snapgram.models.User;

@Repository
public class UserDao {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public User creatUser(User user) {
        logger.info("Create user in DB");
        return user;
    }
    public User createUser(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

}
