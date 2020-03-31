package ourbusinessproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    EnterpriseProjectService enterpriseProjectService;

    //@Autowired
    //Bootstrap bootstrap;

    public ProjectController(EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }


    @RequestMapping(value = "/projectsWithEnterprises", method = RequestMethod.GET)
    public List<Project> findAllProjectsWithEnterprises() {
        return enterpriseProjectService.findAllProjects();
    }
}
