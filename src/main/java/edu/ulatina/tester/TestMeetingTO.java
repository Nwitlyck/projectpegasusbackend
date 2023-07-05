package edu.ulatina.tester;

import edu.ulatina.interfaces.ITester;
import edu.ulatina.transfereObjects.MeetingTO;
import edu.ulatina.serviceTO.ServiceMeetingTO;
import java.util.*;

/**
 * @author PegasusTeam
 */
public class TestMeetingTO implements ITester<MeetingTO> {

    @Override
    public List<MeetingTO> testSelect() {
        
        List<MeetingTO> objectTOList;
        
        try {
            
            objectTOList = new ServiceMeetingTO().select();
            
        } catch (Exception e) {
            e.printStackTrace();
            objectTOList = new ArrayList<MeetingTO>();
        }
        
        return objectTOList;
    }

    @Override
    public MeetingTO testSelectByPk(MeetingTO objectTO) {
        
        try {
            
            return new ServiceMeetingTO().selectByPk(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
            return new MeetingTO();
        }
        
    }

    @Override
    public void testInsert(MeetingTO objectTO) {
        
        try {
            
            new ServiceMeetingTO().insert(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testUpdate(MeetingTO objectTO) {
        
        try {
            
            new ServiceMeetingTO().update(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testDelete(MeetingTO objectTO) {
        
        try {
            
            new ServiceMeetingTO().delete(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
}
