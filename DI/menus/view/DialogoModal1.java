/**
 * @file: DialogoModal1.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package menus.view;

//imports
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 * This class creates a JDialog
 * 
 */
public class DialogoModal1 extends JDialog {

	/**********************************/
	/*** Properties declaration *******/

		private JPanel panel = new JPanel();
		private JTextField textField = new JTextField( 20 );


	/**********************************/
	/*** Methods declaration **********/

		/** 
		 * Construct 
		 * Recibe como parámetro la ventana que le ha llamado,  
		 * o sea, su padre 
		 * 
	     * @param padre
		 */ 
		public DialogoModal1( JFrame padre ) { 
			super( padre, true ); 
			//invoco el constructor de la clase, con dos parámetros:
			//quién es su padre y un booleano para indicar modal o no modal
			
			setTitle( "Mete un dato" );

			configComponents();
			add( panel );
		} 
		
		public String getText() {

			return textField.getText();
		}

		/**
		 * Configs the JDialog components
		 * 
		 */
		private void configComponents() {

			panel.setPreferredSize( new Dimension( 200, 100 ));
			textField.setPreferredSize( new Dimension( 200, 80 ));

			// Ocultar ventana pulsando <enter> sobre el textfield  
			textField.addActionListener( new ActionListener() {

	                        @Override
				public void actionPerformed( ActionEvent e ) { 
					setVisible( false ); 
				}
			});

			panel.add( textField );
		}

} //class
