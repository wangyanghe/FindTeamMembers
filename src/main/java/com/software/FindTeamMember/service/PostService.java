package com.software.FindTeamMember.service;

import com.software.FindTeamMember.domain.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    List<Post> findTenPosts(int id);
    Page<Post> findPosts(int page, int size);
    void createPost(Post post);
}
