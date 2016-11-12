/**
 * @file: Frame.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.view;

//imports
import app.model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;


/**
 * This class handle App GUI functionalities
 * 
 */
public class Frame extends LayoutComposer {

	/**********************************/
	/*** Properties declaration *******/

		private boolean check_1_selected = false;
		private boolean check_2_selected = false;
		private boolean check_3_selected = false;
		private boolean check_4_selected = false;

		private String micro_selected    = "";
		private String ram_selected      = "";
		private String monitor_selected  = "";

		private String price_micro		 = "";
		private String price_ram		 = "";
		private String price_monitor	 = "";
		private String price_var		 = "";

		private String coin = "€";
		private int price   = 0;
		private int total   = 0;
                
		private int pos;
                
                String res = "Lista de componentes seleccionados \n";
                
		
	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 *
		 */
		public Frame() {

            //Add listener to the button
            print_btn.addActionListener( new AppListener( ));
        }
		
        /**
         * Prints list with the components selected from GUI
         * 
         */
		private void printComponentsList() {
			
            res = res + "----------------------------------------- \n";

			res = res +  "Microprocesador: " + micro_selected;
			res = res +  " / Precio: " + price_micro + "\n";

            res = res +  "Memoria RAM: " + ram_selected;
			res = res +  " / Precio: " + price_ram + "\n";

            res = res +  "Monitor: " + monitor_selected;
			res = res +  " / Precio: " + price_monitor + "\n";

            setPeripherals();
            
            res = res + "\n\nTotal: " + total + coin;

            //Traza
            System.out.println( res );

            //This component won't be adding to GUI, only will be populated with the text
            JTextArea jta = new JTextArea();
            jta.setText( res );

            //Run print service
            try {
            	jta.print();

            } catch( Exception e ) {
            	System.out.println( "Error imprimiendo presupuesto" );
            	System.out.println( "---> " + e.toString( ));
            }
		}

		/**
		 * Aux. printComponentsList()
		 * 
		 */
		private void setPeripherals() {

			res = res +  "Periféricos: \n";

			if ( check_1_selected ) {
            	price = Model.P_VARS[ 0 ];
            	res = res + "   - " + Model.VARS[ 0 ];
				res = res +  " / Precio: " + price + coin + "\n";

				total = total + price;
            }
                
            if ( check_2_selected ) {
            	price = Model.P_VARS[ 1 ];
            	res = res + "   - " + Model.VARS[ 1 ];
				res = res +  " / Precio: " + price + coin + "\n";

				total = total + price;
            }
                
            if ( check_3_selected ) {
            	price = Model.P_VARS[ 2 ];
				res = res + "   - " + Model.VARS[ 2 ];
				res = res +  " / Precio: " + price + coin + "\n";

				total = total + price;
            }
                
            if ( check_4_selected ) {
            	price = Model.P_VARS[ 3 ];
				res = res + "   - " + Model.VARS[ 3 ];
				res = res +  " / Precio: " + price + coin + "\n";

				total = total + price;
            }
		}


	/**********************************/
	/*** Internal clases **************/

		/**
		 * Class for application listener
		 * 
		 */
		private class AppListener implements ActionListener {

			@Override
			public void actionPerformed( ActionEvent e ) {
				
				GUIData gd = new GUIData();
				
				//Sets the selected peripherals
				gd.setCheckboxes();
				
				//Sets the selected components
				gd.setMicro();
				gd.setRAM();
				gd.setMonitor();
				
				
				//Prints list with the components selected 
				printComponentsList();
			}
			
		} //class
		
		/**
		 * Class for handle GUI data
		 * 
		 */
		private class GUIData {
			
			/**
			 * Sets the selected microprocessor
			 * 
			 */
			public void setMicro() {
				if ( r_micros_1.isSelected( ))
					pos = 0;

				if ( r_micros_2.isSelected( ))
					pos = 1;

				if ( r_micros_3.isSelected( ))
					pos = 2;

				if ( r_micros_4.isSelected( ))
					pos = 3;


				micro_selected = Model.MICROS[ pos ];
				price_micro    = Model.P_MICROS[ pos ] + coin;
				total = total + Model.P_MICROS[ pos ];
			}

			/**
			 * Sets the selected RAM
			 * 
			 */
			public void setRAM() {
				if ( r_ram_1.isSelected( ))
					pos = 0;

				if ( r_ram_2.isSelected( ))
					pos = 1;

				if ( r_ram_3.isSelected( ))
					pos = 2;

				if ( r_ram_4.isSelected( ))
					pos = 3;


				ram_selected = Model.RAMS[ pos ];
				price_ram    = Model.P_RAMS[ pos ] + coin;
				total = total + Model.P_RAMS[ pos ];
			}

			/**
			 * Sets the selected monitor
			 * 
			 */
			public void setMonitor() {
				if ( r_mtores_1.isSelected( ))
					pos = 0;

				if ( r_mtores_2.isSelected( ))
					pos = 1;

				if ( r_mtores_3.isSelected( ))
					pos = 2;

				if ( r_mtores_4.isSelected( ))
					pos = 3;


				monitor_selected = Model.MTORES[ pos ];
				price_monitor    = Model.P_MTORES[ pos ] + coin;
				total = total + Model.P_MTORES[ pos ];
			}

			/**
			 * Sets the selected checkboxes
			 * 
			 */
			public void setCheckboxes() {

				check_1_selected = check_1.isSelected();
				check_2_selected = check_2.isSelected();
				check_3_selected = check_3.isSelected();
				check_4_selected = check_4.isSelected();
			}

		} //class

} //class
