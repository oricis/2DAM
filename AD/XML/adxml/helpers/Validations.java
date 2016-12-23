/**
 * @file: Validations.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2016
 */
package adxml.helpers;

//imports

import java.io.File;



/**
 * Class for validations
 * 
 */
public class Validations {

	/**********************************/
	/*** Properties declaration *******/


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Determines if it has file
		 *
		 * @param	file_path
		 * @return	True if has file, False otherwise.
		 */
		public static boolean existFile( String file_path ) {

			File f = new File( file_path );

			return f.isFile();
		}

} // class
