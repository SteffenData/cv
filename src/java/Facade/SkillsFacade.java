/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Experience;
import Entity.Skills;
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
public class SkillsFacade {
    
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);

   EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
   
   public void setSkillsToExperience (String id,Skills skill){
   
       EntityManager em = emf.createEntityManager();
       
       Experience experience;
       
       try {
           
           experience = em.find(Experience.class, id);
      
           System.out.println(experience.getId());
           
           em.getTransaction().begin();
           skill.setExperience(experience);
           em.persist(skill);
           em.getTransaction().commit();
            
           
       } finally {
           em.close();
       }
   }
   
   public List<Skills> getAllSkillsFromOneExpericence(String id){
   
        EntityManager em = emf.createEntityManager();
        List<Skills> skillsList;
         
         try {
         TypedQuery<Skills> s = em.createQuery("select s from Skills s where s.experience.id =:id", Skills.class);
         s.setParameter("id", id);
         skillsList = s.getResultList();
    } finally {
        em.close();
    }
   
   return skillsList;
   }
    
}
