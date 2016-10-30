/**
 * @file: Client.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.dao;


/**
 * Class of type Client
 * 
 */
public class Client {
	
    /**********************************/
    /*** Properties declaration *******/

        private int id       = 0;
        private String notes = null;


    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         *
         * @param   id     The identifier
         * @param   notes  The notes
         */
        public Client( int id, String notes ) {
            
            this.id    = id;
            this.notes = notes;
        }
        
        /**
         * Gets the identifier
         *
         * @return	 The identifier
         */
        public int getId() {

            return this.id;
        }

        /**
         * Sets the identifier
         *
         * @param	 The identifier
         */
        public void setId( int id ) {

            this.id = id;
        }

        /**
         * Gets the notes
         *
         * @return	 The notes
         */
        public String getNotes() {

            return this.notes;
        }

        /**
         * Gets the notes
         *
         * @param	 The notes
         */
        public void setNotes( String notes ) {

            this.notes = notes;
        }

} //class
