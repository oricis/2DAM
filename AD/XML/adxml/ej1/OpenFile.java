/**
 * @file: OpenFile.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2016
 */
package ej1;

//imports
import java.io.IOException;


/**
 * Class for traces
 * 
 */
public class OpenFile extends XmlDom {

	/**********************************/
	/*** Properties declaration *******/

		


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 * @param file_name
		 * @throws 	java.io.IOException
		 */
		public OpenFile( String file_name ) throws IOException {
			super( AdPaths.XML_FILES + file_name + ".xml" );
			
			//this.file_path = AdPaths.XML_FILES + file_name + ".xml";
		}

} // class
