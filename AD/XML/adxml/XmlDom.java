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
