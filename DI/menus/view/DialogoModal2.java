/**
 * @file: DialogoModal2.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package menus.view;

//imports

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * This class creates a JDialog
 * 
 */
public class DialogoModal2 extends JDialog {

	/**********************************/
	/*** Properties declaration *******/

		private final JLabel label = new JLabel( "Esta es una ventana modal" );
		private JButton btn  = new JButton( "Cerrar" ); 
		private JPanel panel = new JPanel();

		
	/**********************************/
	/*** Methods declaration **********/

		/** 
		 * Construct 
		 * Recibe como parámetro la ventana que le ha llamado,  
		 * o sea, su padre 
		 * 
    	 * @param padre
		 */ 
		public DialogoModal2( JFrame padre ) { 
			super( padre, true ); 
			//invoco el constructor de la clase, con dos parámetros:
			//quién es su padre y un booleano para indicar modal o no modal
			
			setTitle( "Aviso desde JMenuItem" );
                        
                        
			configComponents();
			add( panel );
		}

		/**
		 * Configs the JDialog components
		 * 
		 */
		private void configComponents() {

			panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ));
			panel.setPreferredSize( new Dimension( 200, 100 ));

			btn.setPreferredSize( new Dimension( 200, 50 ));

			// Ocultar ventana pulsando <enter> sobre el textfield  
			btn.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed( ActionEvent e ) {
					setVisible( false );
				}
			});

			panel.add( label );
			panel.add( btn );
		}

} //class
