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
import org.springframework.web.bind.annotation.PathVariable;
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
 * created by wangzhi 2018-12-18 21:26
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private UserSkillService userSkillService;

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

    @RequestMapping("preInvite")
    public ModelAndView preInvite(@RequestParam("userId") int memberId, HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("projects", userService.getProjects(userId));
        param.put("memberId", memberId);
        return new ModelAndView("user/inviteMember", param);
    }

    @RequestMapping("disAttention")
    public ModelAndView disAttention(@RequestParam("userId") int memberId, HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        userService.disAttention(userId, memberId);
        return new ModelAndView("redirect:/user");
    }

    @RequestMapping("addAttention")
    public ModelAndView attention(@RequestParam("userId") int memberId, HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        userService.attention(userId, memberId);
        return new ModelAndView("redirect:/user");
    }

    @RequestMapping("toEdit")
    public ModelAndView toEdit(HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("user", userService.get(userId));
        param.put("skills", skillService.getAll());
        param.put("mySkills", userService.getSkill(userId));
        param.put("needs", userService.getNeed(userId));
        return new ModelAndView("user/edit", param);
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(@RequestParam("userName") String userName,
                               @RequestParam(value = "resume", required = false) String resume,
                               @RequestParam(value = "email", required = false) String email,
                               @RequestParam(value = "skills", required = false) String skills,
                               @RequestParam(value = "need[]",required = false) int[] need, HttpSession session) {
        int userId = (int) session.getAttribute("userid");
        User user = userService.get(userId);
        user.setUserName(userName);
        if (resume == null) resume = "";
        user.setResume(resume);
        if (email == null) email = "";
        user.setEmail(email);

        List<UserSkill> userSkills = user.getUserSkills();
        for (UserSkill userSkill: userSkills) {
            userSkillService.delete(userSkill.getId());
        }
        user.setUserSkills(null);

        List<Skill> needSkills = new ArrayList<>();
        if (need != null) {
            for (int needId:need) {
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
            for (Map.Entry entry: skills1.entrySet()) {
                UserSkill userSkill = new UserSkill();
                Skill aSkill = new Skill();
                aSkill.setId(Integer.valueOf((String)entry.getKey()));
                userSkill.setSkill(aSkill);
                userSkill.setFamiliarity(Integer.valueOf((String)entry.getValue()));
                userSkill.setUser(user);
                userSkillService.addOrUpdate(userSkill);
            }
        } catch (IOException ignored) {
        }


        return "ok";
    }
}
