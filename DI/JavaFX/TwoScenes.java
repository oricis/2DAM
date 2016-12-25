/**
 * @file: TwoScenes.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package practicas15;

//imports
import javafx.application.Application;
//import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




/**
 * Class
 * 
 */
public class TwoScenes extends Application {

	/**********************************/
	/*** Properties declaration *******/

		private Scene scene1, scene2;

		
	/**********************************/
	/*** Methods declaration

		/**
		 * Begins the App
		 *
		 * @param      stage  The stage
		 */
                @Override
		public void start( Stage stage ) {

			//Creates root nodes, one for every scene
			VBox layout1 = new VBox( 10 ); //new VBox( spacing_between_childrems );
			VBox layout2 = new VBox( 10 );
                        
                        //Configs root nodes
                        //layout1.setPadding( new Insets( 25, 25, 25, 25 ));
                        //layout2.setPadding( new Insets( 25, 25, 25, 25 ));
                        layout1.setAlignment( Pos.CENTER );
                        layout2.setAlignment( Pos.CENTER );
                        
			//Creates the elements for the GUI
			Label label1 = new Label( "Escena 1" );
			Label label2 = new Label( "Escena 2" );
			Button btn1  = new Button( "Cambia a escena 2" ); //Will be in scene 1
			Button btn2  = new Button( "Cambia a escena 1" ); //Will be in scene 2

			//Sets liteners in the buttons 
			btn1.setOnAction( e -> {  
				stage.setScene( scene2 ); 
			} );
			btn2.setOnAction( e -> {  
				stage.setScene( scene1 ); 
			} );

			//Adds the elements to root nodes
			layout1.getChildren().addAll( 
				label1, 
				btn1 
			);
			layout2.getChildren().addAll( 
				label2, 
				btn2 
			);

			//Instances the scenes
			scene1 = new Scene( layout1, 250, 150 );
			scene2 = new Scene( layout2, 250, 150 );

			//Configs the stage
			stage.setTitle( "Cambiar Escenas" );
			stage.setScene( scene1 );

			//Does visible the stage
			stage.show();
		}


		/**
		 * Main
		 *
		 * @param	args  The arguments
		 */
		public static void main( String[] args ) {

			launch( args );
		} 

} //class
