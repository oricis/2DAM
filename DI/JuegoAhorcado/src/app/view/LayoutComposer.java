/**
 * @file: LayoutComposer.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.view;

//imports
import java.awt.GridLayout;
import javax.swing.*;

import app.helpers.Trace;
import app.helpers.Utils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class ...
 * 
 */
public class LayoutComposer extends JFrame {

	/**********************************/
	/*** Properties declaration *******/

	private final Dimension d = new Dimension( 280, 42 ); //width, height
	private final JPanel panel_general  = new JPanel();
	private final JPanel panel_imagen   = new JPanel();
	private final JPanel panel_players  = new JPanel();
	private final JPanel panel_player1  = new JPanel();
	private final JPanel panel_player2  = new JPanel();

	protected JButton btn_img		    = new JButton(); //Button for the images
	protected final JButton btn_play1   = new JButton( "Comenzar" );
	protected final JButton btn_play2   = new JButton( "Validar" );
	protected final JButton btn_resolve = new JButton( "Finalizar juego" );
	protected final JButton btn_restart = new JButton( "Reiniciar juego" );
	
	protected JLabel word = new JLabel(); //To set hits of player 2 

	protected JPasswordField field_word = new JPasswordField();
	protected JTextField field_letter	= new JTextField();


	private final int n_imgs   = 5;
	private ImageIcon[] imgs = new ImageIcon[ n_imgs ];
	
	private String hidden_word;
	private int hits        = 0;        //Count plays of player 2
	private final int hits_allowed = 5; //Max. plays of player 2
	private int hits_valid  = 0; //Max. plays of player 2
	
	//Instance internal classes
	protected Game game  		= new Game();
	protected GameLoader gLoad 	= new GameLoader();
	protected GUI gui 			= new GUI();



	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 */
		public LayoutComposer() {
			Trace.ln( "LayoutComposer / construct()" );

			setDefaultCloseOperation( EXIT_ON_CLOSE );
                        setResizable ( false );
			setSize( 600, 400 );
			setTitle( "Juego del ahorcado" );
                        

			configComponents();
			configTheLayout();
			constructGUI();

			//Prepares the game to begin
			new Game().restart();
		}

		/**
		 * Aux. construct()
		 * Adds the componenets/panels to the GUI
		 *
		 */
		private void constructGUI() {

			panel_imagen.add( btn_img );
			panel_imagen.add( btn_resolve );
			panel_imagen.add( btn_restart );

			panel_player1.add( new JLabel( "Palabra a adivinar:" ));
			panel_player1.add( field_word );
			panel_player1.add( btn_play1 );

			panel_player2.add( new JLabel( "Introduce una letra:" ));
			panel_player2.add( field_letter );
			panel_player2.add( btn_play2 );
			panel_player2.add( word );

			panel_players.add( panel_player1 );
			panel_players.add( panel_player2 );
			
			panel_general.add( panel_imagen );
			panel_general.add( panel_players );

			add( panel_general );
		}

		/**
		 * Aux. construct()
		 * Configs the GUI components
		 *
		 */
		private void configComponents() {
			Trace.ln( "LayoutComposer / configComponents()" );

			//Sets the images in the array
			gLoad.setImgs();

			//Config size for buttons
			btn_img.setPreferredSize( new Dimension( 280, 248 )); //width, height
			btn_resolve.setPreferredSize( d );
			btn_restart.setPreferredSize( d );
			btn_play1.setPreferredSize( d );
			btn_play2.setPreferredSize( d );

			//Config size for fields
			field_letter.setPreferredSize( d );
			field_word.setPreferredSize( d );

			word.setForeground( Color.RED );
			word.setFont( new Font( "Serif", Font.PLAIN, 30 ));


			//Borders y titles for internal panels
			panel_imagen.setBorder(  BorderFactory.createTitledBorder( "Partida" ));
			panel_player1.setBorder( BorderFactory.createTitledBorder( "Jugador 1" )); 
			panel_player2.setBorder( BorderFactory.createTitledBorder( "Jugador 2" )); 
		}

		/**
		 * Aux. construct()
		 * Configs the panels
		 *
		 */
		private void configTheLayout() {

			panel_general.setLayout( new GridLayout( 1, 2 )); //int rows, int cols
			panel_players.setLayout( new GridLayout( 2, 1 ));
		}

		


	/**********************************/
	/*** Internal clases **************/

		/**
		 * Class for handle the game
		 * 
		 */
		protected class Game {

			protected String letter = "";


			/**
			 * Finishs the game and show the "secret word" from player 1
			 * 
			 */
			public void resolve() {
				Trace.ln( "LayoutComposer / resolve()" );

				word.setText( hidden_word );
				finishPlay( "" );
			}
			
			public void restart() {
				Trace.ln( "LayoutComposer / restart()" );

				//Reset plays counters
				resetCounters();

				//Load the image
				gui.loadImg();

				field_letter.setText( "" );
				field_word.setText( "" );

				word.setText( "" );

				//Active btn player 1
				//Desactive btn player 2
				btn_play1.setEnabled( true );
				btn_play2.setEnabled( false );

				//Active btn to finish game
				btn_resolve.setEnabled( true );

				//Active edition in field of player 1 
				//Desactive edition in field of player 2
				field_letter.setEnabled( false );
				field_word.setEnabled( true );
			}

			/**
			 * Player 1 has introduced a word and pulse his button
			 * 
			 */
			public void playPlayer1() {
				Trace.ln( "LayoutComposer / playPlayer1()" );

				
				if ( isValidPlayPlayer1( )) {

					//Stores the secret word in class property
					hidden_word = field_word.getText();

					//Sets positions for hidden letters with bars
					//For example: "chariot" -> "-------"
					word.setText( Utils.getBarString( hidden_word.length( )));
					

					//Active btn player 2
					//Desactive btn player 1
					btn_play1.setEnabled( false );
					btn_play2.setEnabled( true );

					//Active edition in field of player 2 
					//Desactive edition in field of player 1
					field_letter.setEnabled( true );
					field_word.setEnabled( false );
				
				} else
					restart();
			}

			/**
			 * Player 2 has pulsed his button
			 * 
			 */
			public void playPlayer2() {
				Trace.ln( "LayoutComposer / playPlayer2()" );

				String[] arr_err_msgs = {
					"Introduce una letra",
					"Introduce sólo una letra",
					"Introduce una letra válida"
				};
				letter = field_letter.getText();

				///////////////////////////////////////////////////////////////////
				//
				// Only if considered a play for player 2 when he intro a letter
				// No is a valid play if he intro a number, two letters, nothing...
				//
				///////////////////////////////////////////////////////////////////
				
				//User introduced a letter
				// - Count plays of player 2
				// - Seeks coincidendes in secret word
				if ( app.helpers.Validations.isLetter( letter, arr_err_msgs )) {
					Trace.ln( "Comprobando si letra " + letter + " esta en la palabra..." );

					//The game is over -> Player 1 win !
					if ( hits == hits_allowed ) {
						finishPlay( "¡ Jugador 1 ha ganado !" );


					} else {

						hits = hits + 1;
						
						//Checks if letter is in secret word
						checksLetterAndSets();
					}	
				}

				//Player 2 win !!!
				if ( hidden_word.equals( word.getText( ))) 
					finishPlay( "¡ Jugador 2 ha ganado !" );

   	
				//Erases field content and focus
				field_letter.setText( "" );
				field_letter.requestFocus();
			}

			/**
			 * Check if letter is in "secret word" and acting consequently
			 * 
			 */
			private void checksLetterAndSets() {

				//Gets positions for the letter in the word
				//  WARNING !!! -> this method return a null if don´t find the letter
				int[] pos = Utils.getPositionsInStr( 
					letter.charAt( 0 ),
					hidden_word 
				);

				//if ( pos == null ) -> next line fails
				//Trace.ln( "Coincidencias: " + pos.length );

				//Letter is in the "secret word"
				//Fills position for "secret word" in the GUI (change red bars)
				if ( pos != null ) {
					Trace.ln( "Letra encontrada: " + letter );
					hits_valid = hits_valid + 1;

					String temp = Utils.changeLettersIn( 
						letter.charAt( 0 ),
						word.getText(), 
						pos 
					);

					word.setText( temp );

				} else {
					Trace.ln( "Letra " + letter + " no encontrada" );
					
					//Puts the next hanged image
					gui.loadImg();

					JOptionPane.showMessageDialog(
						null, 
						"Letra NO encontrada.\nQuedan " 
						+ ( hits_allowed - hits ) + " intentos."
					);
				}
			}

			/**
			 * Finishes actual play
			 *
			 * @param	msg		The message to show
			 */
			private void finishPlay( String msg ) {

				JOptionPane.showMessageDialog(
					null,
					"El juego ha terminado \n" + msg
				);

				//Blocks GUI components
				btn_play2.setEnabled( false );
				btn_resolve.setEnabled( false );
				field_letter.setEnabled( false );
			}

			/**
			 * Validations for the secret word introduces for player 1
			 * 
			 *   - min len 3 letters
			 *
			 * @return     True if valid play player 1, False otherwise.
			 */
			private boolean isValidPlayPlayer1() {

				String word_player1 = field_word.getText();
				int len = word_player1.length();

				if ( len == 0 ) {
					JOptionPane.showMessageDialog(
						null, "Introduce una palabra."
					);

					return false;
				}

				if ( len < 3 ) {
					JOptionPane.showMessageDialog(
						null, "Palabra debe tener un mínimo de tres caracteres."
					);

					return false;
				}


				return true;
			}

			private boolean isValidPlayPlayer2() {
                            

				return true;
			}

			/**
			 * Resets the counters
			 * 
			 */
			private void resetCounters() {
				Trace.ln( "LayoutComposer / resetCounters()" );

				hits_valid = 0;
				hits       = 0;
			}

		} //class

		private class GameLoader {

			/**
			 * Aux.
			 * Fills the array of images
			 * 
			 */
			public void setImgs() {

				int n;
				//String path = "img/foto";
				String path = "foto";
				

				for ( int i = 0; i < n_imgs; i++ ) {

					n	 = i + 1;
					path = path + n + ".jpg";

					try {
						imgs[ i ] = new ImageIcon(
										getClass().getResource( path )
									);
					} catch( Exception e ) {
						
						System.out.println( "Error: " + e.toString( ));
					}
				}
			}

		} //class
		
		/**
		 * Class for GUI
		 * 
		 */
		private class GUI {
			
			public void loadImg() {

				btn_img.setIcon( imgs[ hits ] );
			}

		} //class
		
} //class
