package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.Project;
import com.software.FindTeamMember.domain.ProjectNotice;
import com.software.FindTeamMember.domain.Theme;
import com.software.FindTeamMember.domain.ThemeNotice;
import com.software.FindTeamMember.repository.ProjectNoticeRepos;
import com.software.FindTeamMember.service.ProjectNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * created by wangzhi 2018-12-21 22:28
 **/
@Service
public class ProjectNoticeServiceImpl implements ProjectNoticeService {

    @Autowired
    private ProjectNoticeRepos projectNoticeRepos;

    @Override
    public void delete(int id) {
        ProjectNotice projectNotice = new ProjectNotice();
        projectNotice.setId(id);
        projectNoticeRepos.delete(projectNotice);
    }

    @Override
    public void update(int id, String content) {
        ProjectNotice projectNotice = new ProjectNotice();
        projectNotice.setContent(content);
        projectNoticeRepos.save(projectNotice);
    }

    @Override
    public void create(String content, int projectId) {
        ProjectNotice projectNotice = new ProjectNotice();
        projectNotice.setContent(content);
        projectNotice.setCreateTime(new Timestamp(System.currentTimeMillis()));
        Project project = new Project();
        project.setId(projectId);
        projectNotice.setProject(project);
        projectNoticeRepos.save(projectNotice);
    }
}
