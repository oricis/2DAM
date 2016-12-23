/**
 * WriteXMLFile.java
 * Based in example from: http://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
 *
 * @utor: Moisés Alcocer, 2016
 */

package adxml;

//imports
import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

import adxml.helpers.Inputs;
import adxml.helpers.Trace;
import adxml.helpers.Utils;


/**
 * Java class to create a XML file
 * 
 */
public class CreateXmlFile {

	private Document doc;


	/**
	 * Construct
	 * 
	 */
	public CreateXmlFile() {
		Trace.ln( "Creando fichero XML..." );
		
		String file_name = AdPaths.XML_FILES 
			+ Inputs.getStr( "¿Nombre del fichero?" ) + ".xml";

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			doc = docBuilder.newDocument();

			// root elements
			Trace.ln( "Creando nodo raiz..." );
			Element rootElement = doc.createElement(
				Utils.replaceWhitespaces(
					Inputs.getStr( "¿Cuál va a ser el nodo raiz?"), '_' 
				)
			);
			doc.appendChild( rootElement );


			// add nodes to root element
			int num = Inputs.getInt( "¿Cuántos elementos incluirás?" );
			String e_name = Utils.replaceWhitespaces(
				Inputs.getStr( "Indica nombre de los elementos: "), '_'
			);

			for ( int i = 0; i < num; i++ ) {

				addSubnodes( rootElement, e_name );
			}


			// write the content into xml file
			writeXmlFile( 
				doc, 
				file_name
			);

		} catch ( ParserConfigurationException e ) {
			e.printStackTrace();
		} 
	}

	/**
	 * Adds an attribute to the element
	 *
	 * @param	element
	 */
	private void addAttr( Element e ) {
		String attr_name  = Utils.replaceWhitespaces(
			Inputs.getStr( "¿Nombre del atributo?" ), '_'
		);
		String attr_value = Inputs.getStr( "¿Valor del atributo?" );

		Attr attr = doc.createAttribute( attr_name );
		attr.setValue( attr_value );
		e.setAttributeNode( attr );

		// shorten way
		// e.setAttribute( "id", "1" );
	}

	/**
	 * Adds childs to a first level element
	 *
	 * @param	rootElement  The root element
	 * @param	num			 The num of the child
	 */
	private void addSubnodes( Element root, int num ) {
		// element elements
		Element element = doc.createElement(
			Utils.replaceWhitespaces(
				Inputs.getStr( "¿Nombre del elemento " + num + "?" ), '_'
			)
		);
		element.appendChild( 
			doc.createTextNode(
				Inputs.getStr( "¿Texto del elemento?" )
			)
		);
		root.appendChild( element );

		// set attributes to element
		while ( Inputs.confirm( "¿Añadir un atributo?" )) {

			addAttr( element );
		}
	}

	/**
	 * Adds childs of first level to the root element
	 *
	 * @param	root		The root element
	 * @param	node_name	The name for the element
	 */
	private void addSubnodes( Element root, String node_name ) {
		// element elements
		Element element = doc.createElement( node_name );
		root.appendChild( element );

		// set attributes to element
		while ( Inputs.confirm( "¿Añadir un atributo?" )) {

			addAttr( element );
		}


		int num = Inputs.getInt( "¿Cuántos sub-elementos tiene <" + node_name + ">?" );

		for ( int i = 0; i < num; i++ ) {

			addSubnodes( element, ( i + 1 ));
		}
	}

	/**
	 * Writes a xml file
	 *
	 * @param      doc        The document
	 * @param      file_path  The file path
	 */
	private void writeXmlFile( Document doc, String file_path ) {

		try {
			
			TransformerFactory tf   = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source 		= new DOMSource( doc );
			StreamResult result 	= new StreamResult( new File( file_path ));
			
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform( source, result );
			System.out.println( "File saved!" );


		} catch ( TransformerException e ) {
			e.printStackTrace();
		}
	}

} //class