/**
 * @file: PruebaLeerNodosElementos.java
 *
 */
package adxml;

//imports
import java.io.IOException;
import org.w3c.dom.*; 
import javax.xml.parsers.*; 


/**
 * Class for prueba nodos elementos.
 * 
 */
public class PruebaLeerNodosElementos {

    /**********************************/
    /*** Properties declaration *******/
        
		private final String xml_path 	   = AdPaths.XML_FILES + "productos.xml";
		private DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    /**********************************/
    /*** Methods declaration **********/

		/**
		 * Construct
		 * 
		 * @throws java.io.IOException
		 */
		public PruebaLeerNodosElementos() throws java.io.IOException {

			try {
				DocumentBuilder builder = dbf.newDocumentBuilder();
				Document doc = builder.parse( 
					new java.io.File( xml_path )
				);

				// recupera el primer nodo
				leerNodo( doc.getFirstChild( ));

				// recupera el elemento raíz
				leerNodo( doc.getDocumentElement( ));

			} catch ( Exception e ) {
				e.printStackTrace();
			}
		} // main

		/**
		 * Reads and shows info about a xml node
		 *
		 * @param      nodo  The nodo
		 * @throws java.io.IOException
		 */
		public static void leerNodo( Node nodo ) throws IOException {
			
			Trace.node( nodo );

			NodeList listaHijos = nodo.getChildNodes(); 
			int num = listaHijos.getLength();
			
			for ( int i = 0; i < num; i++ ) {

				Node nodoActual = listaHijos.item( i ); 
				leerNodo( nodoActual ); 
			}

		} //leerNodo

} // class