/**
 * @file: Controller.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series.controller;

//imports
import series.helpers.*;
import series.model.*;


/**
 * This class ...
 * 
 */
public class Controller {

    /**********************************/
    /*** Properties declaration *******/

        private int position = 0;
        private int snumber  = 0;
        private Show s;
        private ShowsList sl = new ShowsList();

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public Controller() {
        
            init();
        }

        /**
         * Inicialize app
         * 
         */
        private void init() {

            try {

                //Get stored series
                sl = DataStoreHandler.retrieve();

                //Get snumber of stored series
                if ( sl.count() > 0 )
                    snumber = sl.count() - 1;

            } catch( ClassNotFoundException e ) {

                Trace.ln( "Err: " + e.toString( ));
            }
        }

    //////////////////////////////////////////////////////////////////////
    //// Methods for navigation buttons //////////////////////////////////
    ////
        
        /**
         * Return first storaged Show
         * 
         * @return Show
         */
        public Show first() {
            Trace.ln( "Controller / first()" );

            if ( snumber > 0 ) {
                position = 0;
                Trace.ln( "Position: " + position );

                return sl.get( position );
            }
            
            return null;
        }

        /**
         * Return next storaged Show
         * 
         * @return Show
         */
        public Show next() {
            Trace.ln( "Controller / next()" );
            
            if ( position < snumber && ( snumber > 0 )) {
                position = position + 1;
                Trace.ln( "Position: " + position );

                return sl.get( position );
            }

            return null;
        }

        /**
         * Return previous storaged Show
         * 
         * @return Show
         */
        public Show back() {
            Trace.ln( "Controller / back()" );
            
            if ( position > 0 && ( snumber > 0 )) {
                position = position - 1;
                Trace.ln( "Position: " + position );

                return sl.get( position );
            }
                
            return null;
        }  

        /**
         * Return last storaged Show
         * 
         * @return Show
         */
        public Show last() {
            Trace.ln( "Controller / last()" );
            
            if ( snumber > 0 ) {
                position = snumber;
                Trace.ln( "Position: " + position );
                
                return sl.get( position );
            }
            
            return null;
        }
        

    //////////////////////////////////////////////////////////////////////
    //// Methods for add, delete and edit buttons ////////////////////////
    ////

        /**
         * Add new Show to storage
         * 
         */
        public void add( Show the_show ) {
            Trace.ln( "Controller / add()" );

            sl.add( the_show );

            //Store ShowsList
            DataStoreHandler.store( sl );
        }

        /**
         * Delete a storaged Show
         * 
         */
        public void delete() {
            Trace.ln( "Controller / delete()" );
            Trace.ln( "Deleting show ---> " + sl.get( position ).getTitle( ));

            //Delete the actual show of the ShowsList
            sl.remove( position );

            //Store ShowsList
            DataStoreHandler.store( sl );
        }

        /**
         * Edit a existing Show in the storage
         * 
         */
        public void edit( Show s ) {
            Trace.ln( "Controller / edit()" );
            Trace.ln( "Change show ---> " + sl.get( position ).getTitle( ));
            
            sl.replace( position, s );
            
            //Store ShowsList
            DataStoreHandler.store( sl );
        }

} //class
