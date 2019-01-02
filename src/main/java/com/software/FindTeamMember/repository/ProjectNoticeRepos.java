package com.software.FindTeamMember.repository;

import com.software.FindTeamMember.domain.ProjectNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * created by wangzhi 2018-12-21 22:29
 **/
@Repository
public interface ProjectNoticeRepos extends JpaRepository<ProjectNotice,Integer>, JpaSpecificationExecutor<ProjectNotice> {
}
