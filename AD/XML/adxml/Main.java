/**
 * @file: Main.java
 * @info: main file
 * 
 * @utor: Moisés Alcocer, 2016
 */
package adxml;

import java.io.IOException;
import java.util.Scanner;
import javax.xml.transform.TransformerException;

/**
 * Main class
 * 
 */
public class Main {

	/**********************************/
	/*** Properties declaration *******/

		private static int option;
		private static int score;
		private static Scanner s;
		private static String input = "";
		private static String player;
	

	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Main method
		 * 
		 * @param args the command line arguments
		 */
		public static void main( String[] args ) throws IOException, TransformerException {
			
			selectOption();

			//new PruebaLeerNodosElementos();
		}
		
		/**
		 * Selects an options and run the program
		 * 
		 */
		private static void selectOption() {

			showOptions();
			s     = new Scanner( System.in );
			input = s.nextLine();
			System.out.println ( "Opción seleccionada: " + input );

			try {

				option = Integer.parseInt( input );
				
				//Show statistiques
				if ( option == 1 )
					new Estadisticas();

				else {
					//Selects a player
					selectPlayer();

					//Ups a level
					if ( option == 2 ) {
						new Level().up( player );	//Ups a level to this player
						Trace.ln( "Actualizado nivel de \"" + player + "\"\n" );

					//Adds score
					} else if ( option == 3 ) {

						selectScore();
						new Score().add( player, score );	//Adds score to this player
						Trace.ln( "Actualizada puntuación de \"" + player + "\"\n" );
					}
				}

			} catch( Exception e ) {

				System.out.println( "Selección incorrecta" );
				selectOption();
			}
		}

		/**
		 * Selects a player
		 * 
		 */
		private static void selectPlayer() {
			System.out.println( "Escriba el nombre del jugador: " );

			s     = new Scanner( System.in );
			player = s.nextLine();
			Trace.ln( "Jugador seleccionado: " + input );
		}

		/**
		 * Selects a score
		 * 
		 */
		private static void selectScore() {
			System.out.println( "Escriba puntuación a añadir: " );

			s     = new Scanner( System.in );
			input = s.nextLine();
			Trace.ln( "Puntuación a añadir: " + input );

			try {
				score = Integer.parseInt( input );

			} catch( Exception e ) {

				System.out.println( "Selección score incorrecta" );
				selectScore();
			}
		}

		/**
		 * Shows the options list
		 * 
		 */
		private static void showOptions() {

			System.out.println( "Escriba el número de opción seleccionada: " );
			System.out.println( "   1. Ver estadisticas jugadores" );
			System.out.println( "   2. Subir nivel a jugador" );
			System.out.println( "   3. Añadir puntos a jugador" );
		}

} //class
