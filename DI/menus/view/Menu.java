/**
 * @file: Frame.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package menus.view;

//imports
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


/**
 * This class ...
 * 
 */
public class Menu extends JFrame {

	/**********************************/
	/*** Properties declaration *******/

		//MENÚ:  
		private JMenuBar menuBar;
		private JMenu menu;
		private final JMenuItem menuItem1 = new JMenuItem( "Opción 1" );
		private final JMenuItem menuItem2 = new JMenuItem( "Opcion 2" );


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 */
		public Menu() { 
			setSize( 400, 200 ); 
			setTitle( "Ventanas modales y no modales" ); 
			setDefaultCloseOperation( EXIT_ON_CLOSE ); 
			setLayout( new FlowLayout( )); 

			

			//Create the menu 
			menuBar = new JMenuBar();
			menu	= new JMenu( "Primer Menú" ); 
			menuBar.add( menu );
						
			//Añadir listener al menú:
			menuItem1.addActionListener( new Em( this )); 
			menuItem2.addActionListener( new Em( this )); 
						
			menu.add( menuItem1 ); 
			menu.addSeparator();
			menu.add( menuItem2 ); 
			
			//Build second menu in the menu bar
			menu = new JMenu( "Segundo Menú" );
			menu.addMenuListener( new MenuListener() {
				@Override
				public void menuSelected( MenuEvent e ) {
					pushJMenu2();
					
					//Deselected and finished working in the JMenu
					//From: http://stackoverflow.com/questions/10182169/java-jmenu-selected-and-deselected-feature
					//javax.swing.Timer
					new Timer( 0, new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							menu.setSelected( false );
							((Timer) e.getSource()).stop();
						}
					}).start();
				}

				@Override
				public void menuDeselected(MenuEvent e) {
					//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
				}

				@Override
				public void menuCanceled(MenuEvent e) {
					//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
				}
			});

			menuBar.add( menu );
			add( menuBar ); 
		} 

		private void pushJMenu2() {
			System.out.println( "Push the second JMenu...");

			DialogoModal3 dModal3 = new DialogoModal3( this );

			dModal3.pack(); // para darle tamaño automático a la ventana.  
			dModal3.setVisible( true );
		}


	/**********************************/
	/*** Internal classes *************/

		//LISTENER FUERA:  
		class Em implements ActionListener { 
			
			JFrame miFrame;

			/**
			 * Construct
			 *
			 * @param	  f -> a JFrame
			 */
			public Em( JFrame f ) { 
				miFrame = f; 
			} 

			/**
			 * { function_description }
			 *
			 * @param	  e -> ActionEvent
			 */
			@Override
			public void actionPerformed( ActionEvent e ) {
				Object source = e.getSource();

				if ( source == menuItem1 ) {
					System.out.println( "Push the JMenuItem1...");

					DialogoModal1 dModal1 = new DialogoModal1( miFrame );

					dModal1.setMinimumSize( new Dimension( 100, 200 ));
					//dModal1.pack(); // para darle tamaño automático a la ventana.  
					
					dModal1.setVisible( true ); 
					//Al ser una ventana modal no volverá a esta línea   
					//hasta que no sea cerrada la otra
					System.out.println( dModal1.getText( ));
					
				}

				if ( source == menuItem2 ) {
					System.out.println( "Push the JMenuItem2...");

					DialogoModal2 dModal2 = new DialogoModal2( miFrame );

					dModal2.pack(); // para darle tamaño automático a la ventana.  
					dModal2.setVisible( true );
				}

				/*if ( source == menu && flag ) {
					System.out.println( "Push the JMenu...");

					DialogoModal2 dModal3 = new DialogoModal2( miFrame );

					dModal3.pack(); // para darle tamaño automático a la ventana.  
					dModal3.setVisible( true );
				} /**/
			}

		} //class
} //class
