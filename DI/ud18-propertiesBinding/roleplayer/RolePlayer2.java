/*
 * JavaFx - Ud18
 * Ejercicio 2* -> Crear programa, usando vinculación, con tres campos de entrada de texto, 
 * el primero para un título de película, otro para el nombre de un personaje y el último del 
 * actor que lo interpreta, que completaran al introducir contenido una frase en la parte 
 * inferior, tal como: "Viaje a Marte", conto con "M. Devon" en el papel de "Crispín"
 * 
 */
package roleplayer;

//imports
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RolePlayer2 extends javafx.application.Application {

	/**********************************/
	/*** Properties declaration *******/

		private final Label first 	= new Label( ", conto con " );
		private final Label second	= new Label( " en el papel de " );
		private Label actor 		= new Label();
		private Label character 	= new Label();
		private Label film 			= new Label();

		private Label label_in_actor 	= new Label( "Name of actor / actress: " );
		private Label label_in_character = new Label( "Character played: " );
		private Label label_in_film  	= new Label( "Film title: " );
		private TextField in_actor 		= new TextField();
		private TextField in_character 	= new TextField();
		private TextField in_film  		= new TextField();

		private HBox file1 	= new HBox();
		private HBox file2 	= new HBox();
		private HBox file3 	= new HBox();
		private HBox res 	= new HBox();
		private VBox inputs = new VBox();
		private VBox panel 	= new VBox();

		private double w;
		private DoubleProperty width = new SimpleDoubleProperty();
		

	/**********************************/
	/*** Methods declaration **********/

		public static void main( String[] args ) { 
			launch( args );
		}

		@Override
		public void start( Stage primaryStage ) {
			
			configComponents();
			createPanel();
			setBinding();
			//traceWidthOfPanels();	//trace

			Scene scene = new Scene( panel, width.get(), 200 );
			//traceWidthOfPanels();	//trace

			scene.setFill( Color.ALICEBLUE );
			primaryStage.setTitle( "Role Player" );
			primaryStage.setScene( scene );
			//traceWidthOfPanels();	//trace
			primaryStage.show();

			
			traceWidthOfPanels();	//trace
		}

		/**
		 * Creates the main panel
		 * 
		 */
		private void createPanel() {

			//Film title
			file1.getChildren().addAll(
				label_in_film,
				in_film
			);

			//Actor name
			file2.getChildren().addAll(
				label_in_actor,
				in_actor
			);

			//Character name
			file3.getChildren().addAll(
				label_in_character,
				in_character
			);

			//Composes the phrase
			res.getChildren().addAll(
				film,
				first,
				actor,
				second,
				character
			);

			inputs.getChildren().addAll(
				file1,
				file2,
				file3
			);
			panel.getChildren().addAll(
				inputs,
				res
			);
		}

		/**
		 * Configs the panel components
		 * 
		 */
		private void configComponents() {
			//VBox.setSpacing( double value )
			//The amount of vertical space between each child in the vbox.

			res.setPrefWidth( 420 );
    
			file1.setSpacing( 10 );
			file1.setAlignment( Pos.CENTER_RIGHT );
			file2.setSpacing( 10 );
			file2.setAlignment( Pos.CENTER_RIGHT );
			file3.setSpacing( 10 );
			file3.setAlignment( Pos.CENTER_RIGHT );
			res.setAlignment( Pos.CENTER );
			
			inputs.setPadding( new Insets( 10, 50, 0, 0 ));
			inputs.setSpacing( 20 );
			panel.setAlignment( Pos.CENTER );
			panel.setPadding( new Insets( 10 ));
			res.setPadding(   new Insets( 25, 0, 5, 0 ));
			//Insets( double top, double right, double bottom, double left )
			
			//in_film.setPromptText( "La película" );  //placeholder
			
			//Adds text styles
			label_in_film.setFont( 		Font.font( "Arial", 14 ));
			label_in_actor.setFont( 	Font.font( "Arial", 14 ));
			label_in_character.setFont( Font.font( "Arial", 14 ));
			first.setFont( 	Font.font( "Arial", 18 ));
			second.setFont( Font.font( "Arial", 18 ));
			actor.setFont( 	Font.font( "Arial", 18 ));
			character.setFont( Font.font( "Arial", 18 ));
			film.setFont( 	Font.font( "Arial", 18 ));
			actor.setTextFill( 		Color.BLUE );
			character.setTextFill( 	Color.BLUE );
			film.setTextFill( 		Color.BLUE );
		}

		/**
		 * Sets the binding between components
		 * 
		 */
		private void setBinding() {

			//in_film.textProperty().bind( film.textProperty( )); //ERR -> input is not editable
			film.textProperty().bind( in_film.textProperty( ));
			actor.textProperty().bind( in_actor.textProperty( )); 
			character.textProperty().bind( in_character.textProperty( ));

			width.setValue( res.getWidth( ));
		}

		/**
		 * Shows the width of panels
		 * 
		 */
		private void traceWidthOfPanels() {
			
			w = res.getWidth();
			System.out.println( "Ancho panel resultados: " + w );

			w = inputs.getWidth();
			System.out.println( "Ancho panel inputs: " + w );

			w = panel.getWidth();
			System.out.println( "Ancho panel general: " + w );

			//Width and height are not initialized until you put node in a container 
			//actually placed on the scene, because they can change depending on container type.
		}

			
	/**********************************/
	/*** Internal classes *************/
	

} //class
