/**
 * @file: Create.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series.view;

/**
 * Show form to register a new serie
 * 
 */
public class Selects {

    /**********************************/
    /*** Properties declaration *******/
    
        protected static final boolean cancelled         = false;
        protected static final boolean completed         = false;
        protected static final String[] gender           = {
            "Acción",
            "Aventuras",
            "Animación",
            "Comedia",
            "Drama",
            "Fantasía",
            "Historia",
            "Romántico",
            "Sci-fi", 
            "Otro..."
        };
        protected static final float last_episode_viewed = 0; // p.e. 2.03  -> temp. 2, ep. 03
        protected static final int seasons               = 0;
        protected static final int rating                = 0; //puntuación ( 1 - 5 )
        protected static final String[] store_media      = {
            "dropbox",
            "external hd",
            "laptop hd",
            "mac hd",
            "dvd",
            "no stored"
        };
        protected static final String title = "";
        
    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public Selects() {
        
            
        }

} //class
