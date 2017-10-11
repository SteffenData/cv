/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Mail;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author juhlm
 */
public class MailFacade {
    
    public void sendMailToOwner(Mail mail) throws Exception{
        

        final String username = "------------";
	final String password = "--------------";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

                Authenticator auth = new Authenticator() {
                    
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(username, password);
                    }                  
        };
                Session session = Session.getDefaultInstance(props,auth);
                
                sendMail(session, username, mail.getSubject(), mail.getBody());	
                sendMail(session, mail.geteMail(), "Tak for din kontakt", "Hej "+mail.getName() + ". Mange tak for din besked, jeg vil vende tilbage hurtigst muligt. \r\n\nMed venlig hilsen Steffen Juhl Madsen");
}

public void sendMail(Session session, String toEmail, String subject, String body){

    try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("no_reply@journaldev.com", "Steffen Juhl Madsen"));

	      msg.setReplyTo(InternetAddress.parse("juhlmadsen1982@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");
              
              msg.setSubject(subject,subject);

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
              Transport.send(msg);  

	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}


}

   


