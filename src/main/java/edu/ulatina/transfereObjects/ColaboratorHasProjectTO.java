package edu.ulatina.transfereObjects;

import java.sql.Date;

/**
 * @author PegasusTeam
 */
public class ColaboratorHasProjectTO {

    private int idColaborator;
    private int idProject;
    private int hours;
    private Date initialDate;
    private Date finalDate;
    private int state;

    public ColaboratorHasProjectTO() {
    }

    public ColaboratorHasProjectTO(int idColab, int idProject, int hours, Date initialDate, Date finalDate, int state) {
        if (idColab != 0) {
            this.idColaborator = idColab;
        }
        if (idProject != 0) {
            this.idProject = idProject;
        }
        this.hours = hours;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.state = state;
    }

    public int getIdColaborator() {
        return idColaborator;
    }

    public void setIdColaborator(int idColaborator) {
        this.idColaborator = idColaborator;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
}
