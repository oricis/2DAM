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
         * Create an ArrayList with the shows
         * 
         */
        public ShowsList() {
        
            arr_shows = new ArrayList<>();
        }


        /**
         * Set all shows
         * 
         * @param s
         */
        public void add( Show s ) {
        
            arr_shows.add( s );
        }
        
        /**
         * Get number of registered shows
         * 
         * @return 
         */
        public int count() {
        
            return arr_shows.size();
        }

        /**
         * Get all shows
         * 
         * @param n
         * @return 
         */
        public Show get( int n ) {
        
            return arr_shows.get( n );
        }

} //class
