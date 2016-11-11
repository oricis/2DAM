/**
 * @file: LayoutComposer.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.view;

//imports
import java.awt.*;
import javax.swing.*;


/**
 * This class compose a GUI
 * 
 */
public class LayoutComposer extends JFrame {

    /**********************************/
    /*** Properties declaration *******/

    	//GUI panels
        protected JPanel panel_general  = new JPanel();


    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Construct
	     *
	     */
	    public LayoutComposer() {
	    	setDefaultCloseOperation( EXIT_ON_CLOSE );
            //setLayout( new FlowLayout( )); //default layout
            setSize( 640, 480 );
            setTitle( "Frame Title" );

            
            init();
	    }

	    /**
         * Sets layout and loads the components
         * 
         */
        private void init() {

            /*******************************************/
            /* Config elements                         */
            
                // Layouts
                panel_general.setLayout( new BorderLayout( ));


            /*******************************************/
            /* Add components to frame                 */

                addGUIComponents();

                add( panel_general );
        }

        /**
         * Adds the components to GUI
         * 
         */
        private void addGUIComponents() {

        	//
            // Add layout´s components here
            // 
            // 
        }


    /**********************************/
    /*** Internal clases **************/



} //class
