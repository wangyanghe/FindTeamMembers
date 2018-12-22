package com.software.FindTeamMember.repository;

import com.software.FindTeamMember.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by wangzhi 2018-12-01 16:51
 **/
@Repository
public interface UserRepos extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    User findByUserName(String userName);

    @Query(value = "select id, resume, password, user_name, email from user_attention, user where " +
            "user.id = user_attention.user_id and user_attention.attention_id=?1 " +
            "and user.id NOT IN (SELECT attention_id FROM user_attention WHERE user_id=?1)", nativeQuery = true)
    List<User> findFans(int id);

    @Query(value = "select id, resume, password, user_name, email from user, user_attention where " +
            "user.id = user_attention.user_id and user_attention.attention_id=?1 " +
            "and user.id IN (SELECT attention_id FROM user_attention WHERE user_id=?1)", nativeQuery = true)
    List<User> findFriend(int id);

    @Query(value = "select id, resume, password, user_name, email from user_attention, user where " +
            "user.id = user_attention.attention_id and user_attention.user_id=?1 " +
            "and user.id NOT IN (SELECT user_id FROM user_attention WHERE attention_id=?1)", nativeQuery = true)
    List<User> findAttention(int id);
}
