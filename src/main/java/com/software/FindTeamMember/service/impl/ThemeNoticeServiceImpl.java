package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.ThemeNotice;
import com.software.FindTeamMember.repository.ThemeNoticeRepos;
import com.software.FindTeamMember.service.ThemeNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by wangzhi 2018-12-21 22:28
 **/
@Service
public class ThemeNoticeServiceImpl implements ThemeNoticeService {

    @Autowired
    private ThemeNoticeRepos themeNoticeRepos;

    @Override
    public void delete(int id) {
        ThemeNotice themeNotice = new ThemeNotice();
        themeNotice.setId(id);
        themeNoticeRepos.delete(themeNotice);
    }
}
