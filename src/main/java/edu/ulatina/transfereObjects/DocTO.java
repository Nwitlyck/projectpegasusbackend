package edu.ulatina.transfereObjects;

import java.sql.Date;

/**
 * @author PegasusTeam
 */
public class DocTO {

    private int id;
    private int colaboratorId;
    private int type;
    private String name;
    private Date date;
    private int state;

    public DocTO() {

    }

    public DocTO(int id, String name, Date date, int type, int id_colaborator, int state) {
        if (id != 0) {
            this.id = id;
        }
        this.name = name;
        this.date = date;
        this.type = type;
        this.colaboratorId = id_colaborator;
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

    public int getColaboratorId() {
        return colaboratorId;
    }

    public void setColaboratorId(int colaboratorId) {
        this.colaboratorId = colaboratorId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
