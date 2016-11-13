/**
 * @file: LayoutComposer.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.view;

//imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import app.model.Client;


/**
 * This class compose the GUI
 * 
 */
public class LayoutComposer extends JFrame {

    /**********************************/
    /*** Properties declaration *******/

    protected DefaultListModel dlm_left  = new DefaultListModel();
    protected DefaultListModel dlm_right = new DefaultListModel();

    private final JPanel panel_central = new JPanel();
    private final JPanel panel_general = new JPanel();

    protected final JButton btn_print    = new JButton( "Imprimir" );
    protected final JButton btn_to_left  = new JButton( "<<<" );
    protected final JButton btn_to_right = new JButton( ">>>" );
    
    protected JList list_left;
    protected JList list_right;


    protected Client c = null;
    protected Object[] arr_data = null;

        
    /**********************************/
    /*** Methods declaration **********/

    	/**
    	 * Construct
    	 * 
    	 */
    	public LayoutComposer() {
    		setDefaultCloseOperation( EXIT_ON_CLOSE );
    		setSize( 400, 300 );
    		setTitle( "Selección e impresion" );

    		//Fills the DefaultListModel in order to populate the list in the left
    		//fillDefaultListModel();

    		//Create the lists
    		list_left	= new JList( dlm_left );
			list_right	= new JList( dlm_right );


    		configComponents();
    		addComponents();
    	}


	    /**
	     * Aux. construct()
	     * Adds the components to GUI
	     *
	     */
	    private void addComponents() {

	    	panel_central.add( btn_to_left );
	    	panel_central.add( btn_print );
	    	panel_central.add( btn_to_right );
			
	    	panel_general.add( new JScrollPane( list_left ));
	    	panel_general.add( panel_central );
	    	panel_general.add( new JScrollPane( list_right ));
			add( panel_general );
	    }

	    /**
	     * Aux. construct()
	     * Configs the GUI components
	     *
	     */
	    private void configComponents() {

			panel_general.setLayout( new GridLayout( 1, 3 )); //int rows, int cols
    		panel_central.setLayout( new GridLayout( 3, 1 ));

    		list_left.setSelectionMode(  ListSelectionModel.SINGLE_SELECTION );
    		list_right.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
	    }

	    /**
	     * Fills DefaultListModel with elements
	     * 
	     */
	    protected void fillDefaultListModel( Object[] arr ) {
	        this.arr_data = arr;
	        int len = arr.length;

	        for( int i = 0; i < len; i++ ) {

	            c = (Client)arr[ i ];
	            dlm_left.addElement( "ID " + c.getId( ));
	        }
	    }
	    /*private void fillDefaultListModel() {
	        
	        for( int i = 1; i < 11; i++ ) {
	            
	            dlm_left.addElement( "Elemento " + i );
	        }
	    }

    /**********************************/
    /*** Internal clases **************/



} //class
