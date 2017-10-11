/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFacade;

import Entity.Experience;
import Entity.Mail;
import Entity.Profile;
import Entity.Resume;
import Entity.Skills;
import Facade.ExperienceFacade;
import Facade.MailFacade;
import Facade.ProfileFacade;
import Facade.ResumeFacade;
import Facade.SkillsFacade;
import deploy.DeploymentConfiguration;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author juhlm
 */
public class Testjpa {
    
       EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
  
    public static void main(String[] args) throws Exception {
        
           
     MailFacade mails = new MailFacade();
    
     ExperienceFacade ef = new ExperienceFacade();
     
     String name = "chp";
     int agefrom = 5;
     int ageto = 10;
     int expCode = 1;
     
     List<String> description = new ArrayList<String>();
     
     description.add("dette er første linie 1");
     description.add("dette er første linie 2");
     description.add("dette er første linie 3");
     
     Experience e = new Experience(name, expCode, agefrom, ageto, description);
     
     ef.setExperienceForResume("2",e);
     
    
    }
}    
