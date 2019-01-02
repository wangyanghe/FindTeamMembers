package com.software.FindTeamMember.controller;
import com.software.FindTeamMember.domain.Project;
import com.software.FindTeamMember.domain.ProjectNotice;
import com.software.FindTeamMember.domain.Theme;
import com.software.FindTeamMember.domain.User;
import com.software.FindTeamMember.service.ProjectService;
import com.software.FindTeamMember.repository.ProjectRepos;
import com.software.FindTeamMember.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.software.FindTeamMember.service.ThemeService;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * created by yangchenwei 2018-12-20 21:26
 **/
@Controller
@Repository
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;
    @Autowired
    private ThemeService themeService;

    @RequestMapping("")
    public ModelAndView project(HttpSession session){
        int userId = (int) session.getAttribute("userid");
        Map param = new HashMap();
        param.put("projects",userService.getProjects(userId));
        return new ModelAndView("project",param);
    }

    @RequestMapping("/detail")
    public ModelAndView detail(@RequestParam("id") int projectId, HttpSession session){
        Project project = projectService.getProject(projectId);
        Map param = new HashMap();
        param.put("project",project);
        List<User> members = project.getMembers();
        param.put("members",members);
        List<ProjectNotice> notices = project.getNotices();
        param.put("notices",notices);
        String name = project.getName();
        param.put("name",name);
        int userId = (int) session.getAttribute("userid");
        for (User user : members){
            if (user.getId() == userId) {
                return new ModelAndView("projectAdminDetail",param);
            }
        }
        return new ModelAndView("projectDetail",param);
    }

    @RequestMapping("/newProject")
    public ModelAndView newProjecct(){
        List<Theme> themes = themeService.getAllTheme(1);
        Map newProjecct = new HashMap();
        newProjecct.put("themes",themes);
        return new ModelAndView("project/newProject", newProjecct);
    }
    @RequestMapping("/notice")
    public ModelAndView notice (@RequestParam("id") int projectId, HttpSession session){
       Project project = projectService.getProject(projectId);
       Map param = new HashMap();
        List<ProjectNotice> notices = project.getNotices();
        param.put("notices",notices);
        int userId = (int) session.getAttribute("userid");
        List<User> members = project.getMembers();
        for (User user : members){
            if (user.getId() == userId) {
                return new ModelAndView("project/project_admin_notice",param);
            }
        }
        return new ModelAndView("project/project_notice",param);
    }
    @RequestMapping("/member")
    public ModelAndView member(@RequestParam("id") int projectId,HttpSession session){
        Project project = projectService.getProject(projectId);
        Map param = new HashMap();
        List<User> members = project.getMembers();
        param.put("members",members);
        return new ModelAndView("project/project_member",param);
    }
    @RequestMapping("/edit")
    @ResponseBody
    public String edit(@RequestParam("name") String name,@RequestParam("description") String description,@RequestParam("id") int projectId, HttpSession session){
        Project project = projectService.getProject(projectId);
        project.setName(name);
        project.setDescription(description);
        projectService.createProject(project);
        return "ok";
    }

    @RequestMapping("/postProject")
    @ResponseBody
    public String postProject(@RequestParam("name") String name,@RequestParam("description") String description,@RequestParam("theme_id") int theme_id,HttpSession session){
        int userId = (int) session.getAttribute("userid");
        User user = new User();
        user.setId(userId);
        Theme theme = new Theme();
        theme.setId(theme_id);
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        List<User> member = new ArrayList<>();
        member.add(user);
        project.setMembers(member);
        project.setTheme(theme);
        projectService.createProject(project);
        return "ok";
    }

    @RequestMapping(value = "/invite", method = RequestMethod.POST)
    @ResponseBody
    public String invite(@RequestParam("memberId") int memberId, @RequestParam("projectId") int projectId) {
        projectService.addMember(projectId, memberId);
        return "ok";
    }
}
