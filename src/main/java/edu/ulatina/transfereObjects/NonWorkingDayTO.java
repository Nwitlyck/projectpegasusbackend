package edu.ulatina.transfereObjects;

import java.sql.Date;

/**
 * @author PegasusTeam
 */
public class NonWorkingDayTO {

    private int id;
    private int type;
    private int idColaborator;
    private Date initialDate;
    private Date finalDate;
    private int state;
    private int review;

    public NonWorkingDayTO() {
    }

    public NonWorkingDayTO(int id, int type, int idColaborator, Date initialDate, Date finalDate, int state, int review) {
        if (id != 0) {
            this.id = id;
        }
        this.type = type;
        this.idColaborator = idColaborator;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.state = state;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
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

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }
    

}
