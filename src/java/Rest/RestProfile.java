/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Profile;
import Facade.ProfileFacade;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Arrays;
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
@Path("profile/")
public class RestProfile {

  
 @POST
 @Path("add")
 @Consumes("application/json")
 public void saveProfile (String profile){
 
     JsonObject jsonProfile = new JsonParser().parse(profile).getAsJsonObject();
     JsonArray jsonArraydescriptionslines = jsonProfile.getAsJsonArray("desriptionslines");
     String firstname = jsonProfile.get("firstName").getAsString();
     String lastName = jsonProfile.get("lastName").getAsString();
     int age = jsonProfile.get("age").getAsInt();
     
     List<String> desriptionslines = new ArrayList();

     for (JsonElement desriptionsline : jsonArraydescriptionslines) {
         JsonObject ob = new JsonObject();
         ob = desriptionsline.getAsJsonObject();
         String desriptionslinel = ob.get("String").getAsString();
         desriptionslines.add(desriptionslinel);
     }

     Profile profileToSave = new Profile(firstname,lastName,age,desriptionslines);
     ProfileFacade profileFacade = new ProfileFacade();
     profileFacade.createNewProfile(profileToSave);
     
}
 
@GET
@Path("{id}")
@Consumes("application/json")
public Response getProfile(@PathParam("id") String id){

       JsonObject jsonPerson = new JsonObject();
       JsonArray jArray = new JsonArray();
      
     Profile profile = new Profile();
     ProfileFacade pf = new ProfileFacade();
     profile = pf.getProfile(id);
     List<String> stringList = profile.getDesriptionslines();
     
     
     jsonPerson.addProperty("firstName", profile.getFirstName());
     jsonPerson.addProperty("lastName", profile.getLastName());
     jsonPerson.addProperty("age", profile.getAge());
     
     for (String string : stringList) {
        
         JsonObject ob = new JsonObject();
         ob.addProperty("descriptionline", string);
         jArray.add(ob);
    }
     jsonPerson.add("desriptionslines", jArray);
     
     
    return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(jsonPerson.toString()).build();
} 
}
