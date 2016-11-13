/**
 * @file: Model.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.model;

//imports


/**
 * This class ...
 * 
 */
public class Model {

    /**********************************/
    /*** Properties declaration *******/

    	//private Object[] arr_data = null;


        
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Construct
	     *
	     */
	    public Model() {}


	    /**
	     * Returns all rows from the table
	     *
             * @param   table_name
	     * @return 	arr_data
	     */
	    public Object[] getAll( String table_name ) {

	        if ( table_name.equals( "clients" )) {

	        	//ClientsDAO cdao = new ClientsDAO();
	        	return new ClientsDAO().selectAll();
	        }
                
                
                return null;
	    }


    /**********************************/
    /*** Internal clases **************/

    

} //class
