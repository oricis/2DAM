/**
 * @file: TestDAO.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.test;


/**
 * Invoke test classes over the DAO
 *
 */
public class TestDAO {

    /**********************************/
    /*** Properties declaration *******/


    
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Construct
	     * 
	     */
	    public TestDAO( String test ) {


	    	if ( test.equals( "clients" ))
	    		new TestClientsDAO();

	    }

} //class
