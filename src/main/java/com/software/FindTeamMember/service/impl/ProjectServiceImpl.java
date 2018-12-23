package com.software.FindTeamMember.service.impl;
import com.software.FindTeamMember.domain.Project;
import com.software.FindTeamMember.domain.ProjectNotice;
import com.software.FindTeamMember.domain.User;
import com.software.FindTeamMember.repository.ProjectRepos;
import com.software.FindTeamMember.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl  implements ProjectService{

    @Autowired
    private ProjectRepos projectRepos;


    @Override
    public List<ProjectNotice>getNotices(int id){
        Project project = projectRepos.getOne(id);
        List<ProjectNotice>notices = project.getNotices();
        return notices;
    }
    @Override
    public List<User>getMembers(int project_id){
        Project project = projectRepos.getOne(project_id);
        List<User>members =project.getMembers();
        return members;
    }
    @Override
    public void createProject(Project project){
        projectRepos.save(project);
    }

    @Override
    public Project getProject(int id) {
        return projectRepos.getOne(id);
    }

    @Override
    public void addMember(int id, int memberId) {
        Project project = projectRepos.getOne(id);
        User user = new User();
        user.setId(memberId);
        project.getMembers().add(user);
        projectRepos.save(project);
    }
}

