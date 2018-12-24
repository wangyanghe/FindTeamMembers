package com.software.FindTeamMember.service.impl;

import com.software.FindTeamMember.domain.Post;
import com.software.FindTeamMember.domain.Theme;
import com.software.FindTeamMember.repository.PostRepos;
import com.software.FindTeamMember.repository.ThemeRepos;
import com.software.FindTeamMember.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<Theme> getHotTheme() {
        List<Theme> themes = themeRepos.findAll();
        Map hotTheme = new HashMap();
        for (Theme theme: themes) {
//            String content = theme.getContent();
            List<Post> post = theme.getPosts();
            int count = post.size();
            hotTheme.put(theme,count);
        }
        List<Map.Entry<Theme, Integer>> entryList = new ArrayList<>(hotTheme.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        List<Theme> themeContent = new ArrayList<>();
        for (Map.Entry<Theme, Integer> item :
                entryList) {
            themeContent.add(item.getKey());
        }

        return themeContent;
    }

    @Override
    public Theme getTheme(int id) {
        return themeRepos.getOne(id);
    }

    @Override
    public Page<Theme> getThemes(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return themeRepos.findAll(pageable);
    }

    @Override
    public void save(Theme theme) {
        themeRepos.save(theme);
    }
}

class MapValueComparator implements Comparator<Map.Entry<Theme, Integer>> {
    @Override
    public int compare(Map.Entry<Theme, Integer> me1, Map.Entry<Theme, Integer> me2) {
        return me2.getValue().compareTo(me1.getValue());
    }
}
