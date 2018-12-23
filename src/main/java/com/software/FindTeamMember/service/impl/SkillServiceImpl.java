package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.Skill;
import com.software.FindTeamMember.repository.SkillRepos;
import com.software.FindTeamMember.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by wangzhi 2018-12-22 22:25
 **/
@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillRepos skillRepos;

    @Override
    public List<Skill> getAll() {
        return skillRepos.findAll();
    }
}
