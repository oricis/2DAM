/**
 * @file: Frame.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package jtables.view;

//imports
import jtables.controller.Controller;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.*;

import jtables.model.Client;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class ...
 * 
 */
public class Frame extends JFrame {

	/**********************************/
	/*** Properties declaration *******/

		private JButton btn_clients = new JButton( "Clientes" );
		private JPanel panel = new JPanel();

		private Controller c = null;


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 */
		public Frame( Controller c ) {
			this.c = c;

			setDefaultCloseOperation( EXIT_ON_CLOSE );
			setLayout( new FlowLayout( ));
			setSize( 400, 200 );
			setTitle( "JTable - Mostrando datos" );

			panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ));

			btn_clients.setPreferredSize(  new Dimension( 100, 40 ));
			btn_clients.addActionListener( new BtnsListener( ));


			panel.add( new JLabel( "Listar datos de las tablas" ));
			panel.add( btn_clients );
			add( panel );
		}

		/**
		 * Shows all clients in a JTable
		 * 
		 */
		private void showAllClients() {
			System.out.println( "Frame / showAllClients()" );
            
                        Object[][] data = c.getAll( "clients" );
                        
			new ClientsTable( 
				this,
				data
			).setVisible( true ); /**/
		}


	/**********************************/
	/*** Internal classes *************/

		/**
		 * Class for application listener.
		 * 
		 */
		class BtnsListener implements ActionListener { 

			/**
			 * Actions for the buttons
			 *
			 * @param	  e -> ActionEvent
			 */
			@Override
			public void actionPerformed( ActionEvent e ) {
				Object source = e.getSource();

				if ( source == btn_clients ) {
					System.out.println( "Mostrando clientes..." );

					showAllClients();
				}

			} //actionPerformed

		} //class
} //class
