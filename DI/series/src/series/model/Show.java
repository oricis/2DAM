/**
 * @file: Show.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series.model;

//imports
import java.io.Serializable;

/**
 * This class allow us instance a Show
 * 
 */
public class Show implements Serializable {

    /**********************************/
    /*** Properties declaration *******/
    
        private boolean cancelled  = false;
        private boolean completed  = false;
        private String gender      = "";
        private float last_episode_viewed = 0; // p.e. 2.03  -> temp. 2, ep. 03
        private String producer    = ""; // Producer company
        private int seasons        = 0;
        private int rating         = 3;  // (1-5), 3 is the middle
        private String store_media = "";
        private String title       = "";
        
    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param title
         * @param gender
         * @param producer
         * @param seasons
         * @param cancelled
         * @param completed
         * @param last_episode_viewed
         * @param store_media
         * @param rating
         */
        public Show(
            String title,
            String gender,
            String producer,
            int seasons,
            float last_episode_viewed,
            String store_media,
            boolean cancelled,
            boolean completed,
            int rating
        ) {
            
            this.cancelled           = cancelled;
            this.completed           = completed;
            this.gender              = gender;
            this.last_episode_viewed = last_episode_viewed;
            this.producer            = producer;
            this.rating              = rating;
            this.seasons             = seasons;
            this.store_media         = store_media;
            this.title               = title;
        }

        /**
         * Construct
         * 
         * @param title
         * @param gender
         * @param seasons
         */
        public Show( 
            String title,
            String gender,
            int seasons
        ) {
        
            this.gender     = gender;
            this.seasons    = seasons;
            this.title      = title;
        }

        /**
         * Construct
         * 
         */
        public Show() {}
        
        
    ////////////////////////////////////////////////////
    /// Getters
    ///
    
        public boolean isCancelled() {
            
            return cancelled;
        }

        public boolean isCompleted() {
            
            return completed;
        }

        public String getGender() {
            
            return gender;
        }

        public float getLastEpisodeViewed() {
            
            return last_episode_viewed;
        }
        
        public String getProducer() {
            
            return producer;
        }
        
        public int getRating() {
            
            return rating;
        }

        public int getSeasons() {
            
            return seasons;
        }

        public String getStoreMedia() {
            
            return store_media;
        }

        public String getTitle() {
            
            return title;
        }


    /////////////////////////////////////////////////////
    /// Setters
    ///
    
        public void setCancelled( boolean cancelled ) {

            this.cancelled = cancelled;
        }

        public void setCompleted( boolean completed ) {

            this.completed = completed;
        }

        public void setGender( String gender ) {

            this.gender = gender;
        }

        public void setLastEpisodeViewed( float last_episode_viewed ) {
            this.last_episode_viewed = last_episode_viewed;
        }
        
        public void setProducer( String producer ) {

            this.producer = producer;
        }
        
        public void setRating( int rating ) {

            this.rating = rating;
        }
        
        public void setSeasons( int seasons ) {

            this.seasons = seasons;
        }

        public void setStoreMedia( String store_media ) {

            this.store_media = store_media;
        }

        public void setTitle( String title ) {

            this.title = title;
        }


} //class
