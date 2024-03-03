package com.example.Snapgram.services;

import org.springframework.stereotype.Service;

import com.example.Snapgram.dao.PostDao;
import com.example.Snapgram.models.Post;

@Service
public class PostService {
    PostDao postDao;
    PostService(PostDao postDao) {
        this.postDao = postDao;
    }
    public Post createPost(Post post) {
        return postDao.createPost(post);
    }
}
