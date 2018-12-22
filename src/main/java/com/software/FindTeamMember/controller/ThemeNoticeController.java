package com.software.FindTeamMember.controller;

import com.software.FindTeamMember.service.ThemeNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * created by wangzhi 2018-12-21 22:08
 **/
@Controller
@RequestMapping("/themeNotice")
public class ThemeNoticeController {

    @Autowired
    private ThemeNoticeService themeNoticeService;

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("id") int themeNoticeId, @RequestParam("themeId") int themeId) {
        themeNoticeService.delete(themeNoticeId);
        return new ModelAndView("redirect:/theme/" + themeId);
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(@RequestParam("noticeId") int noticeId, @RequestParam("content") String content) {
        themeNoticeService.update(noticeId, content);
        return "ok";
    }

    @RequestMapping("/create")
    @ResponseBody
    public String create(@RequestParam("content") String content, @RequestParam("themeId") int themeId) {
        themeNoticeService.create(content, themeId);
        return "ok";
    }
}
