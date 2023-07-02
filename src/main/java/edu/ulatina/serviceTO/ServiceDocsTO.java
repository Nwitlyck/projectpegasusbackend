package edu.ulatina.serviceTO;

import edu.ulatina.interfaces.ICrud;
import edu.ulatina.transfereObjects.DocTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PegasusTeam
 */
public class ServiceDocsTO extends Service implements ICrud<DocTO> {

    @Override
    public void insert(DocTO objectTO) throws Exception {
        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("INSERT INTO docs VALUES (null, ?, ?, ?, ?, ?)");
        ps.setInt(1, objectTO.getColaboratorId());
        ps.setInt(2, objectTO.getType());
        ps.setString(3, objectTO.getName());
        ps.setDate(4, objectTO.getDate());
        ps.setInt(5, objectTO.getState());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void update(DocTO objectTO) throws Exception {
        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("UPDATE docs SET calaborator_id = ?, type = ?, name = ?, date = ?, state= ? WHERE (id = ?)");

        ps.setInt(1, objectTO.getColaboratorId());
        ps.setInt(2, objectTO.getType());
        ps.setString(3, objectTO.getName());
        ps.setDate(4, objectTO.getDate());
        ps.setInt(5, objectTO.getState());
        ps.setInt(6, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void delete(DocTO objectTO) throws Exception {
        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("DELETE FROM docs WHERE (id = ?)");

        ps.setInt(1, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public List<DocTO> select() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DocTO> objectTOList = new ArrayList<DocTO>();

        ps = getConnection().prepareStatement("SELECT id, calaborator_id, type, name, date, state FROM docs WHERE state = 1");
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int id_colaborator = rs.getInt("calaborator_id");
            int type = rs.getInt("type");
            String name = rs.getString("name");
            Date date = rs.getDate("date");
            int state = rs.getInt("state");

            DocTO objectTO = new DocTO(id, name, date, type, id_colaborator, state);

            objectTOList.add(objectTO);
        }
        close(rs);
        close(ps);
        close(conn);

        return objectTOList;
    }

    @Override
    public DocTO selectByPk(DocTO objectTO) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DocTO docsTO = null;

        ps = getConnection().prepareStatement("SELECT id, calaborator_id, type, name, date, state FROM docs WHERE id = ? AND state = 1");
        ps.setInt(1, objectTO.getId());
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            int id_colaborator = rs.getInt("calaborator_id");
            int type = rs.getInt("type");
            String name = rs.getString("name");
            Date date = rs.getDate("date");
            int state = rs.getInt("state");

            docsTO = new DocTO(id, name, date, type, id_colaborator, state);

        }

        close(rs);
        close(ps);
        close(conn);

        return docsTO;
    }
}
