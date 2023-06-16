package edu.ulatina.serviceTO;

import edu.ulatina.interfaces.ICrud;
import edu.ulatina.transfereObjects.MasterTO;
import java.sql.*;
import java.util.*;

/**
 * @author PegasusTeam
 */
public class ServiceMasterTO extends Service implements ICrud<MasterTO> {

    @Override
    public void insert(MasterTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("INSERT INTO masters VALUES (null, ?, ?)");
        ps.setString(1, objectTO.getName());
        ps.setString(2, objectTO.getGeneralCode());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void update(MasterTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("UPDATE masters SET name = ?, generalcode = ? WHERE (id = ?)");
        ps.setString(1, objectTO.getName());
        ps.setString(2, objectTO.getGeneralCode());
        ps.setInt(3, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void delete(int id) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("DELETE FROM masters WHERE (id = ?)");
        ps.setInt(1, id);
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public List<MasterTO> select() throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MasterTO> objectTOList = new ArrayList<MasterTO>();

        ps = getConnection().prepareStatement("SELECT id, name, generalcode FROM masters");
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String generalcode = rs.getString("generalcode");

            MasterTO objectTO = new MasterTO(id, name, generalcode);

            objectTOList.add(objectTO);
        }

        close(rs);
        close(ps);
        close(conn);

        return objectTOList;
    }

    @Override
    public MasterTO selectByPk(int primaryKey) throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        MasterTO objectTO;

        ps = getConnection().prepareStatement("SELECT id, name, generalcode FROM masters WHERE id = ?");
        ps.setInt(1, primaryKey);
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String generalcode = rs.getString("generalcode");

            objectTO = new MasterTO(id, name, generalcode);

        } else {
            objectTO = new MasterTO();
        }

        close(rs);
        close(ps);
        close(conn);

        return objectTO;
    }

}
