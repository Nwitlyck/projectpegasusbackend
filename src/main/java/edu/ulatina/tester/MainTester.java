package edu.ulatina.tester;

import edu.ulatina.transfereObjects.ColaboratorTO;

/**
 * @author PegasusTeam
 */
public class MainTester{

    public static void main(String[] args) {
        
        TestColaboradorTO tCTO = new TestColaboradorTO();
        
        //tCTO.testInsert(new ColaboratorTO(0, 0, new java.sql.Date(System.currentTimeMillis()), "asdasd")); // insert test
        //tCTO.testUpdate(new ColaboratorTO(1, 0, new java.sql.Date(System.currentTimeMillis()), null, "felipe")); // update test
        //tCTO.testDelete(1); // delete test
        
        for(ColaboratorTO colaboratorTO : tCTO.testSelect())
        {
            System.err.println(
                    "Id: " + colaboratorTO.getId() + 
                    "| Access Level: " + colaboratorTO.getAcceslevel() + 
                    "| Hire Date: " + colaboratorTO.getHiredate() +
                    "| Fire Date: " + colaboratorTO.getFiredate() + 
                    "| Password: " + colaboratorTO.getPassword()
            );
        }
    }

}
