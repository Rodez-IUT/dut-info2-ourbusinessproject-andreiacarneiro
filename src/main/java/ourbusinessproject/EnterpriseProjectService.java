package ourbusinessproject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void save(Project project) {
        Enterprise enterprise = project.getEnterprise();

        if (enterprise != null) {
            // Association du projet à l'entreprise
            enterprise.addProject(project);
            this.save(enterprise);
        }

        entityManager.persist(project);
        entityManager.flush();
    }

    public void save(Enterprise enterprise) {
        entityManager.persist(enterprise);
        entityManager.flush();
    }

    public Enterprise findEnterpriseById(Long id) {
        return entityManager.find(Enterprise.class, id);
    }

    public Project findProjectById(Long id) {
        return entityManager.find(Project.class, id);
    }

    public List<Project> findAllProjects() {
        String query = "SELECT p FROM Project p ORDER BY p.title";
        TypedQuery<Project> queryObj = entityManager.createQuery(query, Project.class);
        return queryObj.getResultList();
    }
}
