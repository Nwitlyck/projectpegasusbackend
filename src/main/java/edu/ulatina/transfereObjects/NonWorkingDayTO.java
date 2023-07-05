package edu.ulatina.transfereObjects;

import java.sql.Timestamp;

/**
 * @author PegasusTeam
 */
public class NonWorkingDayTO {

    private int id;
    private int type;
    private int idColaborator;
    private Timestamp initialDate;
    private Timestamp finalDate;
    private int state;

    public NonWorkingDayTO() {
    }

    public NonWorkingDayTO(int id, int type, int idColaborator, Timestamp initialDate, Timestamp finalDate, int state) {
        if (id != 0) {
            this.id = id;
        }
        this.type = type;
        this.idColaborator = idColaborator;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Timestamp initialDate) {
        this.initialDate = initialDate;
    }

    public Timestamp getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Timestamp finalDate) {
        this.finalDate = finalDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIdColaborator() {
        return idColaborator;
    }

    public void setIdColaborator(int idColaborator) {
        this.idColaborator = idColaborator;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
