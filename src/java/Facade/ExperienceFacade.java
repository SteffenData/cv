/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Experience;
import Entity.Resume;
import deploy.DeploymentConfiguration;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author juhlm
 */
public class ExperienceFacade {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);

   EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
   
   public void setExperienceForResume(String id, Experience experience){
   
       EntityManager em = emf.createEntityManager();
       
       Resume resume;
       
       try {
           
           resume = em.find(Resume.class, id);
           experience.setResume(resume);
           
           em.getTransaction().begin();
           em.persist(experience);
           em.getTransaction().commit();
                   
       } finally {
           em.close();
       } 
   }
   
   public List<Experience> getAllExpericensFromResume(String id){
   
       EntityManager em = emf.createEntityManager();
       
       List<Experience> experienceList;
       
       try {
           
               TypedQuery<Experience> e = em.createQuery("select e from Experience e where e.resume.id =:resumeId", Experience.class);
               e.setParameter("resumeId", id);
               experienceList = e.getResultList();
           
       } finally {
           em.close();
       }
       
       return experienceList;
   }
}
