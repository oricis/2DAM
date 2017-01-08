/**
 * @file: Validations.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2016
 */
package helpers;

//imports
import java.io.File;
import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import ej2.GestionContenido;


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

		/**
		 * Determines if the file contain data
		 *
		 * @param	file_path
		 * @return	True if the file has data, False otherwise.
		 */
		/*public static boolean hasDataInFile( String file_path ) {

			try {
				GestionContenido gc  = new GestionContenido();

				XMLReader xml_reader = (XMLReader) XMLReaderFactory.createXMLReader();
				InputSource xml_file = new InputSource( file_path );
				xml_reader.setContentHandler( gc);
				xml_reader.parse( xml_file );

				if ( gc.car != "" )
					return true;


			} catch( IOException | SAXException e ) {
				System.out.println( "Err ---> " + e.toString( ));
			}
			
			return false;
		}/**/

} // class
