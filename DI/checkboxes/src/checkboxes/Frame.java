/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package checkboxes;

//imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;


/**
 *
 * @author orici, 2016
 */
class Frame extends JFrame {


    /**********************************/
    /*** Properties declaration *******/

        //GUI components
        final private JCheckBox jc_bold     = new JCheckBox( "Negrita" );
        final private JCheckBox jc_italic   = new JCheckBox( "Cursiva" );
        final private JPanel checkboxes     = new JPanel(); //group the check-boxes
        final private JTextField textfield  = new JTextField( "Lorem ipsum y bla, bla..." );
        
        //Listeners
        final private MyListener listener   = new MyListener();
        
        
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
            setTitle( "Cambiar estilos de texto con Checkboxes" );
            
            
            /*******************************************/
            /* Config elements                         */
            
            // Set background for text-field
            textfield.setBackground( Color.WHITE );
            
            // Set font properties
            textfield.setFont( new Font( "Serif", Font.PLAIN, 16 ));

            // Set horizontal alignment for text
            textfield.setHorizontalAlignment( JTextField.CENTER );
                    
            // Set size for textfield
            textfield.setPreferredSize(  new Dimension( 280, 40 ));

            //text content can´t be changed by the user
            textfield.setEditable( false );
            

            /*******************************************/
            /* Add listeners to components  		   */
            
            jc_bold.addItemListener( listener );
            jc_italic.addItemListener( listener );
            
            
            /*******************************************/
            /* Add components to frame                 */
            
            checkboxes.add( jc_bold );
            checkboxes.add( jc_italic );
            add( textfield );
            add( checkboxes );
        }
        
        
    /**********************************/
    /*** Internal clases **************/
        
        /**
         * Class to listen app events
         * 
         */
        class MyListener implements ItemListener {

        	private int val_bold    = Font.PLAIN; 
    		private int val_italic  = Font.PLAIN;


            @Override
            public void itemStateChanged( ItemEvent e ) {

                // Process the events for the checkbox: "negrita"  
		    	if ( e.getSource() == jc_bold ) {
		        	val_bold = jc_bold.isSelected()  
		            	? Font.BOLD  
		            	: Font.PLAIN; 
		    	}
		 
		    	// Process the events for the checkbox: "cursiva"  
		    	if ( e.getSource() == jc_italic ) {
			        val_italic = jc_italic.isSelected()  
			            ? Font.ITALIC  
			            : Font.PLAIN; 
				}

		    	// Set font-type in the text-field
		    	textfield.setFont(
		    		new Font( "Serif", val_bold + val_italic, 16 ) 
		      	); 
            }
               
        } //class
        
} //class
