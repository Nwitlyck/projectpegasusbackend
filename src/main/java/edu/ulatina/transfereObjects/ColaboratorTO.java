package edu.ulatina.transfereObjects;

import java.sql.Date;

/**
 * @author PegasusTeam
 */
public class ColaboratorTO {

    private int id;
    private int acceslevel;
    private Date hiredate;
    private Date firedate;
    private String password;
    private int state;

    public ColaboratorTO() {
    }
    
    public ColaboratorTO(int id, int acceslevel, Date hiredate, Date firedate, String password, int state) {

        if (id != 0) {
            this.id = id;
        }
        this.acceslevel = acceslevel;
        this.hiredate = hiredate;
        this.firedate = firedate;
        this.password = password;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcceslevel() {
        return acceslevel;
    }

    public void setAcceslevel(int acceslevel) {
        this.acceslevel = acceslevel;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getFiredate() {
        return firedate;
    }

    public void setFiredate(Date firedate) {
        this.firedate = firedate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
