/**
 * @file: ShowsList.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series.model;

//imports
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class ...
 * 
 */
public class ShowsList implements Serializable {

    /**********************************/
    /*** Properties declaration *******/

        private final ArrayList<Show> arr_shows;


    
    /**********************************/
    /*** Methods declaration **********/

        /**
         * Construct
         * Create an ArrayList with the Shows
         * 
         */
        public ShowsList() {
        
            arr_shows = new ArrayList<>();
        }


        /**
         * Set all Shows
         * 
         * @param s
         */
        public void add( Show s ) {
        
            arr_shows.add( s );
        }
        
        /**
         * Get number of registered Shows
         * 
         * @return 
         */
        public int count() {
            int size = arr_shows.size();
            System.out.println( "Número de series almacenadas: " + size );
            
            return size;
        }

        /**
         * Get all Shows
         * 
         * @param n
         * @return 
         */
        public Show get( int n ) {
        
            return arr_shows.get( n );
        }
        
        /**
         * Remove a Show
         * 
         * @param n
         */
        public void remove( int n ) {
        
            arr_shows.remove( n );
        }
        
        /**
         * Replace a Show by other
         * 
         * @param position
         * @param s 
         */
        public void replace( int position, Show s ) {
            
            arr_shows.set( position, s );
        }
        
} //class
