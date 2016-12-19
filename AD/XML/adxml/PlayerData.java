/**
 * @file: PlayerData.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2016
 */
package adxml;

//imports
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

import adxml.helpers.Trace;


/**
 * Class for handle data in nodes of players
 * 
 */
public class PlayerData extends XmlDom {

	/**********************************/
	/*** Properties declaration *******/

		private int value;
		private String field_name;
		private String player_name;

	
	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 * @throws java.io.IOException
		 */
		public PlayerData() throws IOException {}
		
		/**
		 * Sets properties and seeks for a player
		 *
		 * @param	player_name
		 * @param	field_name
		 * @param	value
		 * @throws 	java.io.IOException
		 * @throws 	javax.xml.transform.TransformerException
		 */
		public void up( String player_name, String field_name, int value )
			throws IOException, TransformerException {

			Trace.ln( "PlayerData / up()" );
			Trace.ln( "Node name: " + field_name + " / Value: " + value );

			this.value 		 = value;
			this.field_name  = field_name;
			this.player_name = player_name;


			// recupera lista nodos -> "usuario"
			NodeList user_list = doc.getElementsByTagName( "usuario" );
			
			int num = user_list.getLength();
			Trace.ln( "Número nodos \"usuario\": " + num );

			if ( num > 0 && new Players().hasIn( player_name )) {
				upFieldValue( user_list, num );

			} else
				System.out.println( "Jugador \"" + player_name + "\" NO existe." );
		}

		/**
		 * Ups a field for a player
		 *
		 * @param      user_list  The user list
		 * @param      num        The number
		 */
		private void upFieldValue( NodeList user_list, int num ) 
			throws IOException, TransformerException {

			Node user_node = getNodeForUser( user_list, this.player_name );
			Element user   = (Element) user_node;

			Node temp_node = user.getElementsByTagName( field_name ).item( 0 );

			//Gets the value stored for the field
			String str 	   = getNodeValue( temp_node );
			int xxx 	   = Integer.parseInt( str );
			//Trace.ln( "Valor: " + xxx );

			//Adds new value to the old value and stores in the node
			xxx = xxx + value;
			temp_node.setTextContent( "" + xxx );
			//Trace.ln( "Nuevo valor: " + temp_node.getTextContent( ));
			
			// write the content into xml file
			writeXmlFile();
		}
		
} //class
