/**
 * @file: Controller.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.controller;

//imports
import app.model.Client;
import app.model.Model;
import app.view.View;



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

            //Gets the data from DB -> rows from table "clients"
            //Creates a View with the data
            Object[] arr_clients = m.getAll( "clients" );
            v = new View( arr_clients );
	    }
            


    /**********************************/
    /*** Internal clases **************/

    

} //class
