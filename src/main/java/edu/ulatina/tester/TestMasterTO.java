/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ulatina.tester;

import edu.ulatina.interfaces.ITester;
import edu.ulatina.transfereObjects.MasterTO;
import edu.ulatina.serviceTO.ServiceMasterTO;
import java.util.*;

/**
 *
 * @author Nwitlyck
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
    public MasterTO testSelectByPk(int primaryKey) {
        
        MasterTO objectTO;
        
        try {
            
            objectTO = new ServiceMasterTO().selectByPk(primaryKey);
            
        } catch (Exception e) {
            e.printStackTrace();
            objectTO = new MasterTO();
        }
        
        return objectTO;
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
    public void testDelete(int id) {
        
        try {
            
            new ServiceMasterTO().delete(id);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
