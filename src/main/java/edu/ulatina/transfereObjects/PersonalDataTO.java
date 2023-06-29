
package edu.ulatina.transfereObjects;

import java.sql.Date;

/**
 *
 * @author isalo
 */
public class PersonalDataTO {
    
    private int id;
    private String name;
    private Date birthdate;
    private int emergencycontact;
    private int id_colaborator;
    
     public PersonalDataTO() {
    }

    public PersonalDataTO(int id, String name, Date birthdate, int emergencycontact, int id_colaborator) {
        
        if (id != 0) 
            this.id = id;
            
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.emergencycontact = emergencycontact;
        this.id_colaborator = id_colaborator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getEmergencycontact() {
        return emergencycontact;
    }

    public void setEmergencycontact(int emergencycontact) {
        this.emergencycontact = emergencycontact;
    }

    public int getId_colaborator() {
        return id_colaborator;
    }

    public void setId_colaborator(int id_colaborator) {
        this.id_colaborator = id_colaborator;
    }
    
    
}

