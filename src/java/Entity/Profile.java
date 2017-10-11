/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author juhlm
 */
@Entity
@XmlRootElement
public class Profile implements Serializable {

    
    @Id @GeneratedValue(strategy= GenerationType.TABLE)
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private List<String> desriptionslines; 
    private String url;
    @OneToOne(mappedBy = "profile")
    private Resume resume;

    public Profile() {
    }

    public Profile(String firstName, String lastName, int age, List<String> desriptionslines) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.desriptionslines = desriptionslines;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public List<String> getDesriptionslines() {
        return desriptionslines;
    }

    public void setDesriptionslines(List<String> desriptionslines) {
        this.desriptionslines = desriptionslines;
    }
   
}
