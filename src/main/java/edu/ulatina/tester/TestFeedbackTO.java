package edu.ulatina.tester;

import edu.ulatina.interfaces.ITester;
import edu.ulatina.transfereObjects.FeedbackTO;
import edu.ulatina.serviceTO.ServiceFeedbackTO;
import java.util.*;

/**
 * @author PegasusTeam
 */
public class TestFeedbackTO implements ITester<FeedbackTO> {

    @Override
    public List<FeedbackTO> testSelect() {
        
        List<FeedbackTO> objectTOList;
        
        try {
            
            objectTOList = new ServiceFeedbackTO().select();
            
        } catch (Exception e) {
            e.printStackTrace();
            objectTOList = new ArrayList<FeedbackTO>();
        }
        
        return objectTOList;
    }

    @Override
    public FeedbackTO testSelectByPk(FeedbackTO objectTO) {
        
        try {
            
            return new ServiceFeedbackTO().selectByPk(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
            return new FeedbackTO();
        }
        
    }

    @Override
    public void testInsert(FeedbackTO objectTO) {
        
        try {
            
            new ServiceFeedbackTO().insert(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testUpdate(FeedbackTO objectTO) {
        
        try {
            
            new ServiceFeedbackTO().update(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testDelete(FeedbackTO objectTO) {
        
        try {
            
            new ServiceFeedbackTO().delete(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
