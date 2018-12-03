package com.software.FindTeamMember.controller;

import com.software.FindTeamMember.domain.User;
import com.software.FindTeamMember.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * created by wangzhi 2018-12-03 23:16
 **/
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/landing")
    public String landing() {
        return "landing";
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("username") String userName, @RequestParam("password") String password, HttpSession session) {
        User user = userService.check(userName, password);
        if (user != null) {
            session.setAttribute("username", userName);
            session.setAttribute("userid", user.getId());
            return new ModelAndView("redirect:/");
        }
        Map param = new HashMap();
        param.put("wrongOfTelOrPsw", true);
        return new ModelAndView("landing", param);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("userid");
        return "landing";
    }

}
