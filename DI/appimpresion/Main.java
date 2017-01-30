/*
 * UD.19 - JavaFx
 * Checks, redios e impresión
 * 
 * Ejercicio 1. Simulación pedido pizza.
 * Construir una app que recoja datos del usuario de varios inputs, 
 * radios y checkboxes e imprima el resultado.
 * 
 */
package app;

//imports
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Main class
 * 
 */
public class Main extends Application {

	/**********************************/
	/*** Properties declaration *******/

		private Button btn 		 = new Button( "Imprimir" );
		private Label label1 	 = new Label( "Introduce texto:" );
		private Label label2 	 = new Label( "Texto que se imprimirá:" );
		private Label res 	 	 = new Label();
		private TextArea entrada = new TextArea();
		private VBox panel;

		private Stage stage;


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Main
		 *
		 * @param   args	The arguments
		 */
		public static void main( String[] args ) {
			Application.launch( args );
		}

		@Override
		public void start( Stage stage ) {
			this.stage = stage;

			createPanel();
			setBinding();
			setListeners();

			Scene scene = new Scene( panel, 220, 200 );
			//scene.setFill( Color.ALICEBLUE );
			stage.setTitle( "Ventana entrada impresión" );
			stage.setScene( scene );
			stage.show();
		}

		/**
		 * Creates a panel
		 * 
		 */
		private void createPanel() {

			entrada.setFont( Font.font( "Arial", 15 ));
			entrada.setStyle( "-fx-text-fill: blue;" );
			entrada.setPrefSize( 200, 60 );
			res.setFont( Font.font( "Arial", 15 ));
			res.setTextFill( Color.GREEN );


			//Instances the panel
			panel = new VBox( label1, entrada, label2, res, btn );

			panel.setAlignment( Pos.CENTER );
			panel.setSpacing( 10 );
			panel.setPadding( new Insets( 10 ));
		}

		/**
		 * Sets the binding between components
		 * 
		 */
		private void setBinding() {

			//entrada.textProperty().bind( res.textProperty( )); //ERR -> input is not editable
			res.textProperty().bind( entrada.textProperty( ));
		}

		/**
		 * Sets the listeners
		 * 
		 */
		private void setListeners() {

			btn.setOnAction( e -> {
				System.out.println( "Button has been pushed!" );

				new Printer().run( entrada, stage );
			}); 
		}


	/**********************************/
	/*** Internal classes *************/


} //class
