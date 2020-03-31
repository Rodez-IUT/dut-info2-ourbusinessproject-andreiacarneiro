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

        // Réponse 2.5.2:
        // Pour l'affichage de tous les projets 3 requêtes sont générées :
        //  - une pour obtenir tous les projets de la base de données
        //    (basée sur la requête de findAllProjects)
        //  - une requête pour obtenir les informations de la première entreprise
        //  - une dernière pour obtenir les informations de la deuxième entreprise
        // Ces deux dernières requêtes sont rajoutées par Hibernate car la requête
        // de findAllProjects renvoie une liste de Projects et puisque ces objets
        // Project contiennent un attribut Enterprise il faut aller chercher les
        // informations de l'entreprise en question. Ces requêtes ne sont pas "inutiles"
        // mais elles ne sont pas optimisées.
    }
}
