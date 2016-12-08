/**
 * @file: ClientsController.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package jtables.controller;

//imports
import jtables.helpers.Trace;
import jtables.model.Model;


/**
 * This class ...
 * 
 */
public class ClientsController {

    /**********************************/
    /*** Properties declaration *******/

        private final Model model;
        private final String table_name = "clients";

        
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Construct
	     *
     * @param model
	     */
	    public ClientsController( Model model ) {
            

	        //Creates a Model
            this.model = model;
	    }
            
        public Object[][] getAll() {
            Trace.ln( "Controller / getAll()" );

            return model.getAll( this.table_name );
        }


    /**********************************/
    /*** Internal clases **************/

    

} //class
