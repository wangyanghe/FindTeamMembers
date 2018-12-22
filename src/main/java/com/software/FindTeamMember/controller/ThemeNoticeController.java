package com.software.FindTeamMember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by wangzhi 2018-12-21 22:08
 **/
@Controller
@RequestMapping("/themeNotice")
public class ThemeNoticeController {
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") String themeNoticeId) {

        return "ok";
    }
}
