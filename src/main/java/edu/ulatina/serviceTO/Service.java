package edu.ulatina.serviceTO;

import java.sql.*;

/**
 * @author PegasusTeam
 */
public abstract class Service {

    protected Connection conn = null;

    public Service() {
    }

    protected Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectpegasus?serverTimezone=UTC", "root", "1234");
        //make sure u have the data base up and change ur user and password

        return conn;
    }

    protected void close(Connection toClose) throws Exception {
        if (toClose != null && !toClose.isClosed()) {
            toClose.close();
            toClose = null;
        }
    }

    protected void close(PreparedStatement toClose) throws Exception {
        if (toClose != null && !toClose.isClosed()) {
            toClose.close();
            toClose = null;
        }
    }

    protected void close(ResultSet toClose) throws Exception {
        if (toClose != null && !toClose.isClosed()) {
            toClose.close();
            toClose = null;
        }
    }

}
