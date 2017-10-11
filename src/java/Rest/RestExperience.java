/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Experience;
import Facade.ExperienceFacade;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.json.JSONArray;

/**
 *
 * @author juhlm
 */
@Path("experience/")
public class RestExperience {
    
 @POST
 @Path("add/{id}")
 @Consumes("application/json")
 public void insertExperienceToResume(@PathParam("id") String id,String e){

     JsonObject jsonExperience = new JsonParser().parse(e).getAsJsonObject();
     JsonArray jsonArray = jsonExperience.getAsJsonArray("description");
     List<String> descriptionList = new ArrayList<String>();
 
     String name = jsonExperience.get("name").getAsString();
     int expericeneCode = jsonExperience.get("expericeneCode").getAsInt();
     int ageto = jsonExperience.get("ageTo").getAsInt();
     int agefrom = jsonExperience.get("ageFrom").getAsInt();

 
     for(JsonElement jsonDescription : jsonArray){
         JsonObject jsonDescriptionObject = new JsonObject();
         jsonDescriptionObject = jsonDescription.getAsJsonObject();
         String description = jsonDescriptionObject.get("String").getAsString();
         descriptionList.add(description);
     }
     
     Experience expereince = new Experience(name, expericeneCode, agefrom, ageto, descriptionList);
     
     ExperienceFacade experienceFacade = new ExperienceFacade();
     experienceFacade.setExperienceForResume(id, expereince);
     
 }
 
 @GET
 @Path("id")
 @Consumes("application/json")
 public Response getExperienceFromResumeId(@PathParam("id") String id){
 
     List<Experience> experienceList = new ArrayList<Experience>();
     List<String> description = new ArrayList<String>();
     JsonArray jsonExperienceArray = new JsonArray();;
     JsonArray jsondescriptionarray = new JsonArray();
     ExperienceFacade ef = new ExperienceFacade();
     ef.getAllExpericensFromResume(id);
     
     for (Experience experience : experienceList) {
     JsonObject jsonExperience = new JsonObject();
     
     jsonExperience.addProperty("name", experience.getName());
     jsonExperience.addProperty("ageFrom", experience.getAgeFrom());
     jsonExperience.addProperty("ageTo", experience.getAgeTo());
     
     description = experience.getExpDescription();

     for(String descriptionObject : description){
     
         JsonObject jsonDescription = new JsonObject();
         jsonDescription.addProperty("description", descriptionObject);
         
         jsondescriptionarray.add(jsonDescription);
     }
     

     jsonExperienceArray.add(jsondescriptionarray);
     }
     
     return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(jsonExperienceArray.toString()).build();
 }
 
}
