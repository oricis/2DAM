/**
 * @file: Level.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2016
 */
package adxml;

//imports
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

/**
 * Class for traces
 * 
 */
public class Level {

    /**********************************/
    /*** Properties declaration *******/
        
		private final String xml_path 	   = AdPaths.XML_FILES + "puntuaciones.xml";

		private DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		private Document doc;
		private String node_name;
		private String player_name;
		private boolean flag = false;


    /**********************************/
    /*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 * @throws 	java.io.IOException
		 */
		public Level() throws IOException {

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
			for ( int i = 0; i < 1; i++ ) {

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

		/**
		 * Gets the node value
		 * 
		 * @param 	node
		 * @return 
		 * @throws 	java.io.IOException
		 */
		public String getNodeValue( Node node ) throws IOException {

			//NodeList childrems_list = node.getChildNodes();
			//Node child_node = childrems_list.item( 0 );
			
			//Las dos líneas anteriores equivalen a:
			Node child_node = node.getFirstChild();
			
			return ( child_node != null)
				? child_node.getNodeValue()
				: null;
		}

		/**
		 * Ups the level to the player
		 *
		 * @param 	node  The node
		 */
		private void writeXmlFile() throws 
    		TransformerConfigurationException, 
    		TransformerException 
    	{

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans     = tf.newTransformer();
			DOMSource source      = new DOMSource( doc );
			StreamResult res      = new StreamResult( new File( xml_path ));

			trans.transform( source, res );
		}

} // class
