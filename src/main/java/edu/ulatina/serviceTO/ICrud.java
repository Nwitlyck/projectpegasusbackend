package edu.ulatina.serviceTO;

import java.util.List;

/**
 * @author PegasusTeam
 */
public interface ICrud<T> {

    public void insert(T object) throws Exception;

    public void update(T object) throws Exception;

    public void delete(T object) throws Exception;

    public List<T> select() throws Exception;

    public T getByPk(int primaryKey) throws Exception;
    
}
