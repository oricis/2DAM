/**
 * @file: Main.java
 * @info: main file
 * 
 * @utor: Moisés Alcocer, 2016
 */
package adxml;

import java.io.IOException;

/**
 * Main class
 * 
 */
public class Main {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Main method
	     * 
	     * @param args the command line arguments
	     */
	    public static void main( String[] args ) throws IOException {
	        
	        //new PruebaLeerNodosElementos();
	        
	        new Estadisticas();
	        new Level().up( "Riu" );	//Ups a level to this player
                Trace.ln( "Actualizado nivel para Riu \n" );
			new Estadisticas();
	    }
    
} //class
