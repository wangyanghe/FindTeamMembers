package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.Theme;
import com.software.FindTeamMember.domain.ThemeNotice;
import com.software.FindTeamMember.repository.ThemeNoticeRepos;
import com.software.FindTeamMember.service.ThemeNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

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

    @Override
    public void update(int id, String content) {
        ThemeNotice themeNotice = themeNoticeRepos.getOne(id);
        themeNotice.setContent(content);
        themeNoticeRepos.save(themeNotice);
    }

    @Override
    public void create(String content, int themeId) {
        ThemeNotice themeNotice = new ThemeNotice();
        themeNotice.setContent(content);
        themeNotice.setCreateTime(new Timestamp(System.currentTimeMillis()));
        Theme theme = new Theme();
        theme.setId(themeId);
        themeNotice.setTheme(theme);
        themeNoticeRepos.save(themeNotice);
    }
}
