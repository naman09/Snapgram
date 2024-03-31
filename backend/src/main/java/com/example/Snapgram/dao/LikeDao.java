package com.example.Snapgram.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.Snapgram.models.Like;

@Repository
public class LikeDao {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public Like creatLike(Like like) {
        logger.info("Create like in DB");
        return like;
    }
    public Like createLike(Like like) {
        throw new UnsupportedOperationException("Unimplemented method 'createLike'");
    }
}
