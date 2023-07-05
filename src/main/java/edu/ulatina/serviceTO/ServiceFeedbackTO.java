
package edu.ulatina.serviceTO;

import edu.ulatina.interfaces.ICrud;
import edu.ulatina.transfereObjects.FeedbackTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PegasusTeam
 */
public class ServiceFeedbackTO extends Service implements ICrud<FeedbackTO> {

    @Override
    public void insert(FeedbackTO objectTO) throws Exception {
       PreparedStatement ps = null; 
       
       ps = getConnection().prepareStatement("INSERT INTO feedbacks VALUES (null, ?, ?, ?)");
        ps.setInt(1, objectTO.getAuthor());
        ps.setString(2, objectTO.getOpinion());
        ps.setInt(3, objectTO.getState());
        ps.executeUpdate();
        
        close(ps);
        close(conn);
    }

    @Override
    public void update(FeedbackTO objectTO) throws Exception {
        PreparedStatement ps = null;
        
        ps = getConnection().prepareStatement("UPDATE feedbacks SET author = ?, opinion = ?, state= ? WHERE (id = ?)");
        
        ps.setInt(1, objectTO.getAuthor());
        ps.setString(2, objectTO.getOpinion());
        ps.setInt(3, objectTO.getState());
        ps.setInt(4, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void delete(FeedbackTO objectTO) throws Exception {
         PreparedStatement ps = null;
        
        ps = getConnection().prepareStatement("DELETE FROM feedbacks WHERE (id = ?)");
        
        ps.setInt(1, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public List<FeedbackTO> select() throws Exception {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FeedbackTO> objectTOList = new ArrayList<FeedbackTO>();
        
        ps = getConnection().prepareStatement("SELECT id, author, opinion, state FROM feedbacks WHERE state = 1");
        rs = ps.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            int author = rs.getInt("author");
            String opinion = rs.getString("opinion");
            int state = rs.getInt("state");
            
            
            FeedbackTO objectTO = new FeedbackTO(id, author, opinion, state);
            
            objectTOList.add(objectTO);           
        }
        close(rs);
        close(ps);
        close(conn);

        return objectTOList;
    }

    @Override
    public FeedbackTO selectByPk(FeedbackTO objectTO) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        FeedbackTO feedbackTO = null;
    
        ps = getConnection().prepareStatement("SELECT id, author, opinion, state FROM feedbacks WHERE id = ? AND state = 1");
        ps.setInt(1, objectTO.getId());
        rs = ps.executeQuery();
        
        if (rs.next()){
            int id = rs.getInt("id");
            int author = rs.getInt("author");
            String opinion = rs.getString("opinion");
            int state = rs.getInt("state");
            
            feedbackTO = new FeedbackTO(id, author, opinion, state);
                     
        }
        
        close(rs);
        close(ps);
        close(conn);

        return feedbackTO;
    }
    
}
