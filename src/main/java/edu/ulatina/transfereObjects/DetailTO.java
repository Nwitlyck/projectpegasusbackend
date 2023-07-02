package edu.ulatina.transfereObjects;

/**
 * @author PegasusTeam
 */
public class DetailTO {

    private int id;
    private int idMaster;
    private String name;
    private String generalCode;

    public DetailTO() {
    }

    public DetailTO(int id, String name, String generalCode, int idMaster) {
        if (id != 0) {
            this.id = id;
        }
        this.name = name;
        this.generalCode = generalCode;
        this.idMaster = idMaster;
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

    public String getGeneralCode() {
        return generalCode;
    }

    public void setGeneralCode(String generalCode) {
        this.generalCode = generalCode;
    }

    public int getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(int idMaster) {
        this.idMaster = idMaster;
    }

}
