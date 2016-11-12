/**
 * @file: LayoutComposer.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.view;

//imports
import java.awt.*;
import javax.swing.*;

import app.model.Model;

/**
 * This class compose a GUI
 * 
 */
public class LayoutComposer extends JFrame {

    /**********************************/
    /*** Properties declaration *******/

    	//GUI panels
        protected JPanel panel_general = new JPanel();
        protected JPanel panel_micros  = new JPanel();
        protected JPanel panel_ram     = new JPanel();
        protected JPanel panel_mtores  = new JPanel();
        protected JPanel panel_varios  = new JPanel();

        protected JButton print_btn = new JButton( "Imprimir" );

        protected JCheckBox check_1 = new JCheckBox( Model.VARS[ 0 ] );
        protected JCheckBox check_2 = new JCheckBox( Model.VARS[ 1 ] );
        protected JCheckBox check_3 = new JCheckBox( Model.VARS[ 2 ] );
        protected JCheckBox check_4 = new JCheckBox( Model.VARS[ 3 ] );

        protected ButtonGroup r_group_micros = new ButtonGroup(); //connect the radios
        protected ButtonGroup r_group_ram    = new ButtonGroup();
        protected ButtonGroup r_group_mtores = new ButtonGroup();

        protected JRadioButton r_micros_1 = new JRadioButton( Model.MICROS[ 0 ] );
        protected JRadioButton r_micros_2 = new JRadioButton( Model.MICROS[ 1 ] );
        protected JRadioButton r_micros_3 = new JRadioButton( Model.MICROS[ 2 ] );
        protected JRadioButton r_micros_4 = new JRadioButton( Model.MICROS[ 3 ] );
        protected JRadioButton r_ram_1    = new JRadioButton( Model.RAMS[ 0 ] );
        protected JRadioButton r_ram_2    = new JRadioButton( Model.RAMS[ 1 ] );
        protected JRadioButton r_ram_3    = new JRadioButton( Model.RAMS[ 2 ] );
        protected JRadioButton r_ram_4    = new JRadioButton( Model.RAMS[ 3 ] );
        protected JRadioButton r_mtores_1 = new JRadioButton( Model.MTORES[ 0 ] );
        protected JRadioButton r_mtores_2 = new JRadioButton( Model.MTORES[ 1 ] );
        protected JRadioButton r_mtores_3 = new JRadioButton( Model.MTORES[ 2 ] );
        protected JRadioButton r_mtores_4 = new JRadioButton( Model.MTORES[ 3 ] );

        private final Dimension d = new Dimension( 142, 200 ); // width, height
        private Insets margin; //int top, int left, int bottom, int right
    

    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Construct
	     *
	     */
	    public LayoutComposer() {
                setDefaultCloseOperation( EXIT_ON_CLOSE );
                setLayout( new FlowLayout( )); //default layout
                setSize( 640, 280 );
                setTitle( "Selección de componentes PC" );

            
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
                panel_general.setLayout( new FlowLayout( ));
                
                panel_micros.setLayout(
                    new BoxLayout( panel_micros, BoxLayout.Y_AXIS )
                );
                panel_ram.setLayout(
                    new BoxLayout( panel_ram, BoxLayout.Y_AXIS )
                );
                panel_mtores.setLayout(
                    new BoxLayout( panel_mtores, BoxLayout.Y_AXIS )
                );
                panel_varios.setLayout(
                    new BoxLayout( panel_varios, BoxLayout.Y_AXIS )
                );
                panel_micros.setPreferredSize( d );
                panel_ram.setPreferredSize(    d );
                panel_mtores.setPreferredSize( d );
                panel_varios.setPreferredSize( d );

                print_btn.setPreferredSize( new Dimension( 640, 32 ));

                panel_micros.setBorder( BorderFactory.createTitledBorder( "Micros" )); 
                panel_ram.setBorder(    BorderFactory.createTitledBorder( "RAM" )); 
                panel_mtores.setBorder( BorderFactory.createTitledBorder( "Monitores" )); 
                panel_varios.setBorder( BorderFactory.createTitledBorder( "Varios" ));  ; 

                //Center radios / checkboxes
                r_micros_1.setAlignmentX( Component.CENTER_ALIGNMENT );
                r_micros_2.setAlignmentX( Component.CENTER_ALIGNMENT );
                r_micros_3.setAlignmentX( Component.CENTER_ALIGNMENT );
                r_micros_4.setAlignmentX( Component.CENTER_ALIGNMENT );
                r_ram_1.setAlignmentX( Component.CENTER_ALIGNMENT );
                r_ram_2.setAlignmentX( Component.CENTER_ALIGNMENT );
                r_ram_3.setAlignmentX( Component.CENTER_ALIGNMENT );
                r_ram_4.setAlignmentX( Component.CENTER_ALIGNMENT );
                r_mtores_1.setAlignmentX( Component.CENTER_ALIGNMENT );
                r_mtores_2.setAlignmentX( Component.CENTER_ALIGNMENT );
                r_mtores_3.setAlignmentX( Component.CENTER_ALIGNMENT );
                r_mtores_4.setAlignmentX( Component.CENTER_ALIGNMENT );
                check_1.setAlignmentX( Component.CENTER_ALIGNMENT );
                check_2.setAlignmentX( Component.CENTER_ALIGNMENT );
                check_3.setAlignmentX( Component.CENTER_ALIGNMENT );
                check_4.setAlignmentX( Component.CENTER_ALIGNMENT );

                margin = check_1.getMargin();
                margin.left = 20;
                check_1.setMargin( margin );
                check_2.setMargin( margin );
                check_3.setMargin( margin );
                check_4.setMargin( margin );
                check_1.setAlignmentX( Component.LEFT_ALIGNMENT );
                check_2.setAlignmentX( Component.LEFT_ALIGNMENT );
                check_3.setAlignmentX( Component.LEFT_ALIGNMENT );
                check_4.setAlignmentX( Component.LEFT_ALIGNMENT );


            /*******************************************/
            /* Add components to frame                 */

                addGUIComponents();

                panel_general.add( panel_micros );
                panel_general.add( panel_ram );
                panel_general.add( panel_mtores );
                panel_general.add( panel_varios );

                add( panel_general );
                add( print_btn );
        }

        /**
         * Adds the components to GUI
         * 
         */
        private void addGUIComponents() {

        	panel_micros.add( r_micros_1 );
            panel_micros.add( r_micros_2 );
            panel_micros.add( r_micros_3 );
            panel_micros.add( r_micros_4 );

            panel_ram.add( r_ram_1 );
            panel_ram.add( r_ram_2 );
            panel_ram.add( r_ram_3 );
            panel_ram.add( r_ram_4 );

            panel_mtores.add( r_mtores_1 );
            panel_mtores.add( r_mtores_2 );
            panel_mtores.add( r_mtores_3 );
            panel_mtores.add( r_mtores_4 );

            panel_varios.add( check_1 );
            panel_varios.add( check_2 );
            panel_varios.add( check_3 );
            panel_varios.add( check_4 );

            // Add connection between radio-buttons
                r_group_micros.add( r_micros_1 );
                r_group_micros.add( r_micros_2 );
                r_group_micros.add( r_micros_3 );
                r_group_micros.add( r_micros_4 );
                r_group_ram.add(    r_ram_1 );
                r_group_ram.add(    r_ram_2 );
                r_group_ram.add(    r_ram_3 );
                r_group_ram.add(    r_ram_4 );
                r_group_mtores.add( r_mtores_1 );
                r_group_mtores.add( r_mtores_2 );
                r_group_mtores.add( r_mtores_3 );
                r_group_mtores.add( r_mtores_4 );

        }


    /**********************************/
    /*** Internal clases **************/



} //class
