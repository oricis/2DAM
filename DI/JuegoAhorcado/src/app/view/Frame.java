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

			btn_play1.addActionListener(   new AppListener( ));
			btn_play2.addActionListener(   new AppListener( ));
            btn_resolve.addActionListener( new AppListener( ));
            btn_restart.addActionListener( new AppListener( ));
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
				
				if ( source == btn_play1 )
					new Game().playPlayer1(); //begin player 2 if a word was write

				if ( source == btn_play2 )
					new Game().playPlayer2();
                
                if ( source == btn_resolve )
                    new Game().resolve();

				if ( source == btn_restart )
					new Game().restart();
			}

		} //class

		/**
		 * Class to handle GUI components
		 * 
		 */
		private class GUI {
			
		
		} //class

} //class
