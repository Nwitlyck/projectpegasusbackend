package edu.ulatina.serviceTO;

import edu.ulatina.interfaces.ICrud;
import edu.ulatina.transfereObjects.NonWorkingDayTO;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 * @author PegasusTeam
 */
public class ServiceNonWorkingDayTO extends Service implements ICrud<NonWorkingDayTO> {

    @Override
    public void insert(NonWorkingDayTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("INSERT INTO nonworkingdays VALUES (null, ?, ?, ?, ?)");
        ps.setTimestamp(1, objectTO.getInitialDate());
        ps.setTimestamp(2, objectTO.getFinalDate());
        ps.setInt(3, objectTO.getType());
        ps.setInt(4, objectTO.getIdColaborator());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void update(NonWorkingDayTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("UPDATE nonworkingdays SET initialdate = ?, finaldate = ?, type = ?, id_colaborator = ?  WHERE (id = ?)");
        ps.setTimestamp(1, objectTO.getInitialDate());
        ps.setTimestamp(2, objectTO.getFinalDate());
        ps.setInt(3, objectTO.getType());
        ps.setInt(4, objectTO.getIdColaborator());
        ps.setInt(5, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void delete(int id) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("DELETE FROM nonworkingdays WHERE (id = ?)");
        ps.setInt(1, id);
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public List<NonWorkingDayTO> select() throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<NonWorkingDayTO> objectTOList = new ArrayList<NonWorkingDayTO>();

        ps = getConnection().prepareStatement("SELECT id, initialdate, finaldate, type, id_colaborator FROM nonworkingdays");
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            Timestamp initialDate = rs.getTimestamp("initialdate");
            Timestamp finalDate = rs.getTimestamp("finaldate");
            int type = rs.getInt("type");
            int idColaborator = rs.getInt("id_colaborator");

            NonWorkingDayTO objectTO = new NonWorkingDayTO(id, initialDate, finalDate, type, idColaborator);

            objectTOList.add(objectTO);
        }

        close(rs);
        close(ps);
        close(conn);

        return objectTOList;
    }

    @Override
    public NonWorkingDayTO selectByPk(int primaryKey) throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        NonWorkingDayTO objectTO = null;

        ps = getConnection().prepareStatement("SELECT id, initialdate, finaldate, type, id_colaborator FROM nonworkingdays WHERE id = ?");
        ps.setInt(1, primaryKey);
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            Timestamp initialDate = rs.getTimestamp("initialdate");
            Timestamp finalDate = rs.getTimestamp("finaldate");
            int type = rs.getInt("type");
            int idColaborator = rs.getInt("id_colaborator");

            objectTO = new NonWorkingDayTO(id, initialDate, finalDate, type, idColaborator);

        }

        close(rs);
        close(ps);
        close(conn);

        return objectTO;
    }
    
}
