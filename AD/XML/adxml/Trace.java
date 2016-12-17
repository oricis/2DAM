/**
 * @file: Trace.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2016
 */
package adxml;

//imports
import org.w3c.dom.Node;

/**
 * Class for traces
 * 
 */
public class Trace {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/

    	/**
	     * Traces a node
	     * 
		 * @param 	nodo
		 * @throws 	java.io.IOException
	     */
	    public static void ln( String str ) {

	    	System.out.println( str );
	    }


	    /**
	     * Traces a node
	     * 
		 * @param 	nodo
		 * @throws 	java.io.IOException
	     */
	    public static void node( 
	    	Node nodo 
	    ) throws java.io.IOException {
	        

	        System.out.println(
				"Tipo Nodo: "   
				+ nodo.getNodeType() 
			); 
			System.out.println(
				"Nombre Nodo: " 
				+ nodo.getNodeName() 
			); 
			System.out.println(
				"Valor Nodo: "  
				+ nodo.getNodeValue() 
			);
			
			System.out.println( "-------" );
	    }
    
} //class
