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

import adxml.helpers.Inputs;
import adxml.helpers.Trace;
import adxml.helpers.Validations;
import adxml.helpers.XmlCreator;
import java.io.BufferedWriter;
import java.io.FileWriter;


/**
 * Class with common methods
 * 
 */
public class XmlDom {

	/**********************************/
	/*** Properties declaration *******/

		protected String xml_path = AdPaths.XML_FILES + "puntuaciones.xml";

		protected DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		protected Document doc;
		private String root;
		
	
	/**********************************/
	/*** Methods declaration **********/
	
		/**
		 * Construct
		 * 
		 * @throws java.io.IOException
		 */
		public XmlDom() throws IOException {
			createDoc();

		}

		/**
		 * Construct
		 * 
		 * @param file_path
		 * @throws java.io.IOException
		 */
		public XmlDom( String file_path ) throws IOException {
			this.xml_path = file_path;

			//The file exists
			if ( Validations.existFile( file_path )) {
				createDoc();

			//The file NO exists
			} else {
				System.out.println( "@@@ El fichero: " + file_path + " NO existe." );
				System.out.println( "¿Desea crearlo? si / no" );

				//User wants to create the xml file
				if ( Inputs.getConfirmation( "" )) {
					Trace.ln( "Creando fichero: " + this.xml_path );
										
										
					//Creates the xml file
					if ( createFile( )) {
						System.out.println( "El fichero se ha creado" );

					} else {
						System.out.println( "No se pudo crear el fichero" );
						System.exit( 0 );
					}
					

					//Creates a doc
					createDoc();

				} else
					System.exit( 0 );
			}
		}


	/*** Public methods ***************/

	/*** Protected methods ************/
	
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
	
	
	/*** Private methods **************/

		/**
		 * Creates a document
		 *
		 */
		private void createDoc() {

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
		 * Creates a xml file in disk
		 *
		 * @return	Returns true if the file was created, false otherwise
		 */
		private boolean createFile() {
			Trace.ln( "XmlDom / createFile()" );
			System.out.println( "Creando fichero..." );
			
			String root    = Inputs.getRootStr();
			String title   = Inputs.getTitleStr();
			this.root = root;

			try {
				File f = new File( this.xml_path );
				BufferedWriter bw = new BufferedWriter( new FileWriter( f ));
				
				bw.write(  XmlCreator.getFileContent( root, title ));
				bw.close();

				System.out.println( "Creando nodos internos..." );
				XmlCreator.addContentToBaseNode( this.xml_path, this.root );

				return true;

			} catch ( IOException e ) {}
			
			
			return false;
		}

} //class
