package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.Post;
import com.software.FindTeamMember.repository.PostRepos;
import com.software.FindTeamMember.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepos postRepos;

    @Override
    public List<Post> findTenPosts(int id) {
        return postRepos.findAll();
    }

    @Override
    public void createPost(Post post){
        postRepos.save(post);
    }
}
