package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.Post;
import com.software.FindTeamMember.repository.PostRepos;
import com.software.FindTeamMember.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<Post> findPosts(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Post> posts = postRepos.findAll(pageable);
        return posts;
    }

    @Override
    public void createPost(Post post){
        postRepos.save(post);
    }


}
