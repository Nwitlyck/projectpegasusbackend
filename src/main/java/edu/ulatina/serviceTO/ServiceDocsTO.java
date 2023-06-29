
package edu.ulatina.serviceTO;

import edu.ulatina.interfaces.ICrud;
import edu.ulatina.transfereObjects.DocsTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isalo
 */
public class ServiceDocsTO extends Service implements ICrud<DocsTO> {

    @Override
    public void insert(DocsTO objectTO) throws Exception {
       PreparedStatement ps = null; 
       
       ps = getConnection().prepareStatement("INSERT INTO personaldata VALUES (null, ?, ?, ?, ?)");
        ps.setInt(1, objectTO.getId());
        ps.setString(2, objectTO.getName());
        ps.setDate(3, objectTO.getDate());
        ps.setInt(4, objectTO.getType());
        ps.setInt(5, objectTO.getId_colaborator());
        
        close(ps);
        close(conn);
    }

    @Override
    public void update(DocsTO objectTO) throws Exception {
        PreparedStatement ps = null;
        
        ps = getConnection().prepareStatement("UPDATE personaldata SET name = ?, date = ?, type = ?, id_colaborator = ? WHERE = (id = ?)");
        
        ps.setString(1, objectTO.getName());
        ps.setDate(2, objectTO.getDate());
        ps.setInt(3, objectTO.getType());
        ps.setInt(4, objectTO.getId_colaborator());
        ps.setInt(5, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void delete(int id) throws Exception {
         PreparedStatement ps = null;
        
        ps = getConnection().prepareStatement("DELETE FROM docs WHERE (id = ?");
        
        ps.setInt(1, id);
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public List<DocsTO> select() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DocsTO> objectTOList = new ArrayList<DocsTO>();
        
        ps = getConnection().prepareStatement("SELECT id, name, date, type ,id_colaborator");
        rs = ps.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Date date = rs.getDate("date");
            int type = rs.getInt("type");
            int id_colaborator = rs.getInt("id_colaborator");
            
            
            DocsTO objectTO = new DocsTO(id, name, date, type,id_colaborator);
            
            objectTOList.add(objectTO);           
    }
        close( rs);
        close(ps);
        close(conn);

        return objectTOList; 
    }

    @Override
    public DocsTO selectByPk(int primaryKey) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DocsTO objectTO = null;
    
        ps = getConnection().prepareStatement("SELECT id, name, date, type, id_colaborator FROM personaldata WHERE id = ?");
        ps.setInt(1, primaryKey);
        rs = ps.executeQuery();
        
        if (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Date date = rs.getDate("date");
            int type = rs.getInt("type");
            int id_colaborator = rs.getInt("id_colaborator");
            
            
            DocsTO personaldata = new DocsTO(id, name, date, type, id_colaborator);
            objectTO = personaldata;
                     
        }
        
        close(rs);
        close(ps);
        close(conn);

        return objectTO;
    }
  }

  