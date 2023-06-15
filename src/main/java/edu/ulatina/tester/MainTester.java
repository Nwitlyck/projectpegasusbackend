package edu.ulatina.tester;

import edu.ulatina.serviceTO.*;

/**
 * @author PegasusTeam
 */
public class MainTester {

    public static void main(String[] args) {

        Service s = new Service();
        try {
            
            s.close(s.getConnection());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
