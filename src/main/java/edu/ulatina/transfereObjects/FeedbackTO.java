
package edu.ulatina.transfereObjects;

/**
 * @author PegasusTeam
 */
public class FeedbackTO {
    private int id;
    private int author;
    private String opinion;
    private int state;

    public FeedbackTO() {
    }

    public FeedbackTO(int id, int author, String opinion, int state) {
        if (id != 0) {
            this.id = id;
        }
        this.author = author;
        this.opinion = opinion;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
    
}
