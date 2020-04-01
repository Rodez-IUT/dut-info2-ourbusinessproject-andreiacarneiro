package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class InitializationService {

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    private Project project1E1;
    private Project project1E2;
    private Project project2E1;

    private Enterprise enterprise1;
    private Enterprise enterprise2;


    @Transactional
    public void initProjects() throws Exception {
        // Réponse 2.4.2
        // La notation @Transactionnal au dessus de cette méthode permet de spécifier
        // quelle sera exécutée comme une transaction. Une transaction étant atomique,
        // si une des opérations échoue, toutes les opérations sont annulées (rollback).
        // Donc ici, si au moins une insertion d'un des 3 Projects échoue alors ce sont
        // toutes les insertions qui sont annulées (donc aucune insertion en base de données).


        initEnterprise1();
        initEnterprise2();

        initAndSaveProject1E1();
        initAndSaveProject1E2();
        initAndSaveProject2E1();

    }

    private void initAndSaveProject1E1() throws Exception {
        project1E1 = enterpriseProjectService.findProjectByTitle("p1e1");
        if (project1E1 == null) {
            project1E1 = new Project("p1e1", "p1 e1 description", enterprise1);
            enterpriseProjectService.save(project1E1);
            enterprise1 = project1E1.getEnterprise();
        }
    }

    private void initAndSaveProject1E2() throws Exception {
        project1E2 = enterpriseProjectService.findProjectByTitle("p1e2");
        if (project1E2 == null) {
            project1E2 = new Project("p1e2","p1 e2 description", enterprise2);
            enterpriseProjectService.save(project1E2);
            enterprise2 = project1E2.getEnterprise();
        }
    }

    private void initAndSaveProject2E1() throws Exception {
        project2E1 = enterpriseProjectService.findProjectByTitle("p2e1");
        if (project2E1 == null) {
            project2E1 = new Project("p2e1","p2 e1 description", enterprise1);
            enterpriseProjectService.save(project2E1);
        }
    }

    private void initEnterprise1() throws Exception {
        enterprise1 = enterpriseProjectService.findEnterpriseByName("E1");
        if (enterprise1 == null) {
            enterprise1 = new Enterprise();
            enterprise1.setName("E1");
            enterprise1.setDescription("E1 description");
            enterprise1.setContactName("Paul Durand");
            enterprise1.setContactEmail("paul.durand@e1.com");
        }
    }

    private void initEnterprise2() throws Exception {
        enterprise2 = enterpriseProjectService.findEnterpriseByName("E2");
        if (enterprise2 == null) {
            enterprise2 = new Enterprise();
            enterprise2.setName("E2");
            enterprise2.setDescription("E2 description");
            enterprise2.setContactName("Paul Dupond");
            enterprise2.setContactEmail("paul.dupond@e2.com");
        }
    }

    public Project getProject1E1() {
        return project1E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public Project getProject2E1() {
        return project2E1;
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }
}
