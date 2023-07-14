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
        
        ps = getConnection().prepareStatement("INSERT INTO colaborators VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, objectTO.getManagerId());
        ps.setString(2, objectTO.getEmail());
        ps.setInt(3, objectTO.getAcceslevel());
        ps.setDate(4, objectTO.getHireDate());
        ps.setDate(5, objectTO.getFireDate());
        ps.setInt(6, objectTO.getVacationDays());
        ps.setString(7, objectTO.getPassword());
        ps.setInt(8, objectTO.getState());
        ps.executeUpdate();
        
        close(ps);
        close(conn);
    }
    
    @Override
    public void update(ColaboratorTO objectTO) throws Exception {
        
        PreparedStatement ps = null;
        
        ps = getConnection().prepareStatement("UPDATE colaborators SET manager_id = ?, email = ?, access_level = ?, hire_date = ?, fire_date = ? , password = ?, vacationdays = ?, state = ? WHERE (id = ?)");
        ps.setInt(1, objectTO.getManagerId());
        ps.setString(2, objectTO.getEmail());
        ps.setInt(3, objectTO.getAcceslevel());
        ps.setDate(4, objectTO.getHireDate());
        ps.setDate(5, objectTO.getFireDate());
        ps.setString(6, objectTO.getPassword());
        ps.setInt(7, objectTO.getVacationDays());
        ps.setInt(8, objectTO.getState());
        ps.setInt(9, objectTO.getId());
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
        
        ps = getConnection().prepareStatement("SELECT id, manager_id, email, access_level, hire_date, fire_date, password, vacationdays, state FROM colaborators WHERE state = 1");
        rs = ps.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            int managerId = rs.getInt("manager_id");
            String email = rs.getString("email");
            int accesslevel = rs.getInt("access_level");
            Date hiredate = rs.getDate("hire_date");
            Date firedate = rs.getDate("fire_date");
            String password = rs.getString("password");
            String vacationDays = rs.getString("vacationdays");
            int state = rs.getInt("state");
            
            ColaboratorTO objectTO = new ColaboratorTO(id, managerId, email, accesslevel, hiredate, firedate, password, managerId, state);
            
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
        
        ps = getConnection().prepareStatement("SELECT id, manager_id, email, access_level, hire_date, fire_date, password, vacationdays, state FROM colaborators WHERE id = ? AND state = 1");
        ps.setInt(1, objectTO.getId());
        rs = ps.executeQuery();
        
        if (rs.next()) {
            int id = rs.getInt("id");
            int managerId = rs.getInt("manager_id");
            String email = rs.getString("email");
            int accesslevel = rs.getInt("access_level");
            Date hiredate = rs.getDate("hire_date");
            Date firedate = rs.getDate("fire_date");
            String password = rs.getString("password");
            String vacationDays = rs.getString("vacationdays");
            int state = rs.getInt("state");
            
            colaboratorTO = new ColaboratorTO(id, managerId, email, accesslevel, hiredate, firedate, password, managerId, state);
        }
        
        close(rs);
        close(ps);
        close(conn);
        
        return colaboratorTO;
    }
    
    public List<ColaboratorTO> selectByManagerId(int byManagerId) throws Exception {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ColaboratorTO> objectTOList = new ArrayList<ColaboratorTO>();
        
        ps = getConnection().prepareStatement("SELECT id, manager_id, email, access_level, hire_date, fire_date, password, vacationdays, state FROM colaborators WHERE manager_id = ? AND state = 1");
        ps.setInt(1, byManagerId);
        rs = ps.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            int managerId = rs.getInt("manager_id");
            String email = rs.getString("email");
            int accesslevel = rs.getInt("access_level");
            Date hiredate = rs.getDate("hire_date");
            Date firedate = rs.getDate("fire_date");
            String password = rs.getString("password");
            String vacationDays = rs.getString("vacationdays");
            int state = rs.getInt("state");
            
            ColaboratorTO objectTO = new ColaboratorTO(id, managerId, email, accesslevel, hiredate, firedate, password, managerId, state);
            
            objectTOList.add(objectTO);
        }
        
        close(rs);
        close(ps);
        close(conn);
        
        return objectTOList;
    }
    
    public ColaboratorTO selectByEmail(String byEmail) throws Exception {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        ColaboratorTO objectTO = null;
        
        ps = getConnection().prepareStatement("SELECT id, manager_id, email, access_level, hire_date, fire_date, password, vacationdays, state FROM colaborators WHERE email = ? AND state = 1");
        ps.setString(1, byEmail);
        rs = ps.executeQuery();
        
        if (rs.next()) {
            int id = rs.getInt("id");
            int managerId = rs.getInt("manager_id");
            String email = rs.getString("email");
            int accesslevel = rs.getInt("access_level");
            Date hiredate = rs.getDate("hire_date");
            Date firedate = rs.getDate("fire_date");
            String password = rs.getString("password");
            String vacationDays = rs.getString("vacationdays");
            int state = rs.getInt("state");
            
            objectTO = new ColaboratorTO(id, managerId, email, accesslevel, hiredate, firedate, password, managerId, state);
        }
        
        close(rs);
        close(ps);
        close(conn);
        
        return objectTO;
    }
    
    public List<ColaboratorTO> selectByState(int byState) throws Exception {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ColaboratorTO> objectTOList = new ArrayList<ColaboratorTO>();
        
        ps = getConnection().prepareStatement("SELECT id, manager_id, email, access_level, hire_date, fire_date, password, vacationdays, state FROM colaborators WHERE state = ?");
        ps.setInt(1, byState);
        rs = ps.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            int managerId = rs.getInt("manager_id");
            String email = rs.getString("email");
            int accesslevel = rs.getInt("access_level");
            Date hiredate = rs.getDate("hire_date");
            Date firedate = rs.getDate("fire_date");
            String password = rs.getString("password");
            String vacationDays = rs.getString("vacationdays");
            int state = rs.getInt("state");
            
            ColaboratorTO objectTO = new ColaboratorTO(id, managerId, email, accesslevel, hiredate, firedate, password, managerId, state);
            
            objectTOList.add(objectTO);
        }
        
        close(rs);
        close(ps);
        close(conn);
        
        return objectTOList;
    }
    
}
