/**
 * @file: TestCreate.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series.test;

//imports
import series.model.DataStoreHandler;
import series.model.Show;
import series.model.ShowsList;

/**
 * This class test to create and store new shows
 * 
 */
public class TestCreate {

    /**********************************/
    /*** Properties declaration *******/
        
        //Instance a list of shows
        ShowsList sl = new ShowsList();
    
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public TestCreate() {
        
            //Create a show
            Show s = new Show(
                "Mi título",
                "Comedia",
                3,
                false,
                false, 
                (float) 1.07,
                "dvd"
            );
            
            //Add show to list
            sl.add( s );

            //Create another show
            s = new Show(
                "Mi otro título",
                "Acción",
                3
            );

            //Add another show to list
            sl.add( s );

            //Store data
            DataStoreHandler.store( sl );
            
            //Display succesful message
            System.out.println( "Series guardadas correctamente." );
        }

} //class
