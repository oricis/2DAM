/**
 * @file: Main.java
 * @info: main file - XML Ejercicio 1
 * 
 * @utor: Moisés Alcocer, 2016
 */
package ej1;

import java.io.IOException;
import javax.xml.transform.TransformerException;

import helpers.Inputs;
import helpers.Trace;

/**
 * Main class
 * 
 */
public class Main {

	/**********************************/
	/*** Properties declaration *******/

		private static int option;
		private static int value;
		private static String player;

		private static String options = ""
			+ "Escriba el número de opción seleccionada: "
			+ "\n   1. Ver estadísticas jugadores"
			+ "\n   2. Subir nivel a jugador"
			+ "\n   3. Añadir puntos a jugador"
			+ "\n   4. Eliminar jugador"
			+ "\n   5. ¿Existe el jugador?"
			+ "\n   6. Incrementar valor a un jugador"
			+ "\n   7. Seleccionar fichero a cargar"
			+ "\n   8. Crear fichero XML";
	

	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Main method
		 * 
		 * @param 	args the command line arguments
		 * @throws 	java.io.IOException
		 * @throws 	javax.xml.transform.TransformerException
		 */
		public static void main( String[] args ) 
                        throws IOException, TransformerException {
			
			//new PruebaLeerNodosElementos();
			
			//Selects the number of an option
			value = Inputs.getNumberInRange( 1, 8, options );

			//Handles the selected option
			handleOptions( value );
		}

		/**
		 * Selects an options and run the program
		 * 
		 */
		private static void handleOptions( int option ) 
			throws IOException, TransformerException {
				
			System.out.println( "Opción seleccionada: " + option );


			//Show statistiques
			if ( option == 1 ) {
				new Estadisticas();
				
				System.exit( 0 );
			}


			if ( option != 7 && option != 8 )
				player = Inputs.getPlayerName(); //Selects a player


			//Ups a level
			if ( option == 2 ) {
				new Level().up( player );	//Ups a level to this player
				Trace.ln( "Actualizado nivel de \"" + player + "\"\n" );
				
				System.exit( 0 );
			}


			//Adds value
			if ( option == 3 ) {

				value = Inputs.getNumberInRange( 1, 10000, "Escriba puntuación a añadir: " );

				new Score().add( player, value );	//Adds value to this player
				Trace.ln( "Actualizada puntuación de \"" + player + "\"\n" );
			
				System.exit( 0 );
			}
				

			//Deletes a player
			if ( option == 4 && Inputs.confirm( "¿Confirmar borrado?" )) {

				new Players().delete( player );
				Trace.ln( "Eliminado jugador \"" + player + "\"\n" );
				
				System.exit( 0 );
			}


			//Shows if a player exists
			if ( option == 5 ) {
				String msg = "Jugador \"" + player + "\"";
				
				msg = ( new Players().hasIn( player ))
					? msg + " existe."
					: msg + " NO existe.";

				System.out.println( msg );
				System.exit( 0 );
			}


			if ( option == 6 ) {

				new PlayerData().up( 
					player, 
					selectField(), 
					Inputs.getNumberInRange( 1, 50000, "¿Cantidad a añadir?" )
				);
			}


			if ( option == 7 ) {

				new OpenFile( 
					Inputs.getFileName()
				);
			}

			if ( option == 8 ) {

				new CreateXmlFile();
			}
		}

		/**
		 * Selects a field
		 * 
		 */
		private static String selectField() {
			options = ""
				+ "Selecciona número del campo a incrementar:"
				+ "\n   1. Horas jugadas"
				+ "\n   2. Nivel"
				+ "\n   3. Puntuación";

			int res = Inputs.getNumberInRange( 1, 3, options );

			if ( res == 1 ) 
				return "horas_jugadas";

			if ( res == 2 ) 
				return "nivel";

			return "puntuacion";
		}

} //class
