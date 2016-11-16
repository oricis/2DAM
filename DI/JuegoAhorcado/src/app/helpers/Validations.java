/**
 * @file: Validations.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.helpers;

//imports

import javax.swing.JOptionPane;



/**
 * This class ...
 * 
 */
public class Validations {

	/**********************************/
	/*** Properties declaration *******/

		private static String letters = "áéíóúüñabcdefghijklmnopqrstuvwxyzÁÉÍÓÚÜÑABCDEFGHIJKLMNOPQRSTUVWXYZ";

		
	/**********************************/
	/*** Methods declaration **********/

        /**
         * Checks if a String is a valid letter
         *
         * @param      c             The string to check
         * @param      arr_err_msgs  The array with error msgs for validations that failed
         * @return     True if letter, False otherwise.
         */
		public static boolean isLetter( String c, String[] arr_err_msgs ) {
            System.out.println( "Validations / isLetter() -> " + c );

			int len	 = c.length();
			

			//Err -> str is empty
			if ( len == 0 ) {
				JOptionPane.showMessageDialog(
					null, arr_err_msgs[ 0 ]
				);

				return false;
			}

			//Err -> str is too large
			if ( len > 1 ) {
				JOptionPane.showMessageDialog(
					null, arr_err_msgs[ 1 ]
				);

				return false;
			}

			//Err -> str content a invalid char
			if ( ! isLetterInStr( c.charAt( 0 ), letters )) {
				JOptionPane.showMessageDialog(
					null, arr_err_msgs[ 2 ]
				);

				return false;
			}

			//The validations have passed
			return true;
		}

		/**
		 * Checks if a letter is in the string
		 *
		 * @param c
		 * @param str
		 * @return 
		 */
		public static boolean isLetterInStr( char c, String str ) {

				int count = 0;
				String x = Character.toString( c );

				while ( str.contains( x )) {

					str = str.substring(
						str.indexOf( x ) + x.length(), 
						str.length()
					);

					count++; 
				}


				return ( count > 0 );
		}

} //class