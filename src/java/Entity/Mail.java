/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author juhlm
 */
public class Mail {
    
    private String subject;
    private String body;
    private String name;
    private String eMail;

    public Mail() {
    }

    public Mail(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public Mail(String subject, String body, String name, String eMail) {
        this.subject = subject;
        this.body = body;
        this.name = name;
        this.eMail = eMail;
    }
    
    
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String mail) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    
    
}
