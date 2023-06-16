package edu.ulatina.tester;

import edu.ulatina.interfaces.ITester;
import edu.ulatina.transfereObjects.ColaboratorTO;
import edu.ulatina.serviceTO.ServiceColaboratorTO;
import java.util.*;

/**
 * @author PegasusTeam
 */
public class TestColaboratorTO implements ITester<ColaboratorTO>{

    @Override
    public List<ColaboratorTO> testSelect() {
        
        List<ColaboratorTO> objectTOList;
        
        try {
            
            objectTOList = new ServiceColaboratorTO().select();
            
        } catch (Exception e) {
            e.printStackTrace();
            objectTOList = new ArrayList<ColaboratorTO>();
        }
        
        return objectTOList;
    }

    @Override
    public ColaboratorTO testSelectByPk(int primatyKey) {
        
        ColaboratorTO objectTO;
        
        try {
            
            objectTO = new ServiceColaboratorTO().selectByPk(primatyKey);
            
        } catch (Exception e) {
            e.printStackTrace();
            objectTO = new ColaboratorTO();
        }
        
        return objectTO;
    }

    @Override
    public void testInsert(ColaboratorTO objectTO) {
        
        try {
            
            new ServiceColaboratorTO().insert(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testUpdate(ColaboratorTO objectTO) {
        
        try {
            
            new ServiceColaboratorTO().update(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testDelete(int id) {
        
        try {
            
            new ServiceColaboratorTO().delete(id);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
