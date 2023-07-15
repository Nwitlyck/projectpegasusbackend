
package edu.ulatina.serviceTO;

import edu.ulatina.interfaces.ICrud;
import edu.ulatina.transfereObjects.MeetingTO;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ServiceMeetingTO extends Service implements ICrud <MeetingTO> {

    @Override
    public void insert(MeetingTO objectTO) throws Exception {
        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("INSERT INTO meetings VALUES (null, ?, ?, ?)");
        ps.setDate(1, objectTO.getDate());
        ps.setInt(2, objectTO.getType());
        ps.setInt(3, objectTO.getState());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void update(MeetingTO objectTO) throws Exception {
        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("UPDATE meetings SET date = ?, type = ?, state = ?  WHERE (id = ?)");
        ps.setDate(1, objectTO.getDate());
        ps.setInt(2, objectTO.getType());
        ps.setInt(3, objectTO.getState());
        ps.setInt(4, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void delete(MeetingTO objectTO) throws Exception {
        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("DELETE FROM meetings WHERE (id = ?)");
        ps.setInt(1, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public List<MeetingTO> select() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MeetingTO> objectTOList = new ArrayList<MeetingTO>();

        ps = getConnection().prepareStatement("SELECT id, date, type, state FROM meetings WHERE state = 1");
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            Date date = rs.getDate("date");
            int type = rs.getInt("type");
            int state = rs.getInt("state");

            MeetingTO objectTO = new MeetingTO(id, date, type, state);
            
            objectTOList.add(objectTO);
        }

        close(rs);
        close(ps);
        close(conn);

        return objectTOList;
    }

    @Override
    public MeetingTO selectByPk(MeetingTO objectTO) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        MeetingTO meetingTO = null;

        ps = getConnection().prepareStatement("SELECT id, date, type, state FROM meetings WHERE id = ? AND state = 1");
        ps.setInt(1, objectTO.getId());
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            Date date = rs.getDate("date");
            int type = rs.getInt("type");
            int state = rs.getInt("state");

            meetingTO = new MeetingTO(id, date, type, state);
        }

        close(rs);
        close(ps);
        close(conn);

        return meetingTO;
    }
    
}
