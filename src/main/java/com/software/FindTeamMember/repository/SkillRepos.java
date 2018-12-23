package com.software.FindTeamMember.repository;

import com.software.FindTeamMember.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * created by wangzhi 2018-12-22 22:26
 **/
@Repository
public interface SkillRepos extends JpaRepository<Skill, Integer>, JpaSpecificationExecutor<Skill> {
}
