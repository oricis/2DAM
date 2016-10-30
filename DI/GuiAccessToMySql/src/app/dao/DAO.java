/**
 * @file: DAO.java
 * @info: interface DAO (Data Access Object)
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.dao;


/**
 * This interface implement the DAO Design Pattern
 * 
 */
interface DAO {
    
    public void closeConnection();
    public void setConnection();
    
    //CRUD
    public void delete( Object o );
    public void edit(   Object o );
    public void insert( Object o );
    public Object selectOne( int id );
    public Object[] selectAll();
    
        
} //interface