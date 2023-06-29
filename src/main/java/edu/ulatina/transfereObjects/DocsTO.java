
package edu.ulatina.transfereObjects;

import java.sql.Date;

/**
 *
 * @author isalo
 */
public class DocsTO {
private int id;
    private String name;
    private Date date;
    private int type;
    private int id_colaborator;
    
    public DocsTO(){

}
    public DocsTO(int id, String name, Date date, int type, int id_colaborator) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = type;
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

    public int getId_colaborator() {
        return id_colaborator;
    }

    public void setId_colaborator(int id_colaborator) {
        this.id_colaborator = id_colaborator;
    }
    
    
    
}



