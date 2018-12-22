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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.software.FindTeamMember.service.ThemeService;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.HashMap;
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
    private ProjectRepos projectRepos;
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
        return new ModelAndView("projectDetail",param);
    }
//    @RequestMapping("/{projectId}")
//    public ModelAndView project(@PathVariable String projectId){
//        Map param = new HashMap();
//        param.put("user", projectRepos.getOne(Integer.valueOf(projectId)));
//        return new ModelAndView("project", param);
//    }
    @RequestMapping("/newProject")
    public ModelAndView newProjecct(){
        List<Theme> themes = themeService.getAllTheme(1);
        Map newProjecct = new HashMap();
        newProjecct.put("themes",themes);
        return new ModelAndView("newProject", newProjecct);
    }
    @RequestMapping("/postProject")
    public String postProject(@RequestParam("name") String name,@RequestParam("description") String description,@RequestParam("theme_id") int theme_id,HttpSession session){
        int userId = (int) session.getAttribute("userid");
        User user = new User();
        user.setId(userId);
        Theme theme = new Theme();
        theme.setId(theme_id);
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        projectService.createProject(project);
        return "ok";
    }
}
