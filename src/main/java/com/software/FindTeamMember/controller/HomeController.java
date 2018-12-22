package com.software.FindTeamMember.controller;

import com.software.FindTeamMember.domain.Post;
import com.software.FindTeamMember.domain.Skill;
import com.software.FindTeamMember.domain.Theme;
import com.software.FindTeamMember.domain.User;
import com.software.FindTeamMember.repository.PostRepos;
import com.software.FindTeamMember.repository.UserRepos;
import com.software.FindTeamMember.service.PostService;
import com.software.FindTeamMember.service.ThemeService;
import com.software.FindTeamMember.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by wangzhi 2018-10-31 19:44
 **/
@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @Autowired
    private ThemeService themeService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView home() {
//        List<Post> posts = postService.findTenPosts(1);
        Page<Post> posts = postService.findPosts(0,10);
        List<Theme> themeContent = themeService.getHotTheme();
        Map param = new HashMap();
        param.put("posts", posts);
        param.put("hotTheme",themeContent);
        return new ModelAndView("home", param);
    }

    @RequestMapping("/home")
    public ModelAndView home(@RequestParam("page") int page) {
//        List<Post> posts = postService.findTenPosts(1);
        Page<Post> posts = postService.findPosts(page,10);
        List<Theme> themeContent = themeService.getHotTheme();
        Map param = new HashMap();
        param.put("posts", posts);
        param.put("hotTheme",themeContent);
        return new ModelAndView("home", param);
    }

    @RequestMapping("/modal")
    public ModelAndView modal(@RequestParam("content") String content) {
        List<Theme> themes = themeService.getAllTheme(1);
        Map modal = new HashMap();
        modal.put("themes",themes);
        modal.put("content",content);
        return new ModelAndView("modal", modal);
    }

    @RequestMapping("/submit")
    @ResponseBody
    public String submitPost(@RequestParam("content") String content, @RequestParam("id") int id,HttpSession session){
        int userId = (int) session.getAttribute("userid");
        User user = new User();
        user.setId(userId);
        Theme theme = new Theme();
        theme.setId(id);
        Post post = new Post();
        post.setAuthor(user);
        post.setContent(content);
        post.setTheme(theme);
        post.setCreateTime(new Timestamp(System.currentTimeMillis()));
        postService.createPost(post);
        return "ok";
    }

}
