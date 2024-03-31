package com.example.Snapgram.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Snapgram.models.Post;
import com.example.Snapgram.services.PostService;

@RestController
@RequestMapping("api/v1/post")
public class PostController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private PostService postService;

    PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post createpost(@RequestBody Post post) {
        return postService.createPost(post);
    }
}
