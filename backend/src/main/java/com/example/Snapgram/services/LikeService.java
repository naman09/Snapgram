package com.example.Snapgram.services;

import org.springframework.stereotype.Service;

import com.example.Snapgram.dao.LikeDao;
import com.example.Snapgram.models.Like;

@Service
public class LikeService {
    LikeDao likeDao;
    LikeService(LikeDao likeDao) {
        this.likeDao = likeDao;
    }
    public Like createLike(Like like) {
        return likeDao.createLike(like);
    }
}
