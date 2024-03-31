package com.example.Snapgram.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.Snapgram.models.Post;

@Repository
public class PostDao {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public Post creatPost(Post post) {
        logger.info("Create post in DB");
        return post;
    }
    public Post createPost(Post post) {
        throw new UnsupportedOperationException("Unimplemented method 'createPost'");
    }

}
