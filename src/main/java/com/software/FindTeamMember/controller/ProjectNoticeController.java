package com.software.FindTeamMember.controller;

import com.software.FindTeamMember.service.ProjectNoticeService;
import com.software.FindTeamMember.service.ThemeNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by wangzhi 2018-12-21 22:08
 **/
@Controller
@RequestMapping("/projectNotice")
public class ProjectNoticeController {

    @Autowired
    private ProjectNoticeService projectNoticeService;

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("id") int projectNoticeId, @RequestParam("projectId") int projectId) {
        projectNoticeService.delete(projectNoticeId);
        return new ModelAndView("redirect:/project/detail?id=" + projectId);
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(@RequestParam("noticeId") int noticeId, @RequestParam("content") String content) {
        projectNoticeService.update(noticeId, content);
        return "ok";
    }

    @RequestMapping("/create")
    @ResponseBody
    public String create(@RequestParam("content") String content, @RequestParam("projectId") int projectId) {
        projectNoticeService.create(content, projectId);
        return "ok";
    }
}
