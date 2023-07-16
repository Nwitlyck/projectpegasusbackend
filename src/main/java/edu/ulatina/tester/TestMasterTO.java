package edu.ulatina.tester;

import edu.ulatina.interfaces.ITester;
import edu.ulatina.transfereObjects.MasterTO;
import edu.ulatina.serviceTO.ServiceMasterTO;
import java.util.*;

/**
 * @author PegasusTeam
 */
public class TestMasterTO implements ITester<MasterTO> {

    @Override
    public List<MasterTO> testSelect() {
        
        List<MasterTO> objectTOList;
        
        try {
            
            objectTOList = new ServiceMasterTO().select();
            
        } catch (Exception e) {
            e.printStackTrace();
            objectTOList = new ArrayList<MasterTO>();
        }
        
        return objectTOList;
    }

    @Override
    public MasterTO testSelectByPk(MasterTO objectTO) {
        
        try {
            
            return new ServiceMasterTO().selectByPk(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
            return new MasterTO();
        }
    }

    @Override
    public void testInsert(MasterTO objectTO) {
        
        try {
            
            new ServiceMasterTO().insert(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testUpdate(MasterTO objectTO) {
        
        try {
            
            new ServiceMasterTO().update(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testDelete(MasterTO objectTO) {
        
        try {
            
            new ServiceMasterTO().delete(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
