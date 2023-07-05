package edu.ulatina.serviceTO;

import edu.ulatina.interfaces.ICrud;
import edu.ulatina.transfereObjects.PersonalDataTO;
import edu.ulatina.transfereObjects.ProjectsTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PegasusTeam
 */
public class ServiceProjectsTO extends Service implements ICrud<ProjectsTO> {

    @Override
    public void insert(ProjectsTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("INSERT INTO projects VALUES (null, ?, ?, ?, ?)");
        ps.setString(1, objectTO.getName());
        ps.setDate(2, objectTO.getInitialdate());
        ps.setDate(3, objectTO.getFinaldate());
        ps.setInt(4, objectTO.getState());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }
    @Override
    public void update(ProjectsTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("UPDATE projects SET name = ?, initial_date = ?, final_date = ?, state = ? WHERE (id = ?)");

        ps.setString(1, objectTO.getName());
        ps.setDate(2, objectTO.getInitialdate());
        ps.setDate(3, objectTO.getFinaldate());
        ps.setInt(4, objectTO.getState());
        ps.setInt(5, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }
    @Override
    public void delete(ProjectsTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("DELETE FROM projects WHERE (id = ?)");

        ps.setInt(1, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }
    @Override
    public List<ProjectsTO> select() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ProjectsTO> objectTOList = new ArrayList<ProjectsTO>();

        ps = getConnection().prepareStatement("SELECT id, name, initial_date, final_date, state FROM projects WHERE state = 1");
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Date initialdate = rs.getDate("initial_date");
            Date finaldate = rs.getDate("final_date");
            int state = rs.getInt("state");

            ProjectsTO objectTO = new ProjectsTO(id, name, initialdate, finaldate, state);

            objectTOList.add(objectTO);
        }
        close(rs);
        close(ps);
        close(conn);

        return objectTOList;
    }

    @Override
    public ProjectsTO selectByPk(ProjectsTO objectTO) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProjectsTO projectTO = null;

        ps = getConnection().prepareStatement("SELECT id, name, initial_date, final_date, state FROM projects WHERE id = ? AND state = 1");
        ps.setInt(1, objectTO.getId());
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Date initialdate = rs.getDate("initial_date");
            Date finaldate = rs.getDate("final_date");
            int state = rs.getInt("state");

            projectTO = new ProjectsTO(id, name, initialdate, finaldate, state);

        }

        close(rs);
        close(ps);
        close(conn);

        return projectTO;
    }

}
