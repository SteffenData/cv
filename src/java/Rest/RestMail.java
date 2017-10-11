/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Mail;
import Facade.MailFacade;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author juhlm
 */
@Path("sendmail/")
public class RestMail {

    @POST
    @Path("add")
    @Consumes("application/json")
    public void SendmailToApplicant(String mail) throws Exception {

        JsonObject jsonmail = new JsonParser().parse(mail).getAsJsonObject();

        String subject = jsonmail.get("subject").getAsString();
        String body = jsonmail.get("body").getAsString();
        String email = jsonmail.get("email").getAsString();
        String name = jsonmail.get("name").getAsString();

        Mail mymail = new Mail(subject, body +" "+email, name, email);

        MailFacade mailFacade = new MailFacade();
        mailFacade.sendMailToOwner(mymail);

    }

}
