/**
 * @file: Main.java
 * @info: main file - XML Ejercicio 2
 * 
 * @utor: Moisés Alcocer, 2016
 */
package ej2;

//imports
import helpers.Inputs;
import helpers.Trace;
import helpers.Validations;

import java.io.IOException;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


/**
 * Main class
 * 
 */
public class Main {

	/**********************************/
	/*** Properties declaration *******/

		private static String file_path;
	

	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Main method
		 * 
		 * @param 	args the command line arguments
		 */
		public static void main( String[] args ) {
			
			run(
				AdPaths.XML_FILES + Inputs.getFileName() + ".xml"
			);
		}

		/**
		 * Runs the program
		 * 
		 * @param	file_path
		 */
		private static void run( String file_path ) {
			//Trace.ln( "Ej2.Main / run()" );
			//Trace.ln( "Analizando fichero " + file_path + "...\n" );

			//Determines if the file exists
			if ( Validations.existFile( file_path )) {

				showData( file_path );


			} else
				System.out.println( "El fichero NO existe." );
		}

		/**
		 * Shows the data in the xml file
		 *
		 * @param	file_path
		 */
		private static void showData( String file_path ) {
			//Trace.ln( "Ej2.Main / showData()" );
			
			try {
				GestionContenido gc  = new GestionContenido();
				
				XMLReader xml_reader = XMLReaderFactory.createXMLReader();
				InputSource xml_file = new InputSource( file_path );
				xml_reader.setContentHandler( gc ); //void setContentHandler( ContentHandler handler )
				xml_reader.parse( xml_file );

			} catch( IOException | SAXException e ) {
				System.out.println( "Err ---> " + e.toString( ));
			}
		}
		
} //class
