/**
 * @file: DataStoreHandler.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series.model;

//imports
import java.io.*;

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
            ShowsList data = new ShowsList();
            
            try {
                FileInputStream fis   = new FileInputStream( f );
                ObjectInputStream ois = new ObjectInputStream( fis );
                
                //write data in file
                data = (ShowsList) ois.readObject();
                
                //close streams
                ois.close();
                fis.close();
            
            } catch( IOException e ) {

                System.out.println( "Err: failure try open file with data" );
                System.out.println( e.toString( ));
                
            } finally {
                
                return data;
            }
        }
        
        /**
         * Put the data in the store
         * 
         * @param data
         */
        public static void store( ShowsList data ) {
        
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
                System.out.println( e.toString( ));
            }
        }

} //class
