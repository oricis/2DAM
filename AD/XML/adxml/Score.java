/**
 * @file: Score.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2016
 */
package adxml;

//imports
import java.io.IOException;
import javax.xml.transform.*;
import org.w3c.dom.*;

/**
 * Class for traces
 * 
 */
public class Score extends XmlDom {

	/**********************************/
	/*** Properties declaration *******/


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 * @throws 	java.io.IOException
		 */
		public Score() throws IOException {} 

		/**
		 * Ups the score to the player
		 *
		 * @param	player_name
		 */
		public void add( String player_name, int score_to_add ) 
			throws IOException, TransformerException {

			int score;
			Node temp_node;
			String str;

			// recupera lista nodos -> "usuario"
			NodeList user_list = doc.getElementsByTagName( "usuario" );
			
			
			int num = user_list.getLength();
			Trace.ln( "Número nodos \"usuario\": " + num );

			Element user;
			//Iterate the nodes of type "usuario"
			for ( int i = 0; i < num; i++ ) {

				Node user_node = user_list.item( i ); 
				user = (Element) user_node;

				temp_node = user.getElementsByTagName( "nombre_usuario" ).item( 0 );
				//Trace.node( temp_node );

				str = getNodeValue( temp_node );
				//Trace.ln( "---> Usuario: " + str );


				if ( str.equals( player_name )) {
					Trace.ln( "@@@ Añadiendo " + score_to_add 
						+ " puntos a jugador: " + player_name );

					temp_node = user.getElementsByTagName( "puntuacion" ).item( 0 );
					str = getNodeValue( temp_node );
					score = Integer.parseInt( str );
					Trace.ln( "Puntuación anterior: " + score );

					score = score + score_to_add;
					temp_node.setTextContent( "" + score );
					Trace.ln( "Nueva puntuación: " + temp_node.getTextContent( ));
					
					// write the content into xml file
					writeXmlFile();

					break;

				}
			}
		}

		
} // class
