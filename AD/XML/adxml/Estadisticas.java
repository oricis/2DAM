/**
 * @file: Estadisticas.java
 * @info: Ficheros XML - Práctica 1. Ejercicio 1
 * 
 */
package adxml;

//imports
import java.io.IOException;
import org.w3c.dom.*; 
import javax.xml.parsers.*; 
//import java.io.*;

/**
 * Class for ...
 * 
 */
public class Estadisticas {

    /**********************************/
    /*** Properties declaration *******/
        
		private final String xml_path 	   = AdPaths.XML_FILES + "puntuaciones.xml";

		private DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		private Document doc;
		private String node_name;


    /**********************************/
    /*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 * @throws 	java.io.IOException
		 */
		public Estadisticas() throws IOException {

			try {
				DocumentBuilder builder = dbf.newDocumentBuilder();
				doc = builder.parse( 
					new java.io.File( xml_path )
				);

				// recupera el primer node
				//leerNodo( doc.getFirstChild( ));

				// recupera el elemento raíz
				readNode( doc.getDocumentElement( ));

			} catch ( Exception e ) {
				e.printStackTrace();
			}

		} // main

		/**
		 * Reads and shows info about a xml node
		 *
		 * @param 	node  The node
		 */
		public void readNode( Node node ) throws IOException {
			//Trace.node( node );

			showPlayerStadistics( node );

			Node actual_node;
			NodeList childrems_list = node.getChildNodes(); 
			int num = childrems_list.getLength();
			
			for ( int i = 0; i < num; i++ ) {

				actual_node = childrems_list.item( i ); 
				readNode( actual_node );
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

			NodeList childrems_list = node.getChildNodes(); 
			Node node_hijo = childrems_list.item( 0 );
			
			return node_hijo.getNodeValue();
		}

		/**
		 * Shows the player stadistics
		 *
		 * @param      node  The node
		 * @throws     java.io.IOException
		 */
		private void showPlayerStadistics( Node node ) throws IOException {

			node_name = node.getNodeName();


			if ( node_name.equals( "nombre_usuario" ))
				Trace.ln( "Usuario: " + getNodeValue( node ));

			if ( node_name.equals( "horas_jugadas" ))
				Trace.ln( "Horas jugadas: " + getNodeValue( node ));

			if ( node_name.equals( "nivel" ))
				Trace.ln( "Nivel: " + getNodeValue( node ));

			if ( node_name.equals( "puntuacion" )) {
				Trace.ln( "Puntuación: " + getNodeValue( node ));
				Trace.ln( "--------------\n" );
			}
		}
} // class