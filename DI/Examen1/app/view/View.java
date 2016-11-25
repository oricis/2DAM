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
public class View {

    /**********************************/
    /*** Properties declaration *******/



        
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Method description
	     *
	     * @param 	preguntas
	     * @param 	correctas
	     */
	    public View( String[][] preguntas, int[] correctas ) {

			new Frame( preguntas, correctas ).setVisible( true );
	    }


    /**********************************/
    /*** Internal clases **************/



} //class
