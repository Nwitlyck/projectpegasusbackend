
package edu.ulatina.serviceTO;


import edu.ulatina.interfaces.ICrud;
import edu.ulatina.transfereObjects.PersonalDataTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isalo
 */
public class ServicePersonalDataTO extends Service implements ICrud<PersonalDataTO> {
    
@Override 
    public void insert (PersonalDataTO objectTO) throws Exception{
        
        PreparedStatement ps = null; 
        
        ps = getConnection().prepareStatement("INSERT INTO personaldata VALUES (null, ?, ?, ?, ?)");
        ps.setInt(1, objectTO.getId());
        ps.setString(2, objectTO.getName());
        ps.setDate(3, objectTO.getBirthdate());
        ps.setInt(4, objectTO.getEmergencycontact());
        ps.setInt(5, objectTO.getId_colaborator());
        
        close(ps);
        close(conn);
    }

    
    public void update(PersonalDataTO objectTO) throws Exception {
        
        PreparedStatement ps = null;
        
        ps = getConnection().prepareStatement("UPDATE personaldata SET name = ?, birthdate = ?, emergencycontact = ?, id_colaborator = ? WHERE = (id = ?)");
        
        ps.setString(1, objectTO.getName());
        ps.setDate(2, objectTO.getBirthdate());
        ps.setInt(3, objectTO.getEmergencycontact());
        ps.setInt(4, objectTO.getId_colaborator());
        ps.setInt(5, objectTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }
    
    public void delete (int id) throws Exception {
        
        PreparedStatement ps = null;
        
        ps = getConnection().prepareStatement("DELETE FROM personaldata WHERE (id = ?");
        
        ps.setInt(1, id);
        ps.executeUpdate();

        close(ps);
        close(conn);
    }
    
   
    public List<PersonalDataTO> select() throws Exception{
         PreparedStatement ps = null;
        ResultSet rs = null;
        List<PersonalDataTO> objectTOList = new ArrayList<PersonalDataTO>();
        
        ps = getConnection().prepareStatement("SELECT id, name, birthdate, emergencycontact,id_colaborator");
        rs = ps.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Date birthdate = rs.getDate("birthdate");
            int emergencycontact = rs.getInt("emergencycontact");
            int id_colaborator = rs.getInt("id_colaborator");
            
            
            PersonalDataTO objectTO = new PersonalDataTO(id, name, birthdate, emergencycontact, id_colaborator);
            
            objectTOList.add(objectTO);           
    }
        close( rs);
        close(ps);
        close(conn);

        return objectTOList; 
}
     
    @Override
    public PersonalDataTO selectByPk(int primaryKey) throws Exception {
         PreparedStatement ps = null;
        ResultSet rs = null;
        PersonalDataTO objectTO = null;
    
        ps = getConnection().prepareStatement("SELECT id, name, birthdate, emergencycontact, id_colaborator FROM personaldata WHERE id = ?");
        ps.setInt(1, primaryKey);
        rs = ps.executeQuery();
        
        if (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Date birthdate = rs.getDate("birthdate");
            int emergencycontact = rs.getInt("emergencycontact");
            int id_colaborator = rs.getInt("id_colaborator");
            
            
            PersonalDataTO personaldata = new PersonalDataTO(id, name, birthdate, emergencycontact, id_colaborator);
            objectTO = personaldata;
                     
        }
        
        close(rs);
        close(ps);
        close(conn);

        return objectTO;
    }

}

