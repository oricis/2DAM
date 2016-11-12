/**
 * @file: Controller.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.controller;

//imports
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

	        v = new View( null );
                m = new Model();
	    }
            
            /**
	     * Method description
	     *
	     * @param 	str
	     */
	    public void xxx( String str ) {

	        // Code here
	    }


    /**********************************/
    /*** Internal clases **************/

    

} //class
