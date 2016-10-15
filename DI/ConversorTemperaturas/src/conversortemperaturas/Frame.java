/**
 * @file: Frame.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package conversortemperaturas;

//imports
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
//import static java.awt.event.KeyEvent.VK_ENTER;
import javax.swing.*;

/**
 * This class compose the App-GUI
 * 
 */
class Frame extends JFrame {

    /**********************************/
    /*** Properties declaration *******/
        
        //GUI components
        final private JButton btn_calc      = new JButton( "Convertir" );
        final private JButton btn_reset     = new JButton( "Limpiar" );
        final private JLabel label_celcius  = new JLabel( "Grados Celcius:" );
        final private JLabel label_kelvins  = new JLabel( "Grados Kelvin:" );
        final private JTextField field_celcius = new JTextField();
        final private JTextField field_kelvins = new JTextField();
        
        //Listeners
        final private ButtonsListener bl = new ButtonsListener();
        final private FieldsListener fl  = new FieldsListener();


    /**********************************/
    /*** Methods declaration **********/

        /**
         * Contruct
         * 
         */
        public Frame() {
            setDefaultCloseOperation( EXIT_ON_CLOSE );
            setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 5 ));
            setSize( 300, 230 );
            setTitle( "Conversor de temperaturas" );
            
            
            /*******************************************/
            /* Config elements                         */
            
            // Establecer dimensiones botones
            // setPreferredSize( java.awt.Dimension )
            // Dimension(float width, float height)
            btn_calc.setPreferredSize(  new Dimension( 140, 60 ));
            btn_reset.setPreferredSize( new Dimension( 140, 60 ));
            
            //Set padding into text-fields
            field_celcius.setBorder(
                BorderFactory.createCompoundBorder(
                    field_celcius.getBorder(),
                    // createEmptyBorder(float top, float left, float bottom, float right)
                    BorderFactory.createEmptyBorder( 5, 25, 5, 25 ) 
                )
            );
            field_kelvins.setBorder(
                BorderFactory.createCompoundBorder(
                    field_kelvins.getBorder(), 
                    BorderFactory.createEmptyBorder( 5, 25, 5, 25 )
                )
            );
            
            //Set text alignment into text-fields
            field_celcius.setHorizontalAlignment( JTextField.RIGHT );
            field_kelvins.setHorizontalAlignment( JTextField.RIGHT );
                    
            // Establecer dimensiones campos de texto
            field_celcius.setPreferredSize(  new Dimension( 172, 60 ));
            field_kelvins.setPreferredSize(  new Dimension( 172, 60 ));
            
            /*******************************************/
            /* Create and add listeners to components  */
            
            btn_calc.addActionListener( bl );
            btn_reset.addActionListener( bl );

            field_celcius.addKeyListener( fl );
            field_kelvins.addKeyListener( fl );
                //field_celcius.addActionListener((ActionListener) fl);
            //field_kelvins.addActionListener((ActionListener) fl);
            
            
            /*******************************************/
            /* Add components to frame                 */
            
            add( label_celcius );
            add( field_celcius );
            add( label_kelvins );
            add( field_kelvins );
            add( btn_calc );
            add( btn_reset );
        }

        /**
         * Clean text-fields content
         * 
         */
        private void cleanTextFields() {
            //pln( "cleanTextFields()" ); //Trace msg

            field_celcius.setText( "" );
            field_kelvins.setText( "" );
        }

        /**
         * Convert between diferent types of degrees
         * 
         */
        private void convertDegrees() {
            //pln( "convertDegrees()" ); //Trace msg
            
            String content_celcius = field_celcius.getText();
            String content_kelvin  = field_kelvins.getText();

            //Traces
            //pln( "Celcius: " + content_celcius );
            //pln( "Kelvins: " + content_kelvin );


            // Leido número en campo introducción "grados Celcius"
            if ( TempConverter.isNumber( content_celcius )) {
                //pln( "Recibidos grados Celcius..." ); //Trace msg
                
                //mostrar correspondencia Kelvins  
                setKelvinsInGUI( content_celcius );


            // Leido número en campo introducción "grados Kelvin"
            } else if ( TempConverter.isNumber( content_kelvin )) {
                //pln( "Recibidos grados Kelvin..." ); //Trace msg
                
                // mostrar correspondencia Celcius                     
                setCelciusInGUI( content_kelvin );


            // No leido número en ningun campo -> limpiar campos
            } else
                cleanTextFields();
        }

        /**
         * Trace method
         *
         * @param str   The string
         */
        private void pln( String str ) {
            
            System.out.println( str ); //Trace msg
        }


        ////////////////////////////////////////////////////////////////
        ///  Set results to GUI  ///////////////////////////////////////
        ///

        /**
         * Put in JTextField Kelvin degrees from Celcius writted by user
         *
         * @param float   degrees  -> The celcius from user
         */
        private void setKelvinsInGUI( String degrees ) {
            //pln( "setKelvinsInGUI()" ); //Trace msg
            
            //Replace decimal marks (commas with points)
            degrees = TempConverter.replaceDecimalMarks( degrees );

            
            // Get Kelvins degrees from Celcius
            float celcius = Float.parseFloat( degrees );
            float res     = TempConverter.celciusToKelvins( celcius ); 

            //Traces
            //pln( "Celcius entrada -> " + degrees );
            //pln( "Kelvins salida  -> " + res );

            // Show Celcius degrees (fix incorrect decimal mark change comma with point)
            field_celcius.setText( degrees );
            // Show Kelvin degrees equivalentes
            field_kelvins.setText( Float.toString( res ));
        }

        /**
         * Put in JTextField Celcius degrees from Kelvin writted by user
         *
         * @param float   degrees  -> The kelvins from user
         */
        private void setCelciusInGUI( String degrees ) {
            //pln( "setCelciusInGUI()" ); //Trace msg
            
            //Replace decimal marks (commas with points)
            degrees = TempConverter.replaceDecimalMarks( degrees );

            // Get Celcius degrees from Kelvins     
            float kelvins = Float.parseFloat( degrees );
            float res     = TempConverter.kelvinToCelcius( kelvins );

            //Traces
            //pln( "Kelvins entrada -> " + degrees );
            //pln( "Celcius salida  -> " + res );

            // Show Kelvins degrees (fix incorrect decimal mark change comma with point)
            field_kelvins.setText( degrees );
            // Show Celcius degrees equivalentes
            field_celcius.setText( Float.toString( res ));
        }


    /**********************************/
    /*** Internal clases **************/

        /**
         * Implements Listeners for text-fields
         * 
         */
        class FieldsListener implements KeyListener {

            @Override
            public void keyPressed( KeyEvent e ) {
                //pln( "FieldsListener / keyPressed()");
                
                //Store the press key code
                float key = e.getKeyCode();
                
                // User press the ENTER key
                if ( key == KeyEvent.VK_ENTER ) { // VK_ENTER code for enter key
                    //pln( "Pulsada tacla ENTER" );
                    
                    convertDegrees();
                }
            }

            @Override
            public void keyReleased( KeyEvent e ) {}
            
            @Override
            public void keyTyped( KeyEvent e ) {}

        } //class FieldsListener

        
        /**
         * Implements Listeners for buttons
         * 
         */
        class ButtonsListener implements ActionListener {

            @Override
            public void actionPerformed( ActionEvent e ) {

                //Get text from push button
                String btn = e.getActionCommand();

                //Trace msg
                //pln( "Pulsado botón: " + btn );


                /**
                 * Select action for the push button
                 * 
                 */
                if ( "Convertir".equals( btn ))
                    convertDegrees();

                if ( "Limpiar".equals( btn )) 
                    cleanTextFields();
            }

        } //class ButtonsListener
        
} //class
