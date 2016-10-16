/**
 * @file: TestRetrieve.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series.test;

//imports
import series.helpers.*;
import series.model.*;

/**
 * This class ...
 * 
 */
public class TestRetrieve {

    /**********************************/
    /*** Properties declaration *******/
        
        private ShowsList sl = null;
        
    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public TestRetrieve() {
            Trace.ln( "TestRetrieve()" );
            
            //Get store shows data
            try {
                sl = (ShowsList)DataStoreHandler.retrieve();
                
            } catch( ClassNotFoundException e ) {
                
                System.out.println( "Err: Failure getting ShowsList" );
                System.out.println( e.toString( ));
            }
            
            if ( sl != null ) {
                
                //Get first and second stored Shows
                Show s1 = sl.get( 0 );
                Show s2 = sl.get( 1 );


                //Get some shows data
                String title1  = s1.getTitle();
                String title2  = s1.getTitle();
                String gender1 = s1.getGender();
                String gender2 = s1.getGender();

                //Display some shows data
                System.out.println( "Series guardadas:" );
                System.out.println( "1. " + title1 + " (" + gender1 + ")" );
                System.out.println( "2. " + title2 + " (" + gender2 + ")" );
            }
        }

} //class
