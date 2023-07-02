package edu.ulatina.transfereObjects;

import java.sql.Date;

/**
 * @author PegasusTeam
 */
public class MeetingTO {

    private int id;
    private Date date;
    private int type;
    private int state;

    public MeetingTO(int id, Date date, int type, int state) {
        if (id != 0) {
            this.id = id;
        }
        this.date = date;
        this.type = type;
        this.state = state;
    }

    public MeetingTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
}
