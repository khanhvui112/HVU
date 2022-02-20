package com.hvu.HVU.Services;


import com.hvu.HVU.Repository.PostsRepository;
import com.hvu.HVU.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsSevices {

    @Autowired
    private PostsRepository postsRepository;

    public void addPosts(List<Posts> posts){
        postsRepository.saveAll(posts);
    }
}
