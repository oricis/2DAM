/**
 * @file: View.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.view;

//imports
import java.awt.*;
import javax.swing.*;



/**
 * This class ...
 * 
 */
public class LayoutComposer extends JFrame {

	/**********************************/
	/*** Properties declaration *******/

		protected String[][] pregunta;
		final private int width  = 460;
		final private int height = 700;


		private final JPanel panel_general = new JPanel();
		private final JPanel panel_1 = new JPanel();
		private final JPanel panel_2 = new JPanel();
		private final JPanel panel_3 = new JPanel();
		private final JPanel panel_4 = new JPanel();
		private final JPanel panel_5 = new JPanel();

		final protected JButton btn = new JButton( "Corregir" ); //Button for the images

		final protected ButtonGroup bg1 = new ButtonGroup();   //connect the radios
		final protected ButtonGroup bg2 = new ButtonGroup();
		final protected ButtonGroup bg3 = new ButtonGroup();
		final protected ButtonGroup bg4 = new ButtonGroup();
		final protected ButtonGroup bg5 = new ButtonGroup();
		
		private JLabel pregunta_1 = new JLabel();
		private JLabel pregunta_2 = new JLabel();
		private JLabel pregunta_3 = new JLabel();
		private JLabel pregunta_4 = new JLabel();
		private JLabel pregunta_5 = new JLabel();

		protected JRadioButton rb_1a = null;
		protected JRadioButton rb_2a = null;
		protected JRadioButton rb_3a = null;
		protected JRadioButton rb_1b = null;
		protected JRadioButton rb_2b = null;
		protected JRadioButton rb_3b = null;
		protected JRadioButton rb_1c = null;
		protected JRadioButton rb_2c = null;
		protected JRadioButton rb_3c = null;
		protected JRadioButton rb_1d = null;
		protected JRadioButton rb_2d = null;
		protected JRadioButton rb_3d = null;
		protected JRadioButton rb_1e = null;
		protected JRadioButton rb_2e = null;
		protected JRadioButton rb_3e = null;

		final private Dimension d = new Dimension(( width - 20 ), 120 );

	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Method description
		 *
		 * @param 	pregunta
		 */
		public LayoutComposer( String[][] pregunta ) {
				setDefaultCloseOperation( EXIT_ON_CLOSE );
				setResizable ( false );
				setSize( width, height );
				setTitle( "Test" );

				this.pregunta = pregunta;
		
				configComponents();
				
				panel_general.add( panel_1 );
				panel_general.add( panel_2 );
				panel_general.add( panel_3 );
				panel_general.add( panel_4 );
				panel_general.add( panel_5 );
				panel_general.add( btn );
				add( panel_general );
		}

		private void configComponents() {
			configPanels();
			configRadios();
                        
			btn.setPreferredSize( new Dimension(( width - 22 ), 42 ));

			pregunta_1.setText( pregunta[0][0] );
			pregunta_2.setText( pregunta[1][0] );
			pregunta_3.setText( pregunta[2][0] );
			pregunta_4.setText( pregunta[3][0] );
			pregunta_5.setText( pregunta[4][0] );
		}

		private void configPanels() {
			panel_general.setLayout( new FlowLayout( ));
			panel_1.setLayout( new BoxLayout( panel_1, BoxLayout.Y_AXIS ));
			panel_2.setLayout( new BoxLayout( panel_2, BoxLayout.Y_AXIS ));
			panel_3.setLayout( new BoxLayout( panel_3, BoxLayout.Y_AXIS ));
			panel_4.setLayout( new BoxLayout( panel_4, BoxLayout.Y_AXIS ));
			panel_5.setLayout( new BoxLayout( panel_5, BoxLayout.Y_AXIS ));

			panel_1.setPreferredSize( d );
			panel_2.setPreferredSize( d );
			panel_3.setPreferredSize( d );
			panel_4.setPreferredSize( d );
			panel_5.setPreferredSize( d );

			panel_1.setBorder( BorderFactory.createTitledBorder( "Pregunta 1" ));
			panel_2.setBorder( BorderFactory.createTitledBorder( "Pregunta 2" ));
			panel_3.setBorder( BorderFactory.createTitledBorder( "Pregunta 3" ));
			panel_4.setBorder( BorderFactory.createTitledBorder( "Pregunta 4" ));
			panel_5.setBorder( BorderFactory.createTitledBorder( "Pregunta 5" ));
		}

		private void configRadios() {
			rb_1a = new JRadioButton( pregunta[0][1], false );
			rb_2a = new JRadioButton( pregunta[0][2], false );
			rb_3a = new JRadioButton( pregunta[0][3], false );
			rb_1b = new JRadioButton( pregunta[1][1], false );
			rb_2b = new JRadioButton( pregunta[1][2], false );
			rb_3b = new JRadioButton( pregunta[1][3], false );
			rb_1c = new JRadioButton( pregunta[2][1], false );
			rb_2c = new JRadioButton( pregunta[2][2], false );
			rb_3c = new JRadioButton( pregunta[2][3], false );
			rb_1d = new JRadioButton( pregunta[3][1], false );
			rb_2d = new JRadioButton( pregunta[3][2], false );
			rb_3d = new JRadioButton( pregunta[3][3], false );
			rb_1e = new JRadioButton( pregunta[4][1], false );
			rb_2e = new JRadioButton( pregunta[4][2], false );
			rb_3e = new JRadioButton( pregunta[4][3], false );

			panel_1.add( pregunta_1 );
			panel_1.add( rb_1a );
			panel_1.add( rb_2a );
			panel_1.add( rb_3a );
			panel_2.add( pregunta_2 );
			panel_2.add( rb_1b );
			panel_2.add( rb_2b );
			panel_2.add( rb_3b );
			panel_3.add( pregunta_3 );
			panel_3.add( rb_1c );
			panel_3.add( rb_2c );
			panel_3.add( rb_3c );
			panel_4.add( pregunta_4 );
			panel_4.add( rb_1d );
			panel_4.add( rb_2d );
			panel_4.add( rb_3d );
			panel_5.add( pregunta_5 );
			panel_5.add( rb_1e );
			panel_5.add( rb_2e );
			panel_5.add( rb_3e );
		}
		

	/**********************************/
	/*** Internal clases **************/



} //class
