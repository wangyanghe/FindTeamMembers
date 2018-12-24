package com.software.FindTeamMember.service;

import com.software.FindTeamMember.domain.Post;
import com.software.FindTeamMember.domain.Theme;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ThemeService {
    List<Theme> getAllTheme(int id);
    List<Theme> getHotTheme();
    Theme getTheme(int id);
    Page<Theme> getThemes(int page, int size);
    void save(Theme theme);
}
