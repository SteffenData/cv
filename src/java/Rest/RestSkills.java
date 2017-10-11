/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Skills;
import Facade.SkillsFacade;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author juhlm
 */
@Path("skills/")
public class RestSkills {
    
@GET
@Path("{id}")
@Consumes("application/json")
public Response getAllSkillsForOneExperience(@PathParam("id") String id){

      List<Skills> skillsList = new ArrayList<Skills>();
     JsonArray jsonskillsArray = new JsonArray();
     SkillsFacade sf = new SkillsFacade();
     sf.getAllSkillsFromOneExpericence(id);
     
     for (Skills skillsfromArray : skillsList) {
     JsonObject jsonskill = new JsonObject();
     
     jsonskill.addProperty("skillName", skillsfromArray.getSkillName());
     jsonskill.addProperty("description", skillsfromArray.getDescription());
     jsonskill.addProperty("rating", skillsfromArray.getRating());
     
     
     jsonskillsArray.add(jsonskill);
     }
    
    
return Response.status(Response.Status.OK).entity(jsonskillsArray.toString()).build();
}

@POST
 @Path("add/{id}")
 @Consumes("application/json")
 public void insertExperienceToResume(@PathParam("id") String id,String s){
    
     JsonObject jsonskill= new JsonParser().parse(s).getAsJsonObject();
     
     String name = jsonskill.get("skillName").getAsString();
     int rating = jsonskill.get("rating").getAsInt();
     String description = jsonskill.get("description").getAsString();
     
     Skills skill = new Skills(name, rating, description);
     
     SkillsFacade skillsFacade = new SkillsFacade();
     skillsFacade.setSkillsToExperience(id, skill);
     
 }

}
