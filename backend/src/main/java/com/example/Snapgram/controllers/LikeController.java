package com.example.Snapgram.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Snapgram.models.Like;
import com.example.Snapgram.services.LikeService;

@RestController
@RequestMapping("api/v1/like")
public class LikeController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private LikeService likeService;

    LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public Like createlike(@RequestBody Like like) {
        return likeService.createLike(like);
    }
}
