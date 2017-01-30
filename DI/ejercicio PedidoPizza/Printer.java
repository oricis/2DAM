/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

//imports
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.stage.Stage;


/**
 * Handles printer tasks
 * 
 */
public class Printer {

    /**********************************/
	/*** Properties declaration *******/

		
	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Prints node content
		 *
		 * @param	str_order	The string order
		 * @param	stage		The stage
		 */
		public void run( Node str_order, Stage stage ) {

			//Creates a printer job
			PrinterJob job = PrinterJob.createPrinterJob();

			//Printer job has been created
			if ( job  != null ) {
				
				//Shows a Dialog for printer selection
				if ( job.showPrintDialog( stage )) {
					
					//Launches the impression
					if ( job.printPage( str_order ))
						job.endJob();	//finishes printer job
				}

			//printer job hasn´t been created
			} else
				System.out.println( "Err: printer job hasn´t been created" );
		}


	/**********************************/
	/*** Internal clases **************/


} //class
