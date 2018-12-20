package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.Post;
import com.software.FindTeamMember.domain.Theme;
import com.software.FindTeamMember.repository.PostRepos;
import com.software.FindTeamMember.repository.ThemeRepos;
import com.software.FindTeamMember.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    private ThemeRepos themeRepos;

    @Autowired
    private PostRepos postRepos;

    @Override
    public List<Theme> getAllTheme(int id) {
        return themeRepos.findAll();
    }

    @Override
    public List<String> getHotTheme() {
        List<Theme> themes = themeRepos.findAll();
        Map hotTheme = new HashMap();
        for (Theme theme: themes) {
            String content = theme.getContent();
            List<Post> post = theme.getPosts();
            int count = post.size();
            hotTheme.put(content,count);
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                hotTheme.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        List<String> themeContent = new ArrayList<>();
        for (Map.Entry<String, Integer> item :
                entryList) {
            themeContent.add(item.getKey());
        }

        return themeContent;
    }
}

class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> me1, Map.Entry<String, Integer> me2) {
        return me1.getValue().compareTo(me2.getValue());
    }
}
