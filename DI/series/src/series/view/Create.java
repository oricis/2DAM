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
public class Create {

    /**********************************/
    /*** Properties declaration *******/
    
        private final boolean cancelled         = false;
        private final boolean completed         = false;
        private final String[] gender           = {
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
        public Create() {
        
            
        }

} //class
