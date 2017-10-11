/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Profile;
import deploy.DeploymentConfiguration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author juhlm
 */
public class ProfileFacade {
    
         EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void createNewProfile(Profile profile){
    
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            em.persist(profile);
            em.getTransaction().commit();
  
        } finally {
            em.close();
        }
    
    }
    
    public Profile getProfile(String id){
    
        Profile profile;
        
        EntityManager em = getEntityManager();
         
        try {
         
          profile = em.find(Profile.class, id);
          
        } finally {
            em.close();
        }
        
        return profile;
    }
}
