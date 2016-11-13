/**
 * @file: Frame.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.view;

//imports

import app.helpers.Trace;
import app.model.Client;
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
        public Client[] arr_clients = null;
        
        
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Construct
	     *
             * @param arr_data
	     */
	    public Frame( Object[] arr_data ) {

                //arr_clients = (Client[]) arr_data;
                fillDefaultListModel( arr_data );
                
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

    			String res  = "";
                String temp = "";
                int index;
    			int rows    = lm.getSize();

    			System.out.println( "Number of items: " + rows ); //traza
    			
    			

    			if ( rows > 0 ) {

    				for ( int i = 0; i < rows; i++ ) {

                        temp = lm.getElementAt( i ).toString(); //p.e. "ID 1"
                        temp = temp + "\nNote: " + this.getNotes( temp );

			            res = res + temp + "\n\n";
			        }
    			}


    			return res;
    		}

            /**
             * Extracts ID from str and uses it to gets notes from the client
             *
             * @param      str   The string
             */
            private String getNotes( String str ) {

                try {
                    
                    //Gets the ID to the client
                    int id  = Integer.parseInt( str.substring( 3 )); //substring( int pos_initial )
                    
                    //Gets number of clients from data used to fill the GUI
                    int len = arr_data.length;

                    //Iterates the array of data and gets the client for the ID
                    for ( int i = 0; i < len; i++ ) {

                        c = (Client)arr_data[ i ];

                        //If finds the client -> ends the iterations
                        if ( c.getId() == id )
                            break;

                        else
                            c = null;
                    }


                } catch( NumberFormatException e ) {

                    Trace.ln( "Error obteniendo ID from: " + str.substring( 3 ));
                    Trace.ln( "---> " + e.toString( ));
                }
                    

                //Exists a client -> returns his notes
                if ( c != null )
                    return c.getNotes();


                return "";
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
