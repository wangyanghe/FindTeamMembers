package com.software.FindTeamMember.repository;

import com.software.FindTeamMember.domain.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * created by wangzhi 2018-12-23 15:03
 **/
@Repository
public interface UserSkillRepos extends JpaRepository<UserSkill, Integer>, JpaSpecificationExecutor<UserSkill> {
}
