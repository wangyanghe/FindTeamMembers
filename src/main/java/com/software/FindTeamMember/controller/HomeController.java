package com.software.FindTeamMember.controller;

import com.software.FindTeamMember.domain.Skill;
import com.software.FindTeamMember.domain.User;
import com.software.FindTeamMember.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by wangzhi 2018-10-31 19:44
 **/
@Controller
public class HomeController {

    @Autowired
    private UserRepos userRepos;

    @RequestMapping("")
    public ModelAndView home() {
        List<User> users = userRepos.findAll();
        Map param = new HashMap();
        param.put("users", users);
        return new ModelAndView("home", param);
    }

}
