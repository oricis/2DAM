/**
 * @file: Inputs.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2016
 */
package adxml.helpers;

//imports

import java.util.Scanner;


/**
 * Class for handle inputs of user
 * 
 */
public class Inputs {

	/**********************************/
	/*** Properties declaration *******/


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Asks for a confirmation before an action
		 *
		 * @param	  str   -> The string to appends in the confirmation message
		 * @return	 boolean
		 */
		public static boolean confirm( String str ) {
			
			if ( ! str.equals( "" ))
				System.out.println( str + " si / no" );

			Scanner s	= new Scanner( System.in );
			String input = s.nextLine();
			//Trace.ln( "Has seleccionado: " + input );

			if ( input.equals( "si" ))
				return true;

			if ( input.equals( "no" ))
				return false;


			confirm( str );
				return false;
		}

		/**
		 * Asks for a name for a file
		 * 
		 */
		public static String getFileName() {

			return getStr( "Escribe nombre del fichero: " );
		}

		/**
		 * Ask to the user for a value of type int
		 *
		 * @param	  msg   The message to show
		 * @return	 The int
		 * @throws	 java.io.IOException
		 */
		public static int getInt( String msg ) {
			System.out.println( msg );

			int res		 = 0;
			Scanner s 	 = new Scanner( System.in );
			String input = s.nextLine();
			

			try {
				res = Integer.parseInt( input );

			} catch( Exception e ) {

				System.out.println( "Introduce un número válido." );
				getInt( msg );
			}


			return res;
		}

		/**
		 * Ask to the user for a string
		 *
		 * @param	  msg   The message to show
		 * @return	 The string
		 */
		public static String getStr( String msg ) {
			System.out.println( msg );

			Scanner s = new Scanner( System.in );
			return s.nextLine();
		}

		/**
		 * Asks for a number to the user
		 *
		 * @param	  min   The minimum
		 * @param	  max   The maximum
		 * @param	  msg   The message to show
		 */
		public static int getNumberInRange( int min, int max, String msg ) {

			System.out.println( msg );
			int value = 0;

			//Ask for a number
			Scanner s 	 = new Scanner( System.in );
			String input = s.nextLine();
			//Trace.ln( "Valor introducido: " + input );

			try {
				value = Integer.parseInt( input );

			} catch( Exception e ) {

				System.out.println( "Selección entre " + min + " y " + max );
				getNumberInRange( min, max, msg );
			}

			//Validates the range
			if ( value < min || value > max ) {
				//Trace.ln( "Selección fuera de rango" );
				System.out.println( "Selección entre " + min + " y " + max );
				getNumberInRange( min, max, msg );
			}

			return value;
		}

		/**
		 * Asks for a name of player
		 * 
		 */
		public static String getPlayerName() {

			return getStr( "¿Nombre del jugador?" );
		}

		/**
		 * Asks for a name of the root element
		 * 
		 */
		public static String getRootStr() {

			String res = getStr( "¿Cuál va a ser el elemento raiz?" );

			return Utils.replaceWhitespaces( res, '_' );
		}

		/**
		 * Asks for a title content
		 * 
		 */
		public static String getTitleStr() {

			return getStr( "Escribe un título (enter para ignorar): " );
		}

} // class
