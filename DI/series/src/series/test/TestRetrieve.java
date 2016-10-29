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
            
            if ( sl != null )
                displayData( sl );
        }

        /**
         * Show the stored Shows
         *
         * @param   sl
         */
        private void displayData( ShowsList sl ) {

            Trace.ln( "\n-------------------------------------" );
                
            int i = 0;
            int n = sl.count();
            Show s;
            String title;
            String gender;

            System.out.println( "Series guardadas:" );

            while ( i < n ) {

                s = sl.get( i );

                //Get some shows data
                title  = s.getTitle();
                gender = s.getGender();

                i++;

                //Display the data
                System.out.println( i + ". " + title + " (" + gender + ")" );
            }
        }

} //class
