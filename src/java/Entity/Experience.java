/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juhlm
 */
@Entity 
public class Experience implements Serializable {


    
    @Id @GeneratedValue(strategy= GenerationType.TABLE)
    private String id;
    private String name;
    private int expericeneCode;
    private int ageFrom;
    private int ageTo;
    private List<String> description = new ArrayList<String>();
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Resume resume;
    @OneToMany(mappedBy = "experience", cascade=CascadeType.PERSIST)
    private List<Skills> skills = new ArrayList<Skills>();
    
    public Experience() {
    }

    public Experience(String name, int expericeneCode, int ageFrom, int ageTo, List<String> description) {
        this.name = name;
        this.expericeneCode = expericeneCode;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.description = description;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpericeneCode() {
        return expericeneCode;
    }

    public void setExpericeneCode(int expericeneCode) {
        this.expericeneCode = expericeneCode;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

 
    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public void addSkills(Skills skill){
            skills.add(skill);
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
    
    public void addDescription(String descriptionToAdd) {
        description.add(descriptionToAdd);
    }
    
     public List<String> getExpDescription() {
        return description;
    }

  
}
