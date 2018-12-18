package com.software.FindTeamMember.controller;

import com.software.FindTeamMember.repository.UserRepos;
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
    private UserRepos userRepos;

    @RequestMapping("")
    public ModelAndView user(HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("user", userRepos.getOne(userId));
        return new ModelAndView("user", param);
    }

    @RequestMapping("/{userId}")
    public ModelAndView user(@PathVariable String userId){
        Map param = new HashMap();
        param.put("user", userRepos.getOne(Integer.valueOf(userId)));
        return new ModelAndView("user", param);
    }
}
