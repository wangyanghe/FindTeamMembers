package com.software.FindTeamMember.service;
import com.software.FindTeamMember.domain.Project;
import com.software.FindTeamMember.domain.ProjectNotice;
import com.software.FindTeamMember.domain.User;

import java.util.List;
public interface ProjectService {
    List<ProjectNotice> getNotices(int id);
    List<User> getMembers(int project_id);
    void createProject(Project project);
    Project getProject(int id);
    void addMember(int id, int memberId);
}
