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
		 * Asks for a confirmation before an action
		 *
		 * @param      str   -> The string to appends in the confirmation message
		 * @return     boolean
		 */
		private static boolean confirmAction( String str ) {
			System.out.println( "¿Confirmar " + str + "? si / no" );

			s     = new Scanner( System.in );
			input = s.nextLine();
			//Trace.ln( "Has seleccionado: " + input );

			if ( input.equals( "si" ))
				return true;

			if ( input.equals( "no" ))
				return false;


			confirmAction( str );
                        return false;
		}

		/**
		 * Selects an options and run the program
		 * 
		 */
		private static void selectOption() {

			showOptions();
			s     = new Scanner( System.in );
			input = s.nextLine();
			System.out.println( "Opción seleccionada: " + input );

			try {

				option = Integer.parseInt( input );
				Trace.ln( "" + 1 );

				//Show statistiques
				if ( option == 1 ) {
					new Estadisticas();
					
					System.exit( 0 );
				}

				//Selects a player
				selectPlayer();

				//Ups a level
				if ( option == 2 ) {
					new Level().up( player );	//Ups a level to this player
					Trace.ln( "Actualizado nivel de \"" + player + "\"\n" );
					
					System.exit( 0 );
				}

				//Adds score
				if ( option == 3 ) {

					selectScore();
					new Score().add( player, score );	//Adds score to this player
					Trace.ln( "Actualizada puntuación de \"" + player + "\"\n" );
				
					System.exit( 0 );
				}
					
				//Deletes a player
				if ( option == 4 && confirmAction( "borrado" )) {

					new Players().delete( player );
					Trace.ln( "Eliminado jugador \"" + player + "\"\n" );
					
					System.exit( 0 );
				}

				//Shows if a player exists
				if ( option == 5 ) {
					String msg = "Jugador \"" + player + "\"";
					
					msg = ( new Players().hasIn( player ))
						? msg + " existe."
						: msg + " NO existe.";

					System.out.println( msg );
					System.exit( 0 );
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
			Trace.ln( "Jugador seleccionado: " + player );
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
			System.out.println( "   1. Ver estadísticas jugadores" );
			System.out.println( "   2. Subir nivel a jugador" );
			System.out.println( "   3. Añadir puntos a jugador" );
			System.out.println( "   4. Eliminar jugador" );
			System.out.println( "   5. ¿Existe el jugador?" );
		}

} //class
