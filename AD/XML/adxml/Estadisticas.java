/**
 * @file: Estadisticas.java
 * @info: Ficheros XML - Práctica 1. Ejercicio 1
 * 
 */
package adxml;

//imports
import java.io.IOException;
import org.w3c.dom.*; 

/**
 * 1
 * Class for show statistics about the players
 * 
 */
public class Estadisticas extends XmlDom {

    /**********************************/
    /*** Properties declaration *******/
        
		private String node_name;


    /**********************************/
    /*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 * @throws 	java.io.IOException
		 */
		public Estadisticas() throws IOException {

			readNode( doc.getDocumentElement( ));
		} 

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