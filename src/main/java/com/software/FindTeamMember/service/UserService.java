package com.software.FindTeamMember.service;

import com.software.FindTeamMember.domain.Skill;
import com.software.FindTeamMember.domain.Theme;
import com.software.FindTeamMember.domain.Project;
import com.software.FindTeamMember.domain.User;
import com.software.FindTeamMember.domain.UserSkill;

import java.util.List;

/**
 * created by wangzhi 2018-12-03 23:29
 **/
public interface UserService {
    /**
     * 检查用户名和密码是否匹配
     * @param userName 用户名
     * @param password 密码
     * @return 匹配返回用户信息，不匹配返回null
     */
    User check(String userName, String password);

    boolean exist(String userName);

    User addOrUpdate(User user);

    User get(int id);

    List<UserSkill> getSkill(int id);

    List<User> getAttention(int id);

    List<User> getAllAttention(int id);

    List<User> getFans(int id);

    List<User> getFriends(int id);

    List<Skill> getNeed(int id);

    List<Theme> getTheme(int id);

    List<Project> getProjects(int id);
}
