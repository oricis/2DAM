/**
 * @file: View.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.view;

//imports


/**
 * This class ...
 * 
 */
public class View extends LayoutComposer {

    /**********************************/
    /*** Properties declaration *******/



        
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Construct
	     *
	     * @param arr_data
	     */
	    public View( Object[] arr_data ) {

                new Frame( arr_data ).setVisible( true );
	    }


    /**********************************/
    /*** Internal clases **************/



} //class
