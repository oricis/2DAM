/**
 * @file: Series.java
 * @info: main file
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series;

//imports
import series.controller.*;
import series.test.*;
import series.view.*;


/**
 * Main class for the App
 * 
 */
public class Series {

    /**
     * Main method
     * 
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main( String[] args ) throws java.lang.ClassNotFoundException {
        
        /*Frame f = new Frame( new Controller( ));
        f.setVisible( true );
        /**/
        
        // Test
        new TestCreate();
        new TestRetrieve();
        /**/
    }

    
} //class
