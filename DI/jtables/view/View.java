/**
 * @file: View.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package jtables.view;

//imports
import jtables.helpers.Trace;


/**
 * This class ...
 * 
 */
public class View {

    /**********************************/
    /*** Properties declaration *******/



        
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Construct
	     * 
	     */
	    public View( jtables.controller.Controller c ) {

			new Frame( c ).setVisible( true );
	    }


    /**********************************/
    /*** Internal clases **************/



} //class
