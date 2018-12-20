package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.Theme;
import com.software.FindTeamMember.repository.ThemeRepos;
import com.software.FindTeamMember.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    private ThemeRepos themeRepos;

    @Override
    public List<Theme> getAllTheme(int id) {
        return themeRepos.findAll();
    }
}
