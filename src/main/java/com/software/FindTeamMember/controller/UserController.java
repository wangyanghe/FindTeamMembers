package com.software.FindTeamMember.controller;

import com.software.FindTeamMember.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * created by wangzhi 2018-12-18 21:26
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("")
    public ModelAndView user(HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("user", userService.get(userId));
        return new ModelAndView("user", param);
    }

    @RequestMapping("/{userId}")
    public ModelAndView user(@PathVariable int userId){
        Map param = new HashMap();
        param.put("user", userService.get(userId));
        return new ModelAndView("user", param);
    }

    @RequestMapping("skill")
    public ModelAndView skill(HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("skills", userService.getSkill(userId));
        return new ModelAndView("user/user_skill", param);
    }

    @RequestMapping("info")
    public ModelAndView userInfo(HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("user", userService.get(userId));
        return new ModelAndView("user/user_info", param);
    }

    @RequestMapping("attention")
    public ModelAndView attention(HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("attention", userService.getAttention(userId));
        return new ModelAndView("user/user_attention", param);
    }

    @RequestMapping("fans")
    public ModelAndView fans(HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("fans", userService.getFans(userId));
        return new ModelAndView("user/user_fans", param);
    }

    @RequestMapping("friend")
    public ModelAndView friend(HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("friend", userService.getFriends(userId));
        return new ModelAndView("user/user_friend", param);
    }

    @RequestMapping("need")
    public ModelAndView need(HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("need", userService.getNeed(userId));
        return new ModelAndView("user/user_need", param);
    }

    @RequestMapping("theme")
    public ModelAndView theme(HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("themes", userService.getTheme(userId));
        return new ModelAndView("user/user_theme", param);
    }
}
