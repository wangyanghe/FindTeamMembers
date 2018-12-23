package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.UserSkill;
import com.software.FindTeamMember.repository.UserSkillRepos;
import com.software.FindTeamMember.service.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by wangzhi 2018-12-23 15:03
 **/
@Service
public class UserSkillServiceImpl implements UserSkillService {

    @Autowired
    private UserSkillRepos userSkillRepos;

    @Override
    public void addOrUpdate(UserSkill userSkill) {
        userSkillRepos.save(userSkill);
    }

    @Override
    public void delete(int id) {
        userSkillRepos.deleteById(id);
    }
}
