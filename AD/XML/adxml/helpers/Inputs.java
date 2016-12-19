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
		public static boolean getConfirmation( String str ) {
			System.out.println( "¿Confirmar " + str + "? si / no" );

			Scanner s    = new Scanner( System.in );
			String input = s.nextLine();
			//Trace.ln( "Has seleccionado: " + input );

			if ( input.equals( "si" ))
				return true;

			if ( input.equals( "no" ))
				return false;


			getConfirmation( str );
				return false;
		}
		/**
		 * Ask for a number to the user
		 *
		 * @param      min   The minimum
		 * @param      max   The maximum
		 * @param      msg   The message to show
		 */
		public static int getNumberInRange( int min, int max, String msg ) {

			System.out.println( msg );
			int value = 0;

			//Ask for a number
			Scanner s 	 = new Scanner( System.in );
			String input = s.nextLine();
			Trace.ln( "Valor introducido: " + input );

			try {
				value = Integer.parseInt( input );

			} catch( Exception e ) {

				System.out.println( "Selección entre " + min + " y " + max );
				getNumberInRange( min, max, msg );
			}

			//Validates the range
			if ( value < min || value > max ) {
				System.out.println( "Selección entre " + min + " y " + max );
				getNumberInRange( min, max, msg );
			}

			return value;
		}

} // class
