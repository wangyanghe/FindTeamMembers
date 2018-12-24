package com.software.FindTeamMember.controller;

import com.software.FindTeamMember.domain.Post;
import com.software.FindTeamMember.domain.Theme;
import com.software.FindTeamMember.domain.ThemeNotice;
import com.software.FindTeamMember.domain.User;
import com.software.FindTeamMember.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by wangzhi 2018-12-21 11:34
 **/
@Controller
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @RequestMapping("")
    public ModelAndView theme(@RequestParam(value = "page", required = false) Integer page, HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        if (page == null) {
            page = 0;
        }
        Page<Theme> themes = themeService.getThemes(page, 10);
        Map param = new HashMap();
        param.put("themes", themes);
        if (userId == 1){
            param.put("root", true);
        } else {
            param.put("root", false);
        }
        return new ModelAndView("theme", param);
    }

    @RequestMapping("/{themeId}")
    public ModelAndView themeDetail(@PathVariable int themeId, HttpSession session){
        int userId = (int) session.getAttribute("userid");
        Theme theme = themeService.getTheme(themeId);
        Map param = new HashMap();
        param.put("theme", theme);
        List<ThemeNotice> notices = theme.getNotices();
        param.put("notices", notices);
        if (theme.getAuthor().getId() == userId){
            return new ModelAndView("theme_admin_detail", param);
        }else{
            return new ModelAndView("theme_detail", param);
        }
    }

    @RequestMapping("/notice")
    public ModelAndView notice(@RequestParam("id") int themeId, HttpSession session){
        int userId = (int) session.getAttribute("userid");
        Theme theme = themeService.getTheme(themeId);
        Map param = new HashMap();
        List<ThemeNotice> notices = theme.getNotices();
        param.put("notices", notices);
        if (theme.getAuthor().getId() == userId){
            return new ModelAndView("theme/theme_admin_notice", param);
        }else{
            return new ModelAndView("theme/theme_notice", param);
        }
    }

    @RequestMapping("/posts")
    public ModelAndView posts(@RequestParam("id") int themeId, HttpSession session){
        Theme theme = themeService.getTheme(themeId);
        Map param = new HashMap();
        List<Post> posts = theme.getPosts();
        param.put("posts", posts);
        return new ModelAndView("theme/theme_post", param);
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(@RequestParam("themeId") int themeId, @RequestParam("content") String content){
        Theme theme = themeService.getTheme(themeId);
        theme.setContent(content);
        themeService.save(theme);
        return "ok";
    }

    @RequestMapping("/create")
    @ResponseBody
    public String create(@RequestParam("content") String content, HttpSession session){
        int userId = (int) session.getAttribute("userid");
        Theme theme = new Theme();
        theme.setContent(content);
        User user = new User();
        user.setId(userId);
        theme.setAuthor(user);
        themeService.save(theme);
        return "ok";
    }
}
