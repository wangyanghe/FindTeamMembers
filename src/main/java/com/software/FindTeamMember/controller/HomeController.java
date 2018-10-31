package com.software.FindTeamMember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by wangzhi 2018-10-31 19:44
 **/
@Controller
public class HomeController {

    @RequestMapping("")
    public String home() {
        return "home";
    }

}
