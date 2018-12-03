package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.User;
import com.software.FindTeamMember.repository.UserRepos;
import com.software.FindTeamMember.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }
}
