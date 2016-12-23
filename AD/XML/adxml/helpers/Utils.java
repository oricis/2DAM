/**
 * @file: Utils.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2016
 */
package adxml.helpers;

//imports
import java.io.*;


/**
 * Class with utils
 * 
 */
public class Utils {

	/**********************************/
	/*** Properties declaration *******/

	
	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Replaces whitespaces from string
		 *
		 * @param      str                  The string
		 * @param      char_to_fill_spaces  The character to fill spaces
		 * @return     str
		 */
		public static String replaceWhitespaces( String str, char char_to_fill_spaces ) {
			
			return str.replace( ' ', char_to_fill_spaces );
		}

				/**
		 * Gets string with content from a file
		 *
		 * @param 	file_path
		 * @return 	string
		 */
		public static String getStrContent( String file_path ) {
		
			String str;
			String res = "";

			try {
				BufferedReader br = new BufferedReader( new FileReader( file_path ));

				while (( str = br.readLine( )) != null ) {

					res = res + str;
				}
				br.close();

			} catch( FileNotFoundException e ) {
				System.out.println( "Error no encontrado: " + file_path );
				System.out.println( "---> " + e.toString( ));

			} catch( IOException e ) {
				System.out.println( "Error obteniendo contenido de: " + file_path );
				System.out.println( "---> " + e.toString( ));
			}


			return res;
		}

		/**
		 * Writes a string into a file
		 *
		 * @param file_path
		 * @param content
		 */
		public static void writeFile( String file_path, String content ) {
		
			try {
				BufferedWriter bw = new BufferedWriter( 
					new FileWriter(
						new File( file_path )
					)
				);

				bw.write( content );
				bw.close();

			} catch( IOException e ) {
				System.out.println( "Error escribiendo contenido en: " + file_path );
				System.out.println( "---> " + e.toString( ));
			}
		}

} //class
