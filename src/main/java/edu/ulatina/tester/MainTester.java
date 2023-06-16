package edu.ulatina.tester;

import edu.ulatina.transfereObjects.*;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author PegasusTeam
 */
public class MainTester{

    public static void main(String[] args) {
        //testColaboratorTO();
        //testMasterTO();
        //testDetailTO();
        testNonWorkingDayTO();
    }
    
    public static void testColaboratorTO()
    {
        
        TestColaboratorTO test = new TestColaboratorTO();
        
        //test.testInsert(new ColaboratorTO(0, 0, new java.sql.Date(System.currentTimeMillis()), null, "Felipe")); // insert test
        //test.testUpdate(new ColaboratorTO(1, 0, new java.sql.Date(System.currentTimeMillis()), null, "felipe")); // update test
        //test.testDelete(1); // delete test
        
        for(ColaboratorTO objectTO : test.testSelect())
        {
            System.out.println("Id: " + objectTO.getId() + 
                    "| Access Level: " + objectTO.getAcceslevel() + 
                    "| Hire Date: " + objectTO.getHiredate() +
                    "| Fire Date: " + objectTO.getFiredate() + 
                    "| Password: " + objectTO.getPassword()
            );
        }
    }
    
    public static void testMasterTO()
    {
        
        TestMasterTO test = new TestMasterTO();
        
        //test.testInsert(new MasterTO(0, "Animals", "Ani")); // insert test
        //test.testUpdate(new MasterTO(1, "Animals", "An")); // update test
        //test.testDelete(1); // delete test
        
        for(MasterTO objectTO : test.testSelect())
        {
            System.out.println("Id: " + objectTO.getId() + 
                    "| Name: " + objectTO.getName()+ 
                    "| General Code: " + objectTO.getGeneralCode()
            );
        }
    }
    
    
    
    public static void testDetailTO()
    {
        
        TestDetailTO test = new TestDetailTO();
        
        //test.testInsert(new DetailTO(0, "Cat", "Cat", 3)); // insert test
        //test.testUpdate(new DetailTO(1, "Dogs", "Dog", 3)); // update test
        //test.testDelete(1); // delete test
        
        for(DetailTO objectTO : test.testSelect())
        {
            System.out.println("Id: " + objectTO.getId() + 
                    "| Name: " + objectTO.getName()+ 
                    "| General Code: " + objectTO.getGeneralCode()+ 
                    "| Id Master: " + objectTO.getIdMaster()
            );
        }
    }
    
    public static void testNonWorkingDayTO()
    {
        
        TestNonWorkingDayTO test = new TestNonWorkingDayTO();
        
        //test.testInsert(new NonWorkingDayTO(0, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 2, 2)); // insert test
        //test.testUpdate(new NonWorkingDayTO(1, test.testSelectByPk(1).getInitialDate(), new Timestamp(System.currentTimeMillis()), 2, 2)); // update test
        //test.testDelete(1); // delete test
        
        for(NonWorkingDayTO objectTO : test.testSelect())
        {
            System.out.println("Id: " + objectTO.getId() + 
                    "| Initial Date: " + objectTO.getInitialDate()+ 
                    "| Final Date: " + objectTO.getFinalDate()+ 
                    "| Type: " + objectTO.getType()+ 
                    "| Id colaborador: " + objectTO.getIdColaborator()
            );
        }
    }

}
