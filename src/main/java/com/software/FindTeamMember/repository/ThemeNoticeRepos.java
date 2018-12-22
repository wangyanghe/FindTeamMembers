package com.software.FindTeamMember.repository;

import com.software.FindTeamMember.domain.ThemeNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * created by wangzhi 2018-12-21 22:29
 **/
@Repository
public interface ThemeNoticeRepos extends JpaRepository<ThemeNotice,Integer>, JpaSpecificationExecutor<ThemeNotice> {
}
