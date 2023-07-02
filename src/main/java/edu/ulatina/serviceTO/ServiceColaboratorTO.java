package edu.ulatina.serviceTO;

import edu.ulatina.interfaces.ICrud;
import edu.ulatina.transfereObjects.ColaboratorTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PegasusTeam
 */
public class ServiceColaboratorTO extends Service implements ICrud<ColaboratorTO> {

    @Override
    public void insert(ColaboratorTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("INSERT INTO colaborators VALUES (null, ?, ?, ?, ?, ?)");
        ps.setInt(1, objectTO.getAcceslevel());
        ps.setDate(2, objectTO.getHireDate());
        ps.setDate(3, objectTO.getFireDate());
        ps.setString(4, objectTO.getPassword());
        ps.setInt(5, objectTO.getState());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void update(ColaboratorTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("UPDATE colaborators SET access_level = ?, hire_date = ?, fire_date = ? , password = ?, state = ? WHERE (id = ?)");
        ps.setInt(1, objectTO.getAcceslevel());
        ps.setDate(2, objectTO.getHireDate());
        ps.setDate(3, objectTO.getFireDate());
        ps.setString(4, objectTO.getPassword());
        ps.setInt(5, objectTO.getState());
        ps.setInt(6, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void delete(ColaboratorTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("DELETE FROM colaborators WHERE (id = ?)");
        ps.setInt(1, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public List<ColaboratorTO> select() throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ColaboratorTO> objectTOList = new ArrayList<ColaboratorTO>();

        ps = getConnection().prepareStatement("SELECT id, access_level, hire_date, fire_date, password, state FROM colaborators WHERE state = 1");
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int accesslevel = rs.getInt("access_level");
            Date hiredate = rs.getDate("hire_date");
            Date firedate = rs.getDate("fire_date");
            String password = rs.getString("password");
            int state = rs.getInt("state");

            ColaboratorTO objectTO = new ColaboratorTO(id, accesslevel, hiredate, firedate, password,state);
            
            objectTOList.add(objectTO);
        }

        close(rs);
        close(ps);
        close(conn);

        return objectTOList;
    }

    @Override
    public ColaboratorTO selectByPk(ColaboratorTO objectTO) throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ColaboratorTO colaboratorTO = null;

        ps = getConnection().prepareStatement("SELECT id, access_level, hire_date, fire_date, password, state FROM colaborators WHERE id = ? AND state = 1");
        ps.setInt(1, objectTO.getId());
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            int accesslevel = rs.getInt("access_level");
            Date hiredate = rs.getDate("hire_date");
            Date firedate = rs.getDate("fire_date");
            String password = rs.getString("password");
            int state = rs.getInt("state");

            colaboratorTO = new ColaboratorTO(id, accesslevel, hiredate, firedate, password, state);
        }

        close(rs);
        close(ps);
        close(conn);

        return colaboratorTO;
    }

}
