package com.software.FindTeamMember.service;

import com.software.FindTeamMember.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> findTenPosts(int id);
    void createPost(Post post);
}
