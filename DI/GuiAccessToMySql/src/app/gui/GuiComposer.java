/**
 * @file: GuiComposer.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.gui;

//imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


/**
 * This class compose the App GUI
 * 
 */
public class GuiComposer extends JFrame {
    
    /**********************************/
    /*** Properties declaration *******/
        
        //GUI panels
        protected JPanel panel_general  = new JPanel();
        protected JPanel panel_sup      = new JPanel();
        protected JPanel panel_central  = new JPanel();
        protected JPanel panel_inf      = new JPanel();

        //GUI components
        protected JButton btn_all       = new JButton( "Todos" );
        protected JButton btn_back      = new JButton( "<" );
        protected JButton btn_next      = new JButton( ">" );
        protected JButton btn_seek      = new JButton( "Buscar" );
        
        protected JLabel label_id       = new JLabel( "ID: " );
        protected JLabel label_notes    = new JLabel( "Notas: " );
        protected JLabel label_seek_id  = new JLabel( "ID a buscar: " );

        protected JTextField field_id   = new JTextField();
        protected JTextField field_seek = new JTextField();
        protected JTextArea notes       = new JTextArea( 6, 32 );
    
        protected final Border border = BorderFactory.createLineBorder( Color.gray );
        protected final Border err = BorderFactory.createLineBorder( Color.red );

        private final Dimension d    = new Dimension( 132, 32 ); // width, height
        private final Dimension dbtn = new Dimension( 120, 32 );


    /**********************************/
    /*** Methods declaration **********/
    
        /**
         * Construct
         * 
         */
        public GuiComposer() {
            setDefaultCloseOperation( EXIT_ON_CLOSE );
            //setLayout( new FlowLayout( )); //default layout
            setSize( 620, 220 );
            setTitle( "Acceso a MySql" );

            
            init();
        }
        
        /**
         * Sets layout and loads the components
         * 
         */
        private void init() {

            /*******************************************/
            /* Config elements                         */
            
                // Layouts
                panel_general.setLayout( new BorderLayout( ));

                panel_sup.setLayout( new FlowLayout( ));
                panel_central.setLayout(
                    //new FlowLayout( int align, int hgap, int vgap )
                    new FlowLayout( FlowLayout.CENTER, 10, 10 )
                );
                panel_inf.setLayout( new FlowLayout( ));
                panel_inf.setBackground( Color.gray );
                
                // JButtons
                btn_all.setPreferredSize( dbtn );
                btn_seek.setPreferredSize( dbtn );

                btn_back.setEnabled( false );
                btn_next.setEnabled( false );

                // JTextFields
                field_id.setBackground( Color.white );
                field_id.setBorder( border );
                field_id.setEditable( false );
                field_id.setPreferredSize( d );
                
                field_seek.setBorder( border );
                field_seek.setPreferredSize( d );

                //JTextArea
                notes.setBorder( border );
                notes.setEditable( false );

                
            /*******************************************/
            /* Add components to frame                 */

                addGUIComponents();

                panel_general.add( panel_sup,     BorderLayout.NORTH );
                panel_general.add( panel_central, BorderLayout.CENTER );
                panel_general.add( panel_inf,     BorderLayout.SOUTH );

                add( panel_general );
        }

        /**
         * Adds the components to GUI
         * 
         */
        private void addGUIComponents() {

            panel_sup.add( label_seek_id );
            panel_sup.add( field_seek );
            panel_sup.add( btn_seek );
            panel_sup.add( btn_all );
            
            panel_central.add( label_id );
            panel_central.add( field_id );
            panel_central.add( label_notes );
            panel_central.add( notes );
            
            panel_inf.add( btn_back );
            panel_inf.add( btn_next );
        }

} //class
