/**
 * @file: DataStoreHandler.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series.model;

//imports
import java.io.*;
import series.helpers.Trace;

/**
 * This class handle the storage for data in the App
 * 
 */
public class DataStoreHandler {

    /**********************************/
    /*** Properties declaration *******/

        private static File f = new File( "series.dat" );
    

    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Get the stored data
         * 
         * @return ShowsList
         * @throws java.lang.ClassNotFoundException
         */
        public static ShowsList retrieve() throws ClassNotFoundException {
            Trace.ln( "DataStoreHandler / retrieve()" );

            ShowsList arr_data = new ShowsList();
            
            try {
                FileInputStream fis   = new FileInputStream( f );
                ObjectInputStream ois = new ObjectInputStream( fis );
                
                Trace.ln( "Getting data from file..." );
                arr_data = (ShowsList) ois.readObject();
                /*
                //close streams
                ois.close();
                fis.close();
            */
            } catch( IOException e ) {

                System.out.println( "Err: failure try open file with data" );
                System.out.println( " ---> " + e.toString( ));
                
            } finally {
                Trace.ln( "Returnning the data..." );
                return arr_data;
            }
        }
        
        /**
         * Put the data in the store
         * 
         * @param data
         */
        public static void store( ShowsList data ) {
            Trace.ln( "DataStoreHandler / store()" );

            try {
                FileOutputStream fos   = new FileOutputStream( f );
                ObjectOutputStream oos = new ObjectOutputStream( fos );
                
                //write data in file
                oos.writeObject( oos );
                
                //close streams
                oos.close();
                fos.close();
                
            } catch( IOException e ) {

                System.out.println( "Err: failure try store data in file" );
                System.out.println( " ---> " + e.toString( ));
            }
        }

} //class
