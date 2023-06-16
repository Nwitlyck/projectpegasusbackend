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

        ps = getConnection().prepareStatement("INSERT INTO colaborators VALUES (null, ?, ?, ?, ?)");
        ps.setInt(1, objectTO.getAcceslevel());
        ps.setDate(2, objectTO.getHiredate());
        ps.setDate(3, objectTO.getFiredate());
        ps.setString(4, objectTO.getPassword());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void update(ColaboratorTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("UPDATE colaborators SET accesslevel = ?, hiredate = ?, firedate = ? , password = ? WHERE (id = ?)");
        ps.setInt(1, objectTO.getAcceslevel());
        ps.setDate(2, objectTO.getHiredate());
        ps.setDate(3, objectTO.getFiredate());
        ps.setString(4, objectTO.getPassword());
        ps.setInt(5, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void delete(int id) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("DELETE FROM colaborators WHERE (id = ?)");
        ps.setInt(1, id);
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public List<ColaboratorTO> select() throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ColaboratorTO> objectTOList = new ArrayList<ColaboratorTO>();

        ps = getConnection().prepareStatement("SELECT id, accesslevel, hiredate, firedate, password  FROM colaborators");
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int accesslevel = rs.getInt("accesslevel");
            Date hiredate = rs.getDate("hiredate");
            Date firedate = rs.getDate("firedate");
            String password = rs.getString("password");

            ColaboratorTO objectTO = new ColaboratorTO(id, accesslevel, hiredate, firedate, password);
            
            objectTOList.add(objectTO);
        }

        close(rs);
        close(ps);
        close(conn);

        return objectTOList;
    }

    @Override
    public ColaboratorTO selectByPk(int primaryKey) throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ColaboratorTO objectTO = null;

        ps = getConnection().prepareStatement("SELECT id, accesslevel, hiredate, firedate, password  FROM colaborators WHERE id = ?");
        ps.setInt(1, primaryKey);
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            int accesslevel = rs.getInt("accesslevel");
            Date hiredate = rs.getDate("hiredate");
            Date firedate = rs.getDate("firedate");
            String password = rs.getString("password");

            ColaboratorTO colaborator = new ColaboratorTO(id, accesslevel, hiredate, firedate, password);
            objectTO = colaborator;
        }

        close(rs);
        close(ps);
        close(conn);

        return objectTO;
    }

}
