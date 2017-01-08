/**
 * @file: Players.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2016
 */
package ej1;

//imports
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

import helpers.Trace;


/**
 * 
 * Class for handle the players
 * 
 */
public class Players extends XmlDom {

	/**********************************/
	/*** Properties declaration *******/

	
	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 * @throws java.io.IOException
		 */
		public Players() throws IOException {}
		
		/**
		 * Deletes a player
		 *
		 * @param	player_name
		 * @throws java.io.IOException
		 * @throws javax.xml.transform.TransformerException
		 */
		public void delete( String player_name )
			throws IOException, TransformerException {
			Trace.ln( "Players / delete() -> player name: " + player_name );

			NodeList users_names;
			String str;

			// recupera lista nodos -> "usuario"
			NodeList user_list = doc.getElementsByTagName( "usuario" );
			
			
			int n_users = user_list.getLength();
			Trace.ln( "Número nodos \"usuario\": " + n_users );

			//Iterate the nodes of type "usuario"
			for ( int i = 0; i < n_users; i++ ) {
				//Trace.ln( "Iterate the nodes of type usuario" );
				Node user_node = user_list.item( i );
				Element e = (Element) user_node;
				//Trace.node( user_node );
				users_names = e.getElementsByTagName( "nombre_usuario" );
				int n_names = users_names.getLength();

				for ( int j = 0; j < n_names; j++ ) {
					Node user_name = users_names.item( j );
					str = user_name.getTextContent();
					//Trace.ln( str );

					if ( str.equals( player_name )) {
						//Trace.ln( " ---> Encontrado: " + player_name );
						Trace.ln( "@@@ Eliminando jugador..." );

						//Removes the node with the user
						user_node.getParentNode().removeChild( user_node );
						
						// write the content into xml file
						writeXmlFile();

						//Finishs loops (warning: break throws Exception in Main class)
						j = n_names;
						i = n_users;
					}
				} //for
			} //for
		}

		/**
		 * Seeks for a player
		 * 
		 * @param 	player_name
		 * @return 	boolean
		 * @throws 	java.io.IOException
		 * @throws 	javax.xml.transform.TransformerException
		 */
		public boolean hasIn( String player_name ) 
			throws IOException, TransformerException {

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


				if ( str.equals( player_name ))
					return true;
			}

			return false;
		}
		
} //class
