package ourbusinessproject;


import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        entityManager.persist(project);
        entityManager.flush();
    }

    public void save(Enterprise enterprise) {
        entityManager.persist(enterprise);
        entityManager.flush();
    }

    public Enterprise findEnterpriseById(Long id) {
        Enterprise enterprise = entityManager.find(Enterprise.class, id);
        return enterprise;
    }

    public Project findProjectById(Long id) {
        Project project = entityManager.find(Project.class, id);
        return project;
    }
}