/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.sun.javafx.applet.ExperimentalExtensions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author juhlm
 */
@Entity
@XmlRootElement
public class Resume implements Serializable {

    
    
    @Id @GeneratedValue(strategy= GenerationType.TABLE)
    private String id;
    private String resumeName;
    @OneToOne()
    private Profile profile;
    
    @OneToMany(mappedBy = "resume", cascade=CascadeType.PERSIST)
    private List<Experience> experience = new ArrayList<Experience>();

    public Resume() {
    }

    public Resume(String resumeName) {
        this.resumeName = resumeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    public void addExperience(Experience e){
            experience.add(e);
    }

  
    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }
    
    
}
