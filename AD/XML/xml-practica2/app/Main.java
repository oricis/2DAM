/**
 * @file: Main.java
 * @info: Practica 2 - XML
 * 	Lectura datos de un fichero XML. 
 * 	Se crea un array de jugadores que se serializa a XML
 * 	
 * @utor: Moisés Alcocer, 2017
 */
package app;

//imports
import app.config.AdPaths;
import app.helpers.Inputs;
import app.helpers.Trace;
import app.helpers.Validations;


import java.io.IOException;
import java.util.List;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


/**
 *
 * @author orici
 */
public class Main {

		private static Jugador player = new Jugador();
		private static List<Jugador> lista;


		/**
		 * Main method
		 *
		 * @param	  args  The arguments
		 */
		public static void main( String[] args ) {
			
			String xml_path  = AdPaths.XML_FILES + "puntuaciones.xml";

			run( xml_path );
		}

		/**
		 * Adds new players to the list
		 * 
		 */
		private static void createPlayers() {

			while( Inputs.confirm( "¿Añadir jugador?" )) {

				player = new Jugador();

				player.setNombre( 
					Inputs.getStr( "¿Nombre?" )
				);
				player.setHorasJugadas( 
					Inputs.getInt( "¿Horas de juego?" )
				);
				player.setNivel( 
					Inputs.getInt( "¿Nivel?" )
				);
				player.setPuntuacion( 
					Inputs.getInt( "¿Puntuación?" )
				);

				//Añade el jugador a la lista
				lista.add( player );
			}
		}

		/**
		 * Runs the program
		 * 
		 * @param	file_path
		 */
		private static void run( String file_path ) {
			Trace.ln( "Main / run()" );

			//Determines if the file exists
			if ( Validations.existFile( file_path )) {

				//Obtiene la lista de jugadores
				processXmlFile( file_path );
				test();

				//Introduce nuevos jugadores
				createPlayers();

				String path = AdPaths.XML_FILES + "players.xml";

				
				//Serializes content to xml
				Trace.ln( "Serializando... \n" );
				Serialize.make( lista, path );

				
				//Deserializes xml
				Trace.ln( "Deserializando... \n" );
				lista = Serialize.unmake( path );
				test();

			} else
				System.out.println( "El fichero NO existe." );
		}
				
		/**
		 * Process xml file and process the data
		 *
		 * @param	file_path
		 */
		private static void processXmlFile( String file_path ) {
			//Trace.ln( "Ej2.Main / showData()" );
			
			try {
				GestionContenido gc  = new GestionContenido();
				
				XMLReader xml_reader = XMLReaderFactory.createXMLReader();
				InputSource xml_file = new InputSource( file_path );
				xml_reader.setContentHandler( gc ); //void setContentHandler( ContentHandler handler )
				xml_reader.parse( xml_file );

				//Carga lista jugadores desde XML en ArrayList
				lista = GestionContenido.getPlayers();
				//test();

			} catch( IOException | SAXException e ) {
				System.out.println( "Err ---> " + e.toString( ));
			}
		}

		/**
		 * Iterates the ArrayList and shows players´ names
		 *
		 */
		private static void test() {
			Trace.ln( "Main / test()" );

			int size = lista.size();
			Trace.ln( "Número jugadores: " + size );

			for ( int x = 0; x < size; x++ ) {
				

				player = lista.get( x );

				System.out.println( player.getNombre( ));
			}

			Trace.ln( "---------------------- \n" );
		}
		
} //class
