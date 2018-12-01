package com.software.FindTeamMember.repository;

import com.software.FindTeamMember.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * created by wangzhi 2018-12-01 17:22
 **/
@Repository
public interface ThemeRepos extends JpaRepository<Theme, Integer>, JpaSpecificationExecutor<Theme> {

}
