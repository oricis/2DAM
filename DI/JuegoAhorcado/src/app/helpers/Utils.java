/**
 * @file: Utils.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.helpers;

//imports


/**
 * This class ...
 * 
 */
public class Utils {

	/**********************************/
	/*** Properties declaration *******/



		
	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Puts a new letter in some positions of a word
		 *
		 * @param	  c  		The letter for changes
		 * @param	  str		The string to change
		 * @param	  pos		The positions to change
		 * @return	 str		The new string
		 */
		public static String changeLettersIn( char c, String str, int[] pos ) {

			//Sets the numbers of positions to change
			int len = pos.length;

			for ( int i = 0; i < len; i++ ) {

				str = replaceLetterIn( c, str, pos[ i ] );
			}


			return str;
		}

		/**
		 * Aux.
		 * Puts a letter in a position of the word
		 *
		 * @param	  c  		The letter to change
		 * @param	  str		The string to change
		 * @param	  pos		The position to change
		 * @return	 str		The new string
		 */
		private static String replaceLetterIn( char c, String str, int pos ) {
			
			char[] res = str.toCharArray();
			res[ pos ] = c;

						
			return String.valueOf( res );
		}

		/**
		 * Gets the bar string.
		 *
		 * @param	len		The length of final string
		 * @return	str		The bar string
		 */
		public static String getBarString( int len ) {

			String str = "";

			for ( int i = 0; i < len; i++ ) {

				str = str + "-";
			}


			return str;
		}
		
		/**
		 * Checks if a letter is in the string
		 *
		 * @param c
		 * @param str
		 * @return
		 */
		public static int[] getPositionsInStr( char c, String str ) {

			int count	   = 0;
			int str_len	 = str.length();
			int[] positions = null;
			
			
			//Obtiene num posiciones del array
			for ( int i = 0; i < str_len; i++ ) {

				if ( str.charAt( i ) == c )
					count++; 
			}
			
			//Rellena y develve array con posiciones
			if ( count > 0 ) {
				positions = new  int[ count ];
				count = 0;
				
				for ( int i = 0; i < str_len; i++ ) {

					if ( str.charAt( i ) == c ) {

						positions[ count ] = i;
						count++; 
					}
				}
			}

			 
			return positions;
		}


} //class