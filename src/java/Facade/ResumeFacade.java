/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Profile;
import Entity.Resume;
import deploy.DeploymentConfiguration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author juhlm
 */
public class ResumeFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);

   EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
   
public void createResumeForProfile(String id, Resume resume){

    EntityManager em = getEntityManager();
    
    try {
        
        Profile profile = em.find(Profile.class, id);
        resume.setProfile(profile);
        em.getTransaction().begin();
        em.persist(resume);
        em.getTransaction().commit();
        
    } finally{
        em.close();
    }
}

public Resume getResumeForProfile(String id){

    EntityManager em = getEntityManager();
    
    Resume resume;
    
    try {
         TypedQuery r = em.createQuery("select r from Resume r where r.profile.id =:id", Resume.class);
         r.setParameter("id", id);
         resume = (Resume) r.getSingleResult();
    } finally {
        em.close();
    }
         return resume;
}

public Resume getResumeWithExperienceAndSkills(String id){
    
    

return null;
}    
}
