package com.software.FindTeamMember.repository;

import com.software.FindTeamMember.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepos extends JpaRepository<Post,Integer>, JpaSpecificationExecutor<Post> {
}

