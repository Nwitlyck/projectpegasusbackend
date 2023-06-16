package edu.ulatina.tester;

import edu.ulatina.interfaces.ITester;
import edu.ulatina.transfereObjects.NonWorkingDayTO;
import edu.ulatina.serviceTO.ServiceNonWorkingDayTO;
import java.util.*;

/**
 * @author PegasusTeam
 */
public class TestNonWorkingDayTO implements ITester<NonWorkingDayTO> {

    @Override
    public List<NonWorkingDayTO> testSelect() {

        List<NonWorkingDayTO> objectTOList;

        try {

            objectTOList = new ServiceNonWorkingDayTO().select();

        } catch (Exception e) {
            e.printStackTrace();
            objectTOList = new ArrayList<NonWorkingDayTO>();
        }

        return objectTOList;
    }

    @Override
    public NonWorkingDayTO testSelectByPk(int primaryKey) {

        NonWorkingDayTO objectTO;

        try {

            objectTO = new ServiceNonWorkingDayTO().selectByPk(primaryKey);

        } catch (Exception e) {
            e.printStackTrace();
            objectTO = new NonWorkingDayTO();
        }

        return objectTO;
    }

    @Override
    public void testInsert(NonWorkingDayTO objectTO) {

        try {

            new ServiceNonWorkingDayTO().insert(objectTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testUpdate(NonWorkingDayTO objectTO) {

        try {

            new ServiceNonWorkingDayTO().update(objectTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testDelete(int id) {

        try {

            new ServiceNonWorkingDayTO().delete(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
