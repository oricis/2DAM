/**
 * @file: Frame.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.view;

//imports

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;



/**
 * This class ...
 * 
 */
public class Frame extends LayoutComposer {

    /**********************************/
    /*** Properties declaration *******/

    	private GUI gui = new GUI();

        
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Construct
	     *
	     */
	    public Frame() {


	    	btn_print.addActionListener(    new AppListener( ));
			btn_to_left.addActionListener(  new AppListener( ));
			btn_to_right.addActionListener( new AppListener( ));
	    }

	    /**
	     * Prints the itemps adds to right list
	     * 
	     */
	    private void printRightContent() {

	    	JTextArea jta = new JTextArea();
	    	String str    = gui.getStrFromItems();
	    	

	    	if ( ! str.equals( "" )) {

	    		jta.setText( str );
                
                try {
                    jta.print();
                    
                } catch( PrinterException e ) {
                    
                    JOptionPane.showMessageDialog(
                        null,
                        "Se ha producido un error de impresión\n" + e.toString()
                    );
                }

	    	} else {

	    		JOptionPane.showMessageDialog(
                    null,
                    "Lista sin contenido"
                );
	    	}
	    }


    /**********************************/
    /*** Internal clases **************/

    	/**
    	 * Class to listen events
    	 * 
    	 */
    	private class AppListener implements ActionListener {

            @Override
            public void actionPerformed( ActionEvent e ) {
                
                Object source = e.getSource();
                
                if ( source == btn_print )
                    printRightContent();

                if ( source == btn_to_left )
                	gui.moveToLeft();

                if ( source == btn_to_right )
                	gui.moveToRight();
            }

    	} //class

    	/**
    	 * Class to handle GUI components
    	 * 
    	 */
    	private class GUI {
            
    		public String getStrFromItems() {

    			ListModel lm = list_right.getModel();

    			String res = "";
    			int rows   = lm.getSize();

    			System.out.println( "Number of items: " + rows ); //traza
    			
    			

    			if ( rows > 0 ) {

    				for ( int i = 0; i < rows; i++ ) {

			            res = res + lm.getElementAt( i ).toString() + "\n";
			        }
    			}
	    			

    			return res;
    		}

            public void moveToLeft() {
            	System.out.println( "Push \"To Left button\"" );

            	//Gets index of the element selected
            	int index   = list_right.getSelectedIndex();

            	//Prevents err if the button if pushed and nothig item is selected
            	if ( index > -1 ) {

            		//Gets element selected from list
	            	String item = list_right.getSelectedValue().toString();
	                System.out.println( "Seleccionado: " + item );

	            	//Sustracts element from first DefaultListModel
	            	dlm_right.remove( index );

	            	//Adds element to second DefaultListModel
					dlm_left.addElement( item );

				} else
            		showMsgNoItemSelected();
            }

            public void moveToRight() {
            	System.out.println( "Push \"To Right button\"" );

				//Gets index of the element selected
            	int index   = list_left.getSelectedIndex();

            	//Prevents err if the button if pushed and nothig item is selected
            	if ( index > -1 ) {
					
					//Gets element selected from list
	            	String item = list_left.getSelectedValue().toString();
	                System.out.println( "Seleccionado: " + item );


	            	//Sustracts element from first DefaultListModel
	            	dlm_left.remove( index );

	            	//Adds element to second DefaultListModel
					dlm_right.addElement( item );

            	} else
            		showMsgNoItemSelected();
            }

    	} //class

    	/**
    	 * Shows the message no item selected
    	 * 
    	 */
    	private void showMsgNoItemSelected() {

    		JOptionPane.showMessageDialog(
    			null,
    			"Ningun item seleccionado"
    		);
    	}

} //class
