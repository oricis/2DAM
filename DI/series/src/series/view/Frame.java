/**
 * @file: Frame.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package series.view;

//imports
import java.awt.Color;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Enumeration;
import javax.swing.AbstractButton;
//import javax.swing.JButton;

import series.controller.*;
import series.helpers.Trace;
import series.model.*;

/**
 * This class handles behavior for GUI
 * 
 */
public class Frame extends GuiComposer {

    /**********************************/
    /*** Properties declaration *******/
        
        private Controller c;
        private Show s          = new Show();
        private final Display d = new Display();
        
        private int int_rating         = 3;
        private String str_gender      = "";
        private String str_last_ep     = "0";
        private String str_seasons     = "0";
        private String str_store_media = "";
        private boolean val_completed  = false;
        private boolean val_cancelled  = false;

        //flag to determine if a new show will be store
        private boolean add  = false;

        //flag to determine if a Show is under edition
        private boolean edit = false;


    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param c     // Inyecto una instancia de Controller
         */
        public Frame( Controller c ) {

            //Store instanced Controller in class propertie
            this.c = c;


            /*******************************************/
            /* Add listeners                           */
                
                //buttons
                ButtonsListener btn_listener = new ButtonsListener();
                btn_first.addActionListener( btn_listener );
                btn_back.addActionListener(  btn_listener );
                btn_next.addActionListener(  btn_listener );
                btn_last.addActionListener(  btn_listener );
                btn_add.addActionListener(   btn_listener );
                btn_del.addActionListener(   btn_listener );
                btn_edit.addActionListener(  btn_listener );

                /*one.addItemListener(   new ItListener( 1 ));
                two.addItemListener(   new ItListener( 2 ));
                three.addItemListener( new ItListener( 3 ));
                four.addItemListener(  new ItListener( 4 ));
                five.addItemListener(  new ItListener( 5 ));
                /**/
        }


    //////////////////////////////////////////////////////////////////////
    //// Methods to handle data content //////////////////////////////////
    ////            

        /**
         * Deletes actual Show
         * 
         */
        private void deleteShow() {
            Trace.ln( "Frame / deleteShow()" );

            //Deletes Show in the Controller class
            c.delete();
            Trace.ln( "The Show has been deleted...\n" );

            //Restores GUI (reloads shows data and displays a show)
            new GUI().setStateNormal();
        }

        /**
         * Edits actual Show
         * 
         */
        private void storeEditedShow() {
            Trace.ln( "Frame / editShow()" );

            //Sets Show properties in order to store
            setShowFromGUI();

            //Pass the Show (with new content) to Controller
            c.edit( s );
            Trace.ln( "The Show has been edited...\n" );

            //Restores GUI (reloads shows data and displays a show)
            new GUI().setStateNormal();
        }


        /**
         * Sets Show properties
         * Stores in class propertie "s" the data from GUI
         *
         */
        private void setShowFromGUI() {
            Trace.ln( "Frame / setShowFromGUI()" );

            int temp, i;

            //Gets selected "gender"
            i = select_gender.getSelectedIndex();
            str_gender = Selects.gender[ i ];

            //Traces
            Trace.ln( "Género: " + str_gender );
            Trace.lsep();
            /**/


            //Gets "number of seasons"
            temp = new GetsFromGUI().seasons();

            //New Show
            s = new Show( 
                field_title.getText(),
                str_gender,
                temp
            );

            //Sets "store media"
            i = select_store_media.getSelectedIndex();
            str_store_media = Selects.store_media[ i ];
            s.setStoreMedia( str_store_media );

            //Sets "last viewed episode"
            s.setLastEpisodeViewed( new GetsFromGUI().lastEpisodeViewed( ));

            //Sets "producer"
            s.setProducer( field_prod.getText( ));
            
            //Sets if the Show was cancelled
            if ( check_cancelled.isSelected( ))
                s.setCancelled( true );
            else
                s.setCancelled( false );

            //Sets if have the Show completed
            if ( check_completed.isSelected( ))
                s.setCompleted( true );
            else
                s.setCompleted( false );

            //Sets "rating"
            s.setRating( new GetsFromGUI().rating( ));
        }

        /**
         * Get data from GUI and send it to "Controller.add()" method
         * 
         */
        private void storeNewShow() {
            
            //Sets Show properties
            setShowFromGUI();

            //Pass the Show to Controller
            c.add( s );

            //Exit of "Add mode" and display the data from the last show stored
            new GUI().setStateNormal();
        }


    /**
     *
     *
     *
     */

    /**********************************/
    /*** Internal classes *************/
        
        /**
         * Listener for buttons
         * 
         */
        private class ButtonsListener implements ActionListener {

            @Override
            public void actionPerformed( ActionEvent e ) {
                
                Object source = e.getSource();
                
                //Push button to navigate between shows
                if ( navigation( source ))
                    return;

                //Push button to add, delete or edit a show
                editions( source );
            }
            
            /**
             * Sets actions for buttons to add, delete or edit a show
             *
             * @param   source  The event source
             */
            private void editions( Object source ) {
                Trace.ln( "Frame / editions()" );

                // Push ADD button
                if ( source == btn_add ) {
                    Trace.ln( "Push \"Add button\"" );

                    ////////////////////////////////////////////////////
                    //
                    // Button in "normal mode"
                    // One push prepare GUI to entry of data
                    //
                    if ( ! add && ! edit ) {
                        
                        //"Add button" has been pushed
                        add = true;

                        //Sets fields, combos, etc to entry state
                        new GUI().setStateToAddShow();

                    ////////////////////////////////////////////////////
                    //
                    // Button in "hot mode"
                    // One push will store the data
                    // 
                    // 2 possible ways:
                    //    - A new Show will be stored
                    //    - An existing Show will be modified
                    // ( This is determinig using the propertie: edit )
                    // 
                    } else {

                        //A new Show will be store
                        if ( ! edit ) {

                            add = false;

                            storeNewShow();

                        //An existing Show will be store (data was edited)
                        } else {

                            edit = false;

                            storeEditedShow();
                        }   
                    }
                }

                //Button push to delete actual Show
                if ( source == btn_del ) {
                    Trace.ln( "Push \"Del button\"" );

                    //Deletes actual Show
                    deleteShow();
                }

                //Button push to edit actual Show -> Change GUI
                if ( source == btn_edit ) {
                    Trace.ln( "Push \"Edit button\"" );

                    //Prepare App to store the changes. Will be used when push 
                    //"Add button" to determine next step (editing or creating)
                    edit = true;

                    //Sets GUI prepared to modify Show data
                    //"Add button" change and the rest of buttons will be disabled
                    new GUI().setStateToEditShow();
                }
            }
            
            /**
             * Sets actions for navigation buttons
             *
             * @param   source  The event source
             */
            private boolean navigation( Object source ) {
                Trace.ln( "Frame / navigation()" );

                

                if ( source == btn_first )
                    d.first();

                if ( source == btn_back )
                    d.previous();

                if ( source == btn_next )
                    d.next();

                if ( source == btn_last )
                    d.last();
                

                //Push one of the navigation buttons
                if ( source == btn_first 
                    | source == btn_back 
                    | source == btn_next
                    | source == btn_last) {

                    //Makes NO editables the data entries ( if exist almost one Show )
                    if ( s != null )
                        new GUI().allowChanges( false );

                    return true;
                }

                //No push one of the navigation buttons
                return false;
            }

        } //class

        /**
         * Class to display shows data
         * 
         */
        private class Display {

            /*** Public methods ***********************************************/

                /**
                 * Display data from Show instante in GUI
                 *
                 * @param   sh
                 */
                public void show( Show sh ) {

                    ////////////////////////////////////////////////
                    // Display data on text-fields
                    if ( sh.getSeasons() == 0 )
                        field_seasons.setText( "" );

                    else {
                        field_seasons.setText( 
                            Integer.toString( sh.getSeasons( ))
                        );
                    }
                    field_title.setText( sh.getTitle( ));
                    field_last_viewed.setText( 
                        Float.toString( sh.getLastEpisodeViewed( ))
                    );
                    field_prod.setText( sh.getProducer( ));


                    ////////////////////////////////////////////////
                    // Display data on combo-boxes, checks and radio-buttons
                    checks( sh );
                    combos( sh );
                    radios( sh );
                }

                /**
                 * Display data for the first Show stored
                 *
                 */
                public void first() {

                    s = c.first();

                    if ( s != null )
                        show( s );
                }

                /**
                 * Display data for the last Show stored
                 *
                 */
                public void last() {

                    s = c.last();
                    
                    if ( s != null )
                        show( s );
                }

                /**
                 * Display data for the next Show stored
                 *
                 */
                public void next() {

                    s = c.next();

                    if ( s != null )
                        show( s );
                }

                /**
                 * Display data for the previous Show stored
                 *
                 */
                public void previous() {

                    s = c.back();

                    if ( s != null )
                        show( s );
                }


            /*** Private methods **********************************************/

                /**
                 * Display data on check-boxes
                 * 
                 * @param   sh
                 */
                private void checks( Show sh ) {
                    Trace.ln( "Display / checks()" );
                    
                    val_cancelled = sh.isCancelled();
                    val_completed = sh.isCompleted();

                    check_cancelled.setSelected( val_cancelled );
                    check_completed.setSelected( val_completed );
                }

                /**
                 * Display data on combo-boxes
                 * 
                 * @param   sh
                 */
                private void combos( Show sh ) {
                    Trace.ln( "Display / combos()" );

                    //Get stored values
                    str_gender      = sh.getGender();
                    str_store_media = sh.getStoreMedia();

                    //Get indexes for the values
                    int index_gender      = Arrays.asList( Selects.gender ).indexOf( str_gender );
                    int index_store_media = Arrays.asList( Selects.store_media ).indexOf( str_store_media );

                    //Sets combo values with the indexes (show values)
                    select_gender.setSelectedIndex( index_gender );
                    select_store_media.setSelectedIndex( index_store_media );
                }

                /**
                 * Display data on radio-buttons
                 * 
                 * @param   sh
                 */
                private void radios( Show sh ) {
                    Trace.ln( "Display / radios()" );

                    int_rating = sh.getRating();
                    Trace.ln( "Rating: " + int_rating );

                    if ( int_rating == 1 )
                        r1.setSelected( true );

                    if ( int_rating == 2 )
                        r2.setSelected( true );

                    if ( int_rating == 3 )
                        r3.setSelected( true );

                    if ( int_rating == 4 )
                        r4.setSelected( true );

                    if ( int_rating == 5 )
                        r5.setSelected( true );
                }

        } //class

        /**
         * Retrieve data from GUI
         * 
         */
        private class GetsFromGUI {

            /**
             * Gets the last episode viewed from GUI
             *
             * @return  The last episode viewed
             */
            public float lastEpisodeViewed() {

                try {

                    str_last_ep = field_last_viewed.getText();

                    return ( str_last_ep.equals( "" ))
                        ? 0
                        : Float.valueOf( str_last_ep );

                } catch( NumberFormatException e ) {
                    
                    System.out.println( "Error obteniendo último ep. visto..." );
                    System.out.println( "---> " + e.toString( ));
                }

                return 0;
            }

            /**
             * Gets the season from GUI
             *
             * @return  The season
             */
            public int seasons() {

                try {

                    str_seasons = field_seasons.getText();

                    return ( str_seasons.equals( "" ))
                        ? 0
                        : Integer.valueOf( str_seasons );

                } catch( NumberFormatException e ) {
                    
                    System.out.println( "Error obteniendo temporadas..." );
                    System.out.println( "---> " + e.toString( ));
                }

                return 0;
            }

            /**
             * Gets the rating selected
             *
             * @return     The rating.
             */
            public int rating() {

                if ( r1.isSelected( ))
                    return 1;

                if ( r2.isSelected( ))
                    return 2;

                if ( r3.isSelected( ))
                    return 3;

                if ( r4.isSelected( ))
                    return 4;

                if ( r5.isSelected( ))
                    return 5;

                System.out.println( "No has puntuado la serie" );
                return 0;
            }

        } //class

        /**
         * Class for GUI actions
         * 
         */
        private class GUI {

            ////////////////////////////////////////////////////////////////////
            //// Methods for Disable / enable GUI components ///////////////////
            ////
            
            /**
             * Disables all buttons from GUI except the passed as param
             *
             * @param   btn
             */
            public void disableOtherButtons( String btn ) {

                if ( btn.equals( "Add" )) {
                    btn_first.setEnabled( false );
                    btn_back.setEnabled(  false );
                    btn_next.setEnabled(  false );
                    btn_last.setEnabled(  false );
                    btn_del.setEnabled(   false );
                    btn_edit.setEnabled(  false );

                    btn_add.setBackground( Color.red );
                }
            }

            /**
             * Enables all buttons from GUI
             *
             */
            public void enableButtons() {

                btn_first.setEnabled( true );
                btn_back.setEnabled(  true );
                btn_next.setEnabled(  true );
                btn_last.setEnabled(  true );
                btn_add.setEnabled(   true );
                btn_del.setEnabled(   true );
                btn_edit.setEnabled(  true );
                
                btn_add.setBackground( Color.white );
                // To restore original color for buttons:
                //btn_add.setBackground( new JButton().getBackground( ));
            }

            /**
             * Sets editable / no editable the data content
             * 
             * @param   editable
             */
            public void allowChanges( boolean editable ) {
                
                check_completed.setEnabled( editable );
                check_cancelled.setEnabled( editable );
                
                field_seasons.setEditable( editable );
                field_title.setEditable( editable );
                field_last_viewed.setEditable( editable );
                field_prod.setEditable( editable );
                
                r1.setEnabled( editable );
                r2.setEnabled( editable );
                r3.setEnabled( editable );
                r4.setEnabled( editable );
                r5.setEnabled( editable );

                select_gender.setEnabled( editable );
                select_store_media.setEnabled( editable );

                /*** set backgroung color ***/
                /*check_completed.setBackground( Color.white );
                check_cancelled.setBackground( Color.white );*/
                
                field_seasons.setBackground( Color.white );
                field_title.setBackground( Color.white );
                field_last_viewed.setBackground( Color.white );
                field_prod.setBackground( Color.white );
                
                //Disable / enable radios
                Enumeration<AbstractButton> enumeration = radio_group.getElements();
                while ( enumeration.hasMoreElements( )) {
                    
                    enumeration.nextElement().setEnabled( editable );
                }

                select_gender.setBackground( Color.white );
                select_store_media.setBackground( Color.white );
            }

            /**
             * Sets the state of GUI in appropriate state
             * New Show will be create
             * 
             */
            public void setStateToAddShow() {
                Trace.ln( "Frame / setStateToAddShow()" );

                //Disable buttons
                new GUI().disableOtherButtons( "Add" );


                ///////////////////////////////////////////
                // Makes editables the data entries
                allowChanges( true );


                ///////////////////////////////////////////
                // Does empty the data entries
                check_completed.setSelected( false );
                check_cancelled.setSelected( false );
                
                select_gender.setSelectedIndex( 0 );
                select_store_media.setSelectedIndex( 0 );
                
                r1.setSelected( false );
                r2.setSelected( false );
                r3.setSelected( true );
                r4.setSelected( false );
                r5.setSelected( false );
                
                field_seasons.setText( "" );
                field_title.setText( "" );
                field_last_viewed.setText( "" );
                field_prod.setText( "" );
            }

            /**
             * Sets the state of GUI in appropriate state
             * The Show will be edited
             * 
             */
            public void setStateToEditShow() {
                Trace.ln( "Frame / setStateToEditShow()" );

                edit = true;


                //Disable buttons
                new GUI().disableOtherButtons( "Add" );


                ///////////////////////////////////////////
                // Makes editables the data entries
                allowChanges( true );
            }

            /**
             * Restores normal GUI and display the data from the first Show
             * 
             */
            public void setStateNormal() {
                Trace.ln( "Frame / setStateNormal() -> Restoring the GUI..." );


                ///////////////////////////////////////////
                // Makes NO editables the data entries
                allowChanges( false );

                ///////////////////////////////////////////
                // Enables the buttons
                enableButtons();

                ///////////////////////////////////////////
                // Displays show data
                d.first();

                ///////////////////////////////////////////
                // Rechargue ShowsList to load new data
                // ( will be necessary reinstance the Controller )
                c = new Controller();
            }

        } //class

} //class
