package com.software.FindTeamMember.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.software.FindTeamMember.domain.Skill;
import com.software.FindTeamMember.domain.User;
import com.software.FindTeamMember.domain.UserSkill;
import com.software.FindTeamMember.service.SkillService;
import com.software.FindTeamMember.service.UserService;
import com.software.FindTeamMember.service.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by wangzhi 2018-12-03 23:46
 **/
@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private UserSkillService userSkillService;

    @RequestMapping("/toRegister")
    public ModelAndView toRegister(){
        Map param = new HashMap();
        param.put("skills", skillService.getAll());
        return new ModelAndView("register", param);
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam("userName") String userName,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "resume", required = false) String resume,
                                 @RequestParam(value = "email", required = false) String email,
                                 @RequestParam(value = "skills", required = false) String skills,
                                 @RequestParam(value = "need[]", required = false) int[] need, HttpSession session) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        if (resume == null) resume = "";
        user.setResume(resume);
        if (email == null) email = "";
        user.setEmail(email);
        user.setUserSkills(null);
        List<Skill> needSkills = new ArrayList<>();
        if (need != null) {
            for (int needId : need) {
                Skill skill = new Skill();
                skill.setId(needId);
                needSkills.add(skill);
            }
        }
        user.setNeedSkills(needSkills);
        userService.addOrUpdate(user);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, String> skills1;
            skills1 = mapper.readValue(skills, Map.class);
            for (Map.Entry entry : skills1.entrySet()) {
                UserSkill userSkill = new UserSkill();
                Skill aSkill = new Skill();
                aSkill.setId(Integer.valueOf((String) entry.getKey()));
                userSkill.setSkill(aSkill);
                userSkill.setFamiliarity(Integer.valueOf((String) entry.getValue()));
                userSkill.setUser(user);
                userSkillService.addOrUpdate(userSkill);
            }
        } catch (IOException ignored) {
        }
        user = userService.check(userName, password);
        session.setAttribute("username", userName);
        session.setAttribute("userid", user.getId());
        return "ok";
    }
}
