/**
 * @file: Level.java
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
public class Level extends XmlDom {

	/**********************************/
	/*** Properties declaration *******/
		
		private String player_name;


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 * @throws 	java.io.IOException
		 */
		public Level() throws IOException {} 

		/**
		 * Ups the level to the player
		 *
		 * @param	player_name
		 */
		public void up( String player_name ) throws IOException, TransformerException {
			this.player_name = player_name;

			int level;
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
					//Trace.ln( "@@@ Subiendo nivel a jugador: " + player_name );

					temp_node = user.getElementsByTagName( "nivel" ).item( 0 );
					str = getNodeValue( temp_node );
					level = Integer.parseInt( str );
					//Trace.ln( "Nivel: " + level );

					level = level + 1;
					temp_node.setTextContent( "" + level );
					//Trace.ln( "Nuevo nivel: " + temp_node.getTextContent( ));
					
					// write the content into xml file
					writeXmlFile();

					break;
				}
			}
		}

} // class
