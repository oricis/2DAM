/**
 * @file: Main.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app;

//imports


/**
 * Main class -> Runs the App
 * 
 */
public class App {

    /**********************************/
    /*** Properties declaration *******/

    	final static private String[][] preguntas = {
    		{ 
                "¿Que es una JVM?", 
                "Una máquina de cafes",    
                "Sw que interpreta y ejecuta código Java", 
                "Ambas son correctas" 
            },
    		{ 
                "Las clases Swing", 
                "Dan soporte a las GUI",             
                "Son clases de baile", 
                "Ambas son correctas" 
            },
    		{ 
                "JavaFx es",        
                "Efectos especiales Java", 
                "Nuevo soporte GUI Java", 
                "Ambas son correctas" 
            },
    		{ 
                "¿Netbeans es peor que Eclipse?", 
                "Si, pero solo se puede desarrollar en Java", 
                "No, pero Eclipse es de pago", 
                "A y B incorrectas" 
            },
    		{ 
                "¿Oracle es propietaria de Java?", 
                "Si", 
                "No", 
                "50 %" 
            }
    	};

        final static private int[] correctas = { 2,1,2,3,1 };


        
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Method description
	     *
	     * @param args the command line arguments
	     */
	    public static void main( String[] args ) {

	        new app.controller.Controller( preguntas, correctas );
	    }


    /**********************************/
    /*** Internal clases **************/

    

} //class
