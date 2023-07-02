package edu.ulatina.transfereObjects;

import java.sql.Date;

/**
 * @author PegasusTeam
 */
public class ProjectsTO {

    private int id;
    private String name;
    private Date initialdate;
    private Date finaldate;
    private int state;

    public ProjectsTO() {
    }

    public ProjectsTO(int id, String name, Date initialdate, Date finaldate, int state) {
        if (id != 0) {
            this.id = id;
        }
        this.name = name;
        this.initialdate = initialdate;
        this.finaldate = finaldate;
        this.state = state;
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

    public Date getInitialdate() {
        return initialdate;
    }

    public void setInitialdate(Date initialdate) {
        this.initialdate = initialdate;
    }

    public Date getFinaldate() {
        return finaldate;
    }

    public void setFinaldate(Date finaldate) {
        this.finaldate = finaldate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
}
