/**
 * @file: Edit.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series.view;

/**
 * Show form to edit content in a stored serie
 * 
 */
public class Edit {

    /**********************************/
    /*** Properties declaration *******/
    
        private final boolean cancelled         = false;
        private final boolean completed         = false;
        private final String[] gender           = {
            "action",
            "adventures",
            "animation",
            "comedy",
            "drama",
            "fantasy",
            "history",
            "romantic",
            "sci-fi", 
            "other..."
        };
        private final float last_episode_viewed = 0; // p.e. 2.03  -> temp. 2, ep. 03
        private final int seasons               = 0;
        private final String[] store_media      = {
            "dropbox",
            "external hd",
            "laptop hd",
            "mac hd",
            "dvd",
            "no stored"
        };
        private final String title = "";
        
    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * Compound a form
         * 
         */
        public Edit() {
        
            
        }

} //class
