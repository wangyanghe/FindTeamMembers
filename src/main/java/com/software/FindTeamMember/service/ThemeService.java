package com.software.FindTeamMember.service;

import com.software.FindTeamMember.domain.Post;
import com.software.FindTeamMember.domain.Theme;

import java.util.List;
import java.util.Map;

public interface ThemeService {
    List<Theme> getAllTheme(int id);
    List<String> getHotTheme();
}
