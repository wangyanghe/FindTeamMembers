package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.Project;
import com.software.FindTeamMember.domain.User;
import com.software.FindTeamMember.domain.Skill;
import com.software.FindTeamMember.domain.Theme;
import com.software.FindTeamMember.domain.UserSkill;
import com.software.FindTeamMember.repository.UserRepos;
import com.software.FindTeamMember.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by wangzhi 2018-12-03 23:30
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepos userRepos;

    @Override
    public User check(String userName, String password) {
        User user = userRepos.findByUserName(userName);
        if (user == null)
            return null;
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public boolean exist(String userName) {
        return false;
    }

    @Override
    public User addOrUpdate(User user) {
        return userRepos.save(user);
    }

    @Override
    public User get(int id) {
        return userRepos.getOne(id);
    }

    @Override
    public List<UserSkill> getSkill(int id) {
        return userRepos.getOne(id).getUserSkills();
    }

    @Override
    public List<User> getAttention(int id) {
        return userRepos.findAttention(id);
    }

    @Override
    public List<User> getAllAttention(int id) {
        return userRepos.getOne(id).getAttention();
    }

    @Override
    public List<User> getFans(int id) {
        return userRepos.findFans(id);
    }

    @Override
    public List<User> getFriends(int id) {
        return userRepos.findFriend(id);
    }

    @Override
    public List<Skill> getNeed(int id) {
        return userRepos.getOne(id).getNeedSkills();
    }

    @Override
    public List<Theme> getTheme(int id) {
        return userRepos.getOne(id).getThemes();
    }

    @Override
    public List<Project> getProjects(int id) {
        User user = userRepos.getOne(id);
        return user.getProjects();
    }

    @Override
    public void attention(int id, int anotherId) {
        User user = userRepos.getOne(id);
        User user1 = new User();
        user1.setId(anotherId);
        user.getAttention().add(user1);
        userRepos.save(user);
    }

    @Override
    public void disAttention(int id, int anotherId) {
        User user = userRepos.getOne(id);
        User user1 = userRepos.getOne(anotherId);
        user.getAttention().remove(user1);
        userRepos.save(user);
    }
}
