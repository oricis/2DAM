/**
 * @file: XmlDom.java
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
 * Class with common methods
 * 
 */
public class XmlDom {

	/**********************************/
	/*** Properties declaration *******/

		protected final String xml_path 	 = AdPaths.XML_FILES + "puntuaciones.xml";

		protected DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		protected Document doc;

	
	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 * @throws java.io.IOException
		 */
		public XmlDom() throws IOException {

			try {
				DocumentBuilder builder = dbf.newDocumentBuilder();
				doc = builder.parse( 
					new java.io.File( xml_path )
				);

			} catch ( Exception e ) {
				e.printStackTrace();
			}
		}

		/**
		 * Gets the node value
		 * 
		 * @param 	node
		 * @return 
		 * @throws 	java.io.IOException
		 */
		protected String getNodeValue( Node node ) throws IOException {

			//NodeList childrems_list = node.getChildNodes();
			//Node child_node = childrems_list.item( 0 );
			
			//Las dos líneas anteriores equivalen a:
			Node child_node = node.getFirstChild();
			
			return ( child_node != null)
				? child_node.getNodeValue()
				: null;
		}

		/**
		 * Gets the node for an user (player)
		 * 
		 * @param 	user_list
		 * @param 	player_name
		 * @return 	a node of type user
		 * @throws 	java.io.IOException
		 */
		protected Node getNodeForUser( 
			NodeList user_list, 
			String player_name 
		) throws IOException {

			Element user;
			int num = user_list.getLength();
			Node temp_node;
			Node user_node;
			String str;
			
			//Iterate the nodes of type "usuario" and returs the seeked user's node
			for ( int i = 0; i < num; i++ ) {

				user_node = user_list.item( i ); 
				user = (Element) user_node;

				temp_node = user.getElementsByTagName( "nombre_usuario" ).item( 0 );
				//Trace.node( temp_node );

				str = getNodeValue( temp_node );
				//Trace.ln( "---> Usuario: " + str );


				if ( str.equals( player_name ))
					return temp_node.getParentNode();
			}

			return null;
		}

		/**
		 * Ups the score to the player
		 *
		 * @param 	node  The node
		 */
		protected void writeXmlFile() throws 
			TransformerConfigurationException, 
			TransformerException 
		{

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans	  = tf.newTransformer();
			DOMSource source	  = new DOMSource( doc );
			StreamResult res	  = new StreamResult( new File( xml_path ));

			trans.transform( source, res );
		}
		
} //class
