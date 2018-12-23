package com.software.FindTeamMember.service;

import com.software.FindTeamMember.domain.UserSkill;

/**
 * created by wangzhi 2018-12-23 15:02
 **/
public interface UserSkillService {
    void addOrUpdate(UserSkill userSkill);
    void delete(int id);
}
