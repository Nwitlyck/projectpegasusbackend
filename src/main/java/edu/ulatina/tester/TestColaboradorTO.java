package edu.ulatina.tester;

import edu.ulatina.transfereObjects.ColaboratorTO;
import edu.ulatina.serviceTO.ServiceColaboradorTO;
import java.util.*;

/**
 * @author PegasusTeam
 */
public class TestColaboradorTO implements ITester<ColaboratorTO>{

    @Override
    public List<ColaboratorTO> testSelect() {
        
        List<ColaboratorTO> colaboratorTOListSelected;
        
        try {
            
            colaboratorTOListSelected = new ServiceColaboradorTO().select();
            
        } catch (Exception e) {
            e.printStackTrace();
            colaboratorTOListSelected = new ArrayList<ColaboratorTO>();
        }
        
        return colaboratorTOListSelected;
    }

    @Override
    public ColaboratorTO testSelectByPk(int primatyKey) {
        
        ColaboratorTO colaboratorTOSelected;
        
        try {
            
            colaboratorTOSelected = new ServiceColaboradorTO().selectByPk(primatyKey);
            
        } catch (Exception e) {
            e.printStackTrace();
            colaboratorTOSelected = new ColaboratorTO();
        }
        
        return colaboratorTOSelected;
    }

    @Override
    public void testInsert(ColaboratorTO colaboratorTO) {
        
        try {
            
            new ServiceColaboradorTO().insert(colaboratorTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testUpdate(ColaboratorTO colaboratorTO) {
        
        try {
            
            new ServiceColaboradorTO().update(colaboratorTO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testDelete(int id) {
        
        try {
            
            new ServiceColaboradorTO().delete(id);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
