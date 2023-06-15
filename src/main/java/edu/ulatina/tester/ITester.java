package edu.ulatina.tester;

import java.util.List;

/**
 * @author PegasusTeam
 */
public interface ITester<T> {

    public List<T> testSelect();

    public T testSelectByPk(int primaryKey);

    public void testInsert(T object);

    public void testUpdate(T object);

    public void testDelete(int id);

}
