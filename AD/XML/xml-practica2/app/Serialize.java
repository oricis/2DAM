/**
 * @file: Serialize.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2017
 */
package app;

//imports
import app.helpers.Trace;

import com.thoughtworks.xstream.XStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;




/**
 * Class for serializations
 * 
 */
public class Serialize {

	/**********************************/
	/*** Properties declaration *******/


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Does serialization of a list of objects to a xml file
		 *
		 * @param list_x
		 * @param xml_path
		 */
		public static void make( List<Jugador> list_x, String xml_path ) {
			Trace.ln( "Serialize / make()" );
			
			try {

				//Creates a XStream  
				XStream flujox = new XStream();

				// Parámetros de serialización 
				// Cambiar nombre de las etiquetas XML generadas por la clase  
				flujox.alias( "lista-jugadores", List.class ); 
				flujox.alias( "jugador", Jugador.class ); 
				// Para quitar la etiqueta <lista> generada por la lista 
				// atributo de la clase Jugadores  
				//flujox.addImplicitCollection( Jugadores.class, "lista" ); 
				
				//Stores the XStream into a file
				flujox.toXML(  
					list_x, new FileOutputStream( xml_path ) 
				); 
				//or into a String
				String str = flujox.toXML( list_x );

				//Shows the result
				System.out.println( "File created with: \n" + str );

			} catch ( FileNotFoundException e ) { 
				System.out.println( "---> " + e.toString( ));
			} 
		}

		/**
		 * Does deserialization of a xml file to list of objects
		 *
		 * @param xml_path
		 * @return 
		 */
		public static List<Jugador> unmake( String xml_path ) {
			Trace.ln( "Serialize / unmake()" );

			// Ya tenemos el objeto completo, ahora lo vamos a serializar	
			try {
				
				// Definimos un XStream	
				XStream flujox = new XStream(); 
				
				// Parámetros de serialización 
				// Cambiar nombre de las etiquetas XML generadas por la clase  
				flujox.alias( "lista-jugadores", List.class ); 
				flujox.alias( "jugador", Jugador.class ); 
				
				List<Jugador> lista = (List<Jugador>) flujox.fromXML(
					new FileInputStream( xml_path )
				);

				return lista;
				

			} catch ( IOException e ) { 
				System.out.println( "Error ---> " + e.toString( )); 
			}


			return null;
		}

} // class
