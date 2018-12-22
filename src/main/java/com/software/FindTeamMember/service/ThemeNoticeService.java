package com.software.FindTeamMember.service;

/**
 * created by wangzhi 2018-12-21 22:27
 **/
public interface ThemeNoticeService {
    void delete(int id);
    void update(int id, String content);
    void create(String content, int themeId);
}
