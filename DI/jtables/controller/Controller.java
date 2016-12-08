/**
 * @file: Controller.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package jtables.controller;

//imports
import jtables.helpers.Trace;
import jtables.model.Model;
import jtables.view.View;



/**
 * This class ...
 * 
 */
public class Controller {

    /**********************************/
    /*** Properties declaration *******/

        private View v  = null;
        private Model m = null;

        
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Construct
	     *
	     */
	    public Controller() {

	        //Creates a Model
            m = new Model();

            
            //Creates a View and injects an instance of this class
            v = new View( this );
	    }
        
        /**
         * Gets the data from DB -> rows from table "xxx"
         *
         * @param      table_name
         * @return     All.
         */
        public Object[][] getAll( String table_name ) {
            Trace.ln( "Controller / getAll() -> Table: " + table_name + "\n" );
            
            Object[][] res = null;

            //For table "clients" use the class: "ClientsController"
            if ( table_name.equals( "clients" ))
                res = new ClientsController( m ).getAll();
            
            
            return res;
        }


    /**********************************/
    /*** Internal clases **************/

    

} //class
