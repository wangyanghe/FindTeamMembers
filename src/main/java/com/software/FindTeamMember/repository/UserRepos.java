package com.software.FindTeamMember.repository;

import com.software.FindTeamMember.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * created by wangzhi 2018-12-01 16:51
 **/
@Repository
public interface UserRepos extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

}
