/**
 * @file: Frame.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package combobox;

//imports
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;



/**
 * This class compose the App-GUI
 * 
 */
class Frame extends JFrame {

    /**********************************/
    /*** Properties declaration *******/
        
        //Data
        final private String img_path = "imagenes/";
        final private String img_type = ".GIF";
        final private String[] arr_options = { 
            "Rabbit", 
            "Cat", 
            "Dog", 
            "Bird", 
            "Pig" 
        };
        
        //GUI components
        private Icon img = new ImageIcon( 
            getClass().getResource( img_path + arr_options[ 0 ] + img_type )
        );
        final private JComboBox combo = new JComboBox( arr_options );
        final private JLabel label    = new JLabel();
        //final private JPanel panel    = new JPanel();


    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public Frame() {
            super( "Combobox e imagenes" ); //set tittle
            setDefaultCloseOperation( EXIT_ON_CLOSE );
            setLayout( new BorderLayout( ));
            setSize( 300, 200 );
            
            
            
            /*******************************************/
            /* Config elements                         */
            
            combo.setEditable( false );
            


            label.setIcon( img );
            label.setText( arr_options[ 0 ] );
            label.setHorizontalAlignment( SwingConstants.CENTER );

            //Set final position for label-text (under the img and centered)
            label.setHorizontalTextPosition( SwingConstants.CENTER );
            label.setVerticalTextPosition( SwingConstants.BOTTOM );

            //Add tooltip to label
            label.setToolTipText( "Esto es una etiqueta" );
            

            /*******************************************/
            /* Add listeners                           */
            
            combo.addItemListener( new MyListener( ));
            
            
            /*******************************************/
            /* Add components to frame                 */
            
            add( combo, BorderLayout.NORTH );
            add( label, BorderLayout.CENTER );
        }
        
        
    /**********************************/
    /*** Internal classes *************/
        
        /**
         * Class to listen JComboBox events
         * 
         */
        private class MyListener implements ItemListener {

            @Override
            public void itemStateChanged(ItemEvent e) {

                //Get the index of selected option in the combo
                int index = combo.getSelectedIndex();

                //Get the string from array used to populate the combo
                //this string is the same selected in combo by the user
                String str_element = arr_options[ index ];


                //Set label with new values
                label.setIcon( 
                    new ImageIcon( 
                        getClass().getResource( img_path + str_element + img_type )
                    )
                );
                label.setText( str_element );
            }

        } //class
        
} //class
