/**
 * @file: Frame.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.gui;

//imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.dao.*;
import app.helpers.Trace;
import java.awt.Color;


/**
 * This class handle App GUI functionalities 
 * 
 */
public class Frame extends GuiComposer {
    
    /**********************************/
    /*** Properties declaration *******/
        
        private Client c = null;
        private Client[] arr_data;
        private final ClientsDAO cdao = new ClientsDAO();

        private int position = 0;


    /**********************************/
    /*** Methods declaration **********/
    
        /**
         * Construct
         * 
         */
        public Frame() {
            
            

            /*******************************************/
            /* Add listeners                           */
            
            btn_back.addActionListener( new AppListener( ));
            btn_next.addActionListener( new AppListener( ));
            btn_seek.addActionListener( new AppListener( ));
            btn_all.addActionListener(  new AppListener( ));
        }
        
        /**
         * Gets the identifier from GUI
         *
         * @return  The identifier from gui.
         */
        private int getIdFromGUI() {

            String str = field_seek.getText();

            try {

                if ( ! str.equals( "" ))
                    return Integer.valueOf( str );

            } catch( NumberFormatException e ) {

                System.out.println( "Error getting ID" );
                System.out.println( "---> " + e.toString( ));

                /**
                 * Not validate content from "seek field" (not is an integer number). 
                 * Puts to red color the border of field. 
                 */
                field_seek.setBorder( err );
            }


            return 0;
        }

                    
    /**********************************/
    /*** Internal classes *************/

        private class AppListener implements ActionListener {

            @Override
            public void actionPerformed( ActionEvent e ) {
                
                //Puts the field´s border to normal color
                field_seek.setBorder( border );
                

                // Gets ALL ROWS from DAO
                if ( e.getSource() == btn_all )
                    pushForAll();

                // Gets ONE ROW from DAO using the ID from GUI
                if ( e.getSource() == btn_seek ) {
                    pushForOne();
                }

                //Show previous data of the set
                if ( e.getSource() == btn_back )
                    pushForPrevious();

                //Show next data of the set
                if ( e.getSource() == btn_next )
                    pushForNext();
            }


            private void pushForAll() {
                Trace.ln( "AppListener / pushForAll()" );
                Trace.ln( "Retrieve all rows \n" );

                //Cleans the GUI
                new GUI().clean();

                //Gets data from DAO
                arr_data = cdao.selectAll();
                Trace.ln( "Rows loaded !" );
                
                int i   = 0;
                int len = arr_data.length;
                Trace.ln( "Has been retrieved " + len + " rows !\n" );
                

                if ( len > 0 ) {

                    //Enable movement buttons
                    new GUI().enableMovBtns( true );

                    //Shows first row 
                    c = arr_data[ 0 ];
                    new GUI().setData( c );

                } else
                    Trace.ln( "Without rows to show !\n" );
            }

            private void pushForOne() {
                Trace.ln( "AppListener / pushForOne()" );
                Trace.ln( "Retrieve one row \n" );

                //Disable movement buttons
                new GUI().enableMovBtns( false );

                int id = getIdFromGUI();

                if ( id > 0 ) {

                    c = cdao.selectOne( id );

                    //Exist data to show
                    if ( c != null )
                        new GUI().setData( c );
                    
                    //NO exist data to show -> clean exits of data
                    else
                        new GUI().cleanExits();


                } else {

                    Trace.ln( 
                        "The seek field has a not valid ID or is empty !" 
                    );
                }
            }

            private void pushForNext() {
                Trace.ln( "AppListener / pushForNext()" );
                Trace.ln( "Move to next row \n" );

                int len = arr_data.length - 1;

                if ( position < len ) {

                    position++;
                    Trace.ln( "Move to position: " + position );

                    //Shows data
                    c = arr_data[ position ];
                    new GUI().setData( c );
                }
            }

            private void pushForPrevious() {
                Trace.ln( "AppListener / pushForPrevious()" );
                Trace.ln( "Move to previos row \n" );

                int len = arr_data.length - 1;

                if ( position > 0 ) {

                    position--;
                    Trace.ln( "Move to position: " + position );

                    //Shows data
                    c = arr_data[ position ];
                    new GUI().setData( c );
                }
            }

        } //class

        private class GUI {

            /**
             * Cleans the entries and outputs for data in the GUI
             * 
             */
            public void clean() {

                field_seek.setText( "" );
                
                cleanExits();
            }

            /**
             * Cleans the outputs for data in the GUI
             * 
             */
            public void cleanExits() {

                field_id.setText( "" );
                
                notes.setText( "" );
            }

            /**
             * Enables / disables the movement buttons
             *
             * @param   bool
             */
            public void enableMovBtns( boolean bool ) {
                Trace.ln( "GUI / enableMovBtns()" );

                btn_back.setEnabled( bool );
                btn_next.setEnabled( bool );
            }
            
            /**
             * Sets the data in the GUI
             *
             * @param   c
             */
            public void setData( Client c ) {
                Trace.ln( "GUI / setData()" );

                field_id.setText( 
                    Integer.toString( c.getId( ))
                );

                notes.setText( c.getNotes( ));
            }


        } //class

} //class
