/**
 * @file: Frame.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package radiobuttons;

//imports
import java.awt.*;
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

        //GUI components
        final private JRadioButton rb_simple = new JRadioButton( "Simple", true );
        final private JRadioButton rb_bold   = new JRadioButton( "Negrita", true );
        final private JRadioButton rb_italic = new JRadioButton( "Cursiva", true );
        final private JRadioButton rb_both   = new JRadioButton( "Negrita/Cursiva", true );
        final private JTextField textfield   = new JTextField( "Lorem ipsum y bla, bla..." );
        
        final private ButtonGroup group      = new ButtonGroup();   //connect the radios
        final private JPanel radios_panel    = new JPanel();        //group the radios

        //Font-types
        final private Font font_simple = new Font( "Serif", Font.PLAIN, 16 ); 
        final private Font font_bold   = new Font( "Serif", Font.BOLD, 16 ); 
        final private Font font_italic = new Font( "Serif", Font.ITALIC, 16 ); 
        final private Font font_both   = new Font( "Serif", Font.BOLD + Font.ITALIC, 16 );
        
        
    /**********************************/
    /*** Methods declaration **********/
    
        /**
         * Construct
         * 
         */
        public Frame() {
            setDefaultCloseOperation( EXIT_ON_CLOSE );
            setLayout( new FlowLayout( ));
            setSize( 360, 150 );
            setTitle( "Cambiar estilos de texto con RadioButtons" );
            
            
            /*******************************************/
            /* Config elements                         */
            
            // Add connection between radio-buttons
            group.add( rb_simple );
            group.add( rb_bold );
            group.add( rb_italic );
            group.add( rb_both );

            // Set background for text-field
            textfield.setBackground( Color.WHITE );
            
            // Set font properties
            textfield.setFont( font_simple );

            // Set horizontal alignment for text
            textfield.setHorizontalAlignment( JTextField.CENTER );
                    
            // Set size for textfield
            textfield.setPreferredSize(  new Dimension( 280, 40 ));

            //text content can´t be changed by the user
            textfield.setEditable( false );
            

            /*******************************************/
            /* Add listeners to radio-buttons          */
            
            rb_simple.addItemListener( new MyListener( font_simple ));
            rb_bold.addItemListener(   new MyListener( font_bold ));
            rb_italic.addItemListener( new MyListener( font_italic ));
            rb_both.addItemListener(   new MyListener( font_both ));

            
            /*******************************************/
            /* Add components to frame                 */
            
            radios_panel.add( rb_simple );
            radios_panel.add( rb_bold );
            radios_panel.add( rb_italic );
            radios_panel.add( rb_both );
            add( textfield );
            add( radios_panel );
        }
        
        
    /**********************************/
    /*** Internal clases **************/
        
        /**
         * Class to listen app events
         * 
         */
        class MyListener implements ItemListener {
            
            /**********************************/
            /*** Properties declaration *******/
            
            private final Font fontType;
            
            
            /**********************************/
            /*** Methods declaration **********/
            
            /**
             * Construct
             *
             * @param      f -> font properties
             */
            public MyListener( Font f) {

                fontType = f;
            }

            @Override
            public void itemStateChanged( ItemEvent e ) {

                textfield.setFont( fontType ); 
            }
               
        } //class
        
} //class
