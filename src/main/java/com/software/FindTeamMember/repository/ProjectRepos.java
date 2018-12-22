package com.software.FindTeamMember.repository;

import com.software.FindTeamMember.domain.Project;
import com.software.FindTeamMember.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepos extends JpaRepository<Project, Integer>, JpaSpecificationExecutor<Project> {
}
