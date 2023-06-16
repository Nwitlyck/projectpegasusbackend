package edu.ulatina.interfaces;

import java.util.List;

/**
 * @author PegasusTeam
 */
public interface ITester<T> {

    public List<T> testSelect();

    public T testSelectByPk(int primaryKey);

    public void testInsert(T objectTO);

    public void testUpdate(T objectTO);

    public void testDelete(int id);

}
