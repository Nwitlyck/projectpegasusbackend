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

        ps = getConnection().prepareStatement("INSERT INTO nonworkingdays VALUES (null, ?, ?, ?, ?, ?)");
        ps.setInt(1, objectTO.getIdColaborator());
        ps.setInt(2, objectTO.getType());
        ps.setTimestamp(3, objectTO.getInitialDate());
        ps.setTimestamp(4, objectTO.getFinalDate());
        ps.setInt(5, objectTO.getState());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void update(NonWorkingDayTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("UPDATE nonworkingdays SET calaborator_id = ?, type = ?, initial_date = ?, final_date = ?, state = ?  WHERE (id = ?)");
        ps.setInt(1, objectTO.getIdColaborator());
        ps.setInt(2, objectTO.getType());
        ps.setTimestamp(3, objectTO.getInitialDate());
        ps.setTimestamp(4, objectTO.getFinalDate());
        ps.setInt(5, objectTO.getState());
        ps.setInt(6, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void delete(NonWorkingDayTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("DELETE FROM nonworkingdays WHERE (id = ?)");
        ps.setInt(1, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public List<NonWorkingDayTO> select() throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<NonWorkingDayTO> objectTOList = new ArrayList<NonWorkingDayTO>();

        ps = getConnection().prepareStatement("SELECT id, calaborator_id, type, initial_date, final_date, state FROM nonworkingdays WHERE state = 1");
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int idColaborator = rs.getInt("calaborator_id");
            int type = rs.getInt("type");
            Timestamp initialDate = rs.getTimestamp("initial_date");
            Timestamp finalDate = rs.getTimestamp("final_date");
            int state = rs.getInt("state");

            NonWorkingDayTO objectTO = new NonWorkingDayTO(id, type, idColaborator, initialDate, finalDate, state);

            objectTOList.add(objectTO);
        }

        close(rs);
        close(ps);
        close(conn);

        return objectTOList;
    }

    @Override
    public NonWorkingDayTO selectByPk(NonWorkingDayTO objectTO) throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        NonWorkingDayTO nonWorkingDayTO = null;

        ps = getConnection().prepareStatement("SELECT id, calaborator_id, type, initial_date, final_date, state FROM nonworkingdays WHERE id = ? AND state = 1");
        ps.setInt(1, objectTO.getId());
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            int idColaborator = rs.getInt("calaborator_id");
            int type = rs.getInt("type");
            Timestamp initialDate = rs.getTimestamp("initial_date");
            Timestamp finalDate = rs.getTimestamp("final_date");
            int state = rs.getInt("state");

            nonWorkingDayTO = new NonWorkingDayTO(id, type, idColaborator, initialDate, finalDate, state);

        }

        close(rs);
        close(ps);
        close(conn);

        return nonWorkingDayTO;
    }
    
}
