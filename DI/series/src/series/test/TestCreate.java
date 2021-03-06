/**
 * @file: TestCreate.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series.test;

//imports
import series.helpers.*;
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
            Trace.ln( "TestCreate / construct()" );

            
            //Create a show
            Trace.ln( "Intanciando Show con todos los parámetros" );
            Show s = new Show(
                "Mi título",    // String title
                "Comedia",      // String gender
                "AMB",          // String producer
                3,              // int seasons
                (float) 1.07,   // float last_episode_viewed
                "dvd",          // String store_media
                false,          // boolean cancelled
                false,          // boolean completed
                5               // int rating
            );


            //Add show to list
            Trace.ln( "Show creado. Añadiendo a ShowsList..." );
            sl.add( s );

            Trace.ln( "-------------------------------------" );

            //Create another show
            Trace.ln( "Intanciando Show con 3 parámetros" );
            s = new Show(
                "Mi otro título",
                "Acción",
                3
            );

            //Add another show to list
            Trace.ln( "Show creado. Añadiendo a ShowsList..." );
            sl.add( s );

            Trace.lsep();

            //Create another show
            Trace.ln( "Intanciando Show sin parámetros" );
            s = new Show();

            //Add another show to list
            Trace.ln( "Show creado. Añadiendo a ShowsList..." );
            sl.add( s );
            
            Trace.ln( "-------------------------------------" );
            
            //New shows
            //Create a show
            Trace.ln( "Intanciando Show con todos los parámetros" );
            s = new Show(
                "Acción mutante",    // String title
                "Comedia",      // String gender
                "Marvel",          // String producer
                2,              // int seasons
                (float) 1.07,   // float last_episode_viewed
                "dropbox",      // String store_media
                false,          // boolean cancelled
                true,          // boolean completed
                2               // int rating
            );


            //Add show to list
            Trace.ln( "Show creado. Añadiendo a ShowsList..." );
            sl.add( s );

            Trace.ln( "-------------------------------------" );

            //Create a show
            Trace.ln( "Intanciando Show con todos los parámetros" );
            s = new Show(
                "Inferno",      // String title
                "Otro...",      // String gender
                "GMC",          // String producer
                5,              // int seasons
                (float) 1.07,   // float last_episode_viewed
                "dropbox",      // String store_media
                true,          // boolean cancelled
                false,          // boolean completed
                4               // int rating
            );


            //Add show to list
            Trace.ln( "Show creado. Añadiendo a ShowsList..." );
            sl.add( s );

            Trace.ln( "-------------------------------------" );

            /**/
            Trace.lsep( 2 );

            //Store data
            Trace.ln( "Guardando ShowsList en fichero..." );
            DataStoreHandler.store( sl );
            
            //Display succesful message
            System.out.println( "Series guardadas correctamente.\n" );
        }

} //class
