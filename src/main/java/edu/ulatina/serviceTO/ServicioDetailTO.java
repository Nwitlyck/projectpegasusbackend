package edu.ulatina.serviceTO;

import edu.ulatina.interfaces.ICrud;
import edu.ulatina.transfereObjects.DetailTO;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Nwitlyck
 */
public class ServicioDetailTO extends Service implements ICrud<DetailTO> {

    @Override
    public void insert(DetailTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("INSERT INTO details VALUES (null, ?, ?, ?)");
        ps.setString(1, objectTO.getName());
        ps.setString(2, objectTO.getGeneralCode());
        ps.setInt(3, objectTO.getIdMaster());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void update(DetailTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("UPDATE details SET name = ?, generalcode = ?, id_master = ? WHERE (id = ?)");
        ps.setString(1, objectTO.getName());
        ps.setString(2, objectTO.getGeneralCode());
        ps.setInt(3, objectTO.getIdMaster());
        ps.setInt(4, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void delete(int id) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("DELETE FROM details WHERE (id = ?)");
        ps.setInt(1, id);
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public List<DetailTO> select() throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DetailTO> objectTOList = new ArrayList<DetailTO>();

        ps = getConnection().prepareStatement("SELECT id, name, generalcode, id_master FROM details");
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String generalcode = rs.getString("generalcode");
            int idMaster = rs.getInt("id_master");

            DetailTO objectTO = new DetailTO(id, name, generalcode, idMaster);

            objectTOList.add(objectTO);
        }

        close(rs);
        close(ps);
        close(conn);

        return objectTOList;
    }

    @Override
    public DetailTO selectByPk(int primaryKey) throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        DetailTO objectTO;

        ps = getConnection().prepareStatement("SELECT id, name, generalcode, id_master FROM details WHERE id = ?");
        ps.setInt(1, primaryKey);
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String generalcode = rs.getString("generalcode");
            int idMaster = rs.getInt("id_master");


            objectTO = new DetailTO(id, name, generalcode, idMaster);

        } else {
            objectTO = new DetailTO();
        }

        close(rs);
        close(ps);
        close(conn);

        return objectTO;
    }

}
