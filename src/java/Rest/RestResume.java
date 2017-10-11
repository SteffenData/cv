/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Experience;
import Entity.Resume;
import Entity.Skills;
import Facade.ExperienceFacade;
import Facade.ResumeFacade;
import Facade.SkillsFacade;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
@Path("resume/")
public class RestResume {

    @GET
    @Path("{id}")
    @Consumes("application/json")
    public Response getResumeWithExperienceAndSkills(@PathParam("id") String id) {

        Resume resume;
        List<Experience> experience;

        List<String> description = new ArrayList<String>();
        
        JsonObject jsonresume = new JsonObject();
        JsonArray jsonexperiencearray = new JsonArray();

        ResumeFacade resumeFacade = new ResumeFacade();
        resume = resumeFacade.getResumeForProfile(id);

        jsonresume.addProperty("resumeName", resume.getResumeName());

        ExperienceFacade experienceFacade = new ExperienceFacade();
        experience = experienceFacade.getAllExpericensFromResume(resume.getId());

        SkillsFacade skillsFacade = new SkillsFacade();

        for (Experience listexp : experience) {

            JsonObject jsonexp = new JsonObject();

            jsonexp.addProperty("name", listexp.getName());
            jsonexp.addProperty("experienceCode", listexp.getExpericeneCode());
            jsonexp.addProperty("ageFrom", listexp.getAgeFrom());
            jsonexp.addProperty("ageTo", listexp.getAgeTo());

            description = listexp.getExpDescription();
            JsonArray jsondescriptionarray = new JsonArray();
            
            for (String descriptionObject : description) {

                JsonObject jsonDescription = new JsonObject();
                jsonDescription.addProperty("description", descriptionObject);

                jsondescriptionarray.add(jsonDescription);
                jsonexp.add("description", jsondescriptionarray);
            }
            

            List<Skills> skills;
            skills = skillsFacade.getAllSkillsFromOneExpericence(listexp.getId());
            JsonArray jsonskillarray = new JsonArray();
            for (Skills myskills : skills) {

                JsonObject jsonskills = new JsonObject();

                jsonskills.addProperty("skillName", myskills.getSkillName());
                jsonskills.addProperty("rating", myskills.getRating());
                jsonskills.addProperty("description", myskills.getDescription());

                jsonskillarray.add(jsonskills);
                jsonexp.add("skills", jsonskillarray);
            }
            jsonexperiencearray.add(jsonexp);

            jsonresume.add("experience", jsonexperiencearray);
        }

        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "http://localhost:63342").entity(jsonresume.toString()).build();
    }

    @POST
    @Path("add/{id}")
    @Consumes("application/json")
    public void insertResumeWithProfileId(@PathParam("id") String id, String resume) {

        JsonObject jsonResume = new JsonParser().parse(resume).getAsJsonObject();
        String resumeName = jsonResume.get("resumeName").getAsString();

        Resume r = new Resume(resumeName);

        ResumeFacade resumeFacade = new ResumeFacade();
        resumeFacade.createResumeForProfile(id, r);

    }
}
