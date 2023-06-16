package edu.ulatina.tester;

import edu.ulatina.interfaces.ITester;
import edu.ulatina.transfereObjects.DetailTO;
import edu.ulatina.serviceTO.ServicioDetailTO;
import java.util.*;

/**
 * @author PegasusTeam
 */
public class TestDetailTO implements ITester<DetailTO> {

    @Override
    public List<DetailTO> testSelect() {
        
        List<DetailTO> objectTOList;
        
        try {
            
            objectTOList = new ServicioDetailTO().select();
            
        } catch (Exception e) {
            e.printStackTrace();
            objectTOList = new ArrayList<DetailTO>();
        }
        
        return objectTOList;
    }

    @Override
    public DetailTO testSelectByPk(int primaryKey) {
        
        DetailTO objectTO;
        
        try {
            
            objectTO = new ServicioDetailTO().selectByPk(primaryKey);
            
        } catch (Exception e) {
            e.printStackTrace();
            objectTO = new DetailTO();
        }
        
        return objectTO;
    }

    @Override
    public void testInsert(DetailTO objectTO) {
        
        try {
            
            new ServicioDetailTO().insert(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testUpdate(DetailTO objectTO) {
        
        try {
            
            new ServicioDetailTO().update(objectTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testDelete(int id) {
        
        try {
            
            new ServicioDetailTO().delete(id);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
