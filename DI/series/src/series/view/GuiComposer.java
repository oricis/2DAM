/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.view;

//imports
import java.awt.*;
import javax.swing.*;


/**
 * This class compose the App GUI
 * 
 */
public class GuiComposer extends JFrame {

    /**********************************/
    /*** Properties declaration *******/

		//GUI components
        protected ButtonGroup radio_group = new ButtonGroup();   //connect the radios
                                                                     
        protected JButton btn_first = new JButton( "|<" ); //
        protected JButton btn_back  = new JButton( "<"  ); // Buttons to move show info
        protected JButton btn_next  = new JButton( ">"  ); //
        protected JButton btn_last  = new JButton( ">|" ); //
        protected JButton btn_add   = new JButton( "add"  );
        protected JButton btn_del   = new JButton( "del"  );
        protected JButton btn_edit  = new JButton( "edit" );

        protected JCheckBox check_completed = new JCheckBox( "Completada" );
        protected JCheckBox check_cancelled = new JCheckBox( "Cancelada"  );

        protected JComboBox select_gender      = new JComboBox( Selects.gender );
        protected JComboBox select_store_media = new JComboBox( Selects.store_media  );

        protected JLabel label1 = new JLabel( "Título"      );
        protected JLabel label2 = new JLabel( "Género"      );
        protected JLabel label3 = new JLabel( "Productora"  );
        protected JLabel label4 = new JLabel( "Temporadas"  );
        protected JLabel label5 = new JLabel( "Último episodio visto" );
        protected JLabel label6 = new JLabel( "Almacenada en" );
        protected JLabel label9 = new JLabel( "Puntuación: "  );
 
        protected JPanel panel_layout  = new JPanel();
        protected JPanel panel_layout_int  = new JPanel();
        
        protected JPanel panel_buttons = new JPanel();
        protected JPanel panel_fields  = new JPanel();
        protected JPanel panel_checks  = new JPanel();
        protected JPanel panel_rating  = new JPanel();

        protected JPanel row1  = new JPanel();
        protected JPanel row2  = new JPanel();
        protected JPanel row3  = new JPanel();
        protected JPanel row4  = new JPanel();
        protected JPanel row5  = new JPanel();
        protected JPanel row6  = new JPanel();
        
        protected JRadioButton r1 = new JRadioButton( "1", false );
        protected JRadioButton r2 = new JRadioButton( "2", false );
        protected JRadioButton r3 = new JRadioButton( "3", true  );
        protected JRadioButton r4 = new JRadioButton( "4", false );
        protected JRadioButton r5 = new JRadioButton( "5", false );

        protected JTextField field_seasons      = new JTextField();
        protected JTextField field_title        = new JTextField();
        protected JTextField field_last_viewed  = new JTextField();
        protected JTextField field_prod         = new JTextField();

        protected Dimension d_fields = new Dimension( 240, 32 );
        
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public GuiComposer() {
            setDefaultCloseOperation( EXIT_ON_CLOSE );
            setTitle( "Organizador series" );
            setResizable ( false );
            setSize( 420, 440 );


            /*******************************************/
            /* Config elements                         */

                // Layouts Panels
                    panel_layout.setLayout(     new BorderLayout( ));
                    panel_layout_int.setLayout( new BorderLayout( ));

                    panel_buttons.setLayout( new FlowLayout( ));
                    panel_checks.setLayout(  new FlowLayout( FlowLayout.CENTER, 50, 10 ));
                    panel_fields.setLayout(  new FlowLayout( FlowLayout.RIGHT ));
                    panel_rating.setLayout(  new FlowLayout( ));

                    row1.setLayout( new FlowLayout( ));
                    row2.setLayout( new FlowLayout( ));
                    row3.setLayout( new FlowLayout( ));
                    row4.setLayout( new FlowLayout( ));
                    row5.setLayout( new FlowLayout( ));
                    row6.setLayout( new FlowLayout( ));

                //Others
                    panel_buttons.setBackground( Color.gray );
                    panel_rating.setBackground(  Color.gray );

                    r1.setBackground( Color.gray );
                    r2.setBackground( Color.gray );
                    r3.setBackground( Color.gray );
                    r4.setBackground( Color.gray );
                    r5.setBackground( Color.gray );

                    btn_add.setBackground(  Color.white );
                    btn_del.setBackground(  Color.white );
                    btn_edit.setBackground( Color.white );

                // Add connection between radio-buttons
                    radio_group.add( r1 );
                    radio_group.add( r2 );
                    radio_group.add( r3 );
                    radio_group.add( r4 );
                    radio_group.add( r5 );

                // Size text-fields / combos
                    field_seasons.setPreferredSize(      d_fields );
                    field_title.setPreferredSize(        d_fields );
                    field_last_viewed.setPreferredSize(  d_fields );
                    field_prod.setPreferredSize(         d_fields );
                    select_gender.setPreferredSize(      d_fields );
                    select_store_media.setPreferredSize( d_fields );
                

            /*******************************************/
            /* Add components to frame                 */

                addComponentsToButtonsPanel();
                addComponentsToFieldsPanel();
                addComponentsToRatingsPanel();
                
                panel_layout_int.add( panel_fields, BorderLayout.CENTER );
                panel_layout_int.add( panel_checks, BorderLayout.SOUTH );

                panel_layout.add( panel_buttons, BorderLayout.NORTH ); 
                panel_layout.add( panel_layout_int,  BorderLayout.CENTER );
                panel_layout.add( panel_rating, BorderLayout.SOUTH );

                add( panel_layout );
        }


    //////////////////////////////////////////////////////////////////////
    //// Methods for add GUI components //////////////////////////////////
    ////

        /**
         * Adds components to panel
         * 
         */
        private void addComponentsToButtonsPanel() {

            panel_buttons.add( btn_first );
            panel_buttons.add( btn_back );
            panel_buttons.add( btn_next );
            panel_buttons.add( btn_last );
            panel_buttons.add( btn_add );
            panel_buttons.add( btn_del );
            panel_buttons.add( btn_edit );

        }

        /**
         * Adds components to panel
         * 
         */
        private void addComponentsToFieldsPanel() {

            row1.add( label1 );  // Título
            row1.add( field_title );
            panel_fields.add( row1 );

            row2.add( label2 );  // Género
            row2.add( select_gender );
            panel_fields.add( row2 );

            row3.add( label3 );  // Productora
            row3.add( field_prod );
            panel_fields.add( row3 );

            row4.add( label4 );  // Temporadas
            row4.add( field_seasons );
            panel_fields.add( row4 );

            row5.add( label5 );  // Último ep. visto
            row5.add( field_last_viewed );
            panel_fields.add( row5 );

            row6.add( label6 );  // Guardada en
            row6.add( select_store_media );
            panel_fields.add( row6 );

            // Check-boxes
            panel_checks.add( check_completed );
            panel_checks.add( check_cancelled );
            panel_layout_int.add( panel_checks );
        }
        
        /**
         * Adds components to panel
         * 
         */
        private void addComponentsToRatingsPanel()  {

            panel_rating.add( label9 );  // Puntuación
            panel_rating.add( r1 );
            panel_rating.add( r2 );
            panel_rating.add( r3 );
            panel_rating.add( r4 );
            panel_rating.add( r5 );
        }

} //class
