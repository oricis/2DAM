/**
 * @file: ClientsTable.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package jtables.view;

//imports

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import jtables.helpers.Trace;
import jtables.model.Client;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 * This class creates JDialog / JTable to show the data
 * 
 */
public class ClientsTable extends JDialog {

	/**********************************/
	/*** Properties declaration *******/

		private JButton btn  = new JButton( "Cerrar" ); 
		private JPanel panel = new JPanel();
		private JScrollPane scroll;
		private JTable table = new JTable();

		private Object[][] arr_clients = null;
		private final String[] headers = new String[] { 
			"Client ID",  
			"Note"
		}; 
		

	/**********************************/
	/*** Methods declaration **********/

		/** 
		 * Construct 
		 * Recibe como parámetro la ventana que le ha llamado,  
		 * o sea, su padre 
		 * 
    	 * @param 	padre (JFrame)
		 * @param 	arr_clients
		 */ 
		public ClientsTable( JFrame padre, Object[][] arr_clients ) { 
			super( padre, true ); 
			//invoco el constructor de la clase, con dos parámetros:
			//quién es su padre y un booleano para indicar modal o no modal
			
			this.arr_clients = arr_clients; //Sets clients in class property


			setTitle( "Listado de clientes" );
                        
			configComponents();
			add( panel );
		}

		/**
		 * Configs the JDialog components
		 * 
		 */
		private void configComponents() {
			Trace.ln( "ClientsTable / configComponents()" );

			panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ));
			panel.setSize( 400, 600 );
                        panel.setMinimumSize( new Dimension( 400, 600 ));
                        //panel.setPreferredSize( new Dimension( 400, 600 ));

                        //Traza
			//String a = (String) arr_clients[0][1];
                        //Trace.ln( "Nota cliente 1: " + a );	System.exit(0);

			table.setModel( new DefaultTableModel( arr_clients, headers ) { 
				//Types for columns 
				Class[] columnType = {
					Integer.class,
					String.class
				};

				@Override
				public Class getColumnClass( int pos ) {
					return columnType[ pos ];
				}
			});
			//Adds scroll capacity to the table
			scroll = new JScrollPane( table );
                        
/**/

			btn.setPreferredSize( new Dimension( 500, 50 ));

			// Ocultar ventana pulsando <enter> sobre el textfield  
			btn.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed( ActionEvent e ) {
					setVisible( false );
				}
			});

			panel.add( scroll );	//Adds scrollable table
			panel.add( btn );		//Adds the button
		}

} //class
