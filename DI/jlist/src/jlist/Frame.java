/**
 * @file: Frame.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package jlist;

//imports
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



/**
 * This class compose the App-GUI
 * 
 */
class Frame extends JFrame {

    /**********************************/
    /*** Properties declaration *******/
        
        //Data
        final private Color[] arr_colors = { 
            Color.red, 
            Color.green, 
            Color.blue, 
            Color.magenta, 
            Color.gray
        };
        final private String[] arr_options = { 
            "rojo", 
            "verde", 
            "azul",
            "magenta",
            "gris"
        };
        
        //GUI components
        final private JList list     = new JList( arr_options );
        final private JPanel panel   = new JPanel();

        //implements scroll for the list
        final private JScrollPane sp = new JScrollPane( list );
    
    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public Frame() {
            super( "Lista simple" ); //set tittle
            setDefaultCloseOperation( EXIT_ON_CLOSE );
            setLayout( new BorderLayout( ));
            setSize( 600, 400 );
            
            
            
            /*******************************************/
            /* Config elements                         */
            
            //font-color for selected text
            list.setSelectionForeground( Color.BLUE );
            
            //set selection mode
            list.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
            
            // set size to component
            list.setSize( 100, 50 );
            
            // set number of rows to show
            list.setVisibleRowCount( 3 );
          

            /*******************************************/
            /* Add listeners                           */
            
            list.addListSelectionListener( new MyListener( ));
            
            
            /*******************************************/
            /* Add components to frame                 */
            
            panel.add( sp );
            add( panel, BorderLayout.CENTER );
        }
        
        
    /**********************************/
    /*** Internal classes *************/
        
        /**
         * Class to listen JComboBox events
         * 
         */
        private class MyListener implements ListSelectionListener {

            @Override
            public void valueChanged( ListSelectionEvent e ) {
                
                //Get the index of selected option in the list
                int index = list.getSelectedIndex();

                panel.setBackground( arr_colors[ index ] );
            }

        } //class
      
} //class
