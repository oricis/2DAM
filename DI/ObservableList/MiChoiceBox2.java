/**
 * 5. Ejercicio 
 * Modifica el ejemplo del ChoiceBox de la unidad anterior para que se pueda 
 * añadir elementos al Choicebox mediante un campo de texto y un botón
 * 
 */
package app;

//imports
import helpers.Trace;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * ChoiceBox
 *
 */
public class MiChoiceBox2 extends Application {

	/**********************************/
	/*** Properties declaration *******/

		final Label label_res = new Label();
		final Label label_in  = new Label( "Introducir elemento: " );
		final TextField input = new TextField();
		final Button btn 	  = new Button( "añadir" );


		private ChoiceBox cb;
		private List options  = new ArrayList();
		private List results  = new ArrayList();
		private ObservableList<String> obList_options;
		private ObservableList<String> obList_results;

		private String[] arr_res  = new String[] {
			"Palabra 1",
			"Palabra 2",
			"Palabra 3",
			"Palabra 4",
			"Palabra 5" 
		};
		private String[] arr_strs = new String[] {
			"Esto es la Palabra: 1",  
			"Esto es la Palabra: 2", 
			"Esto es la Palabra: 3",  
			"Esto es la Palabra: 4", 
			"Esto es la Palabra: 5"
		};
		


	/**********************************/
	/*** Methods declaration **********/

		public static void main( String[] args ) {
			launch( args );
		}

		@Override 
		public void start( Stage stage ) {
			
			options = new Utils().addStrArray( options, arr_strs );
			results = new Utils().addStrArray( results, arr_res );
			obList_results = FXCollections.observableList( results );
			obList_options = FXCollections.observableList( options );
			

			
			VBox panel = createPanel();
			addListeners();
			


			Scene scene = new Scene( panel, 380, 200 );
			scene.setFill( Color.ALICEBLUE );
			stage.setTitle( "ChoiceBox Ejemplo" );
			stage.setScene( scene );

			stage.show();
		}

		/**
		 * Creates the GUI
		 *
		 * @return 	panel
		 */
		private VBox createPanel() {
			VBox panel 	= new VBox();
			HBox hb1 	= new HBox();	//input group
			VBox hb2 	= new VBox();	//select group

			hb1.setSpacing( 10 ); 
			hb1.setAlignment( Pos.CENTER );
			hb2.setSpacing( 10 );
			hb2.setAlignment( Pos.CENTER );

			panel.setSpacing( 30 );
			panel.setAlignment( Pos.CENTER );
			panel.setPadding( new Insets( 10, 0, 0, 10 ));


			label_res.setFont( Font.font( "Arial", 25 ));
			
			cb = new ChoiceBox( obList_results );
			cb.setTooltip( 
				new Tooltip( "Selecciona palabra" ) //tooltip for the choicebox	
			);
			cb.setValue( "Palabra 1" ); //default value
                        

			hb1.getChildren().addAll( 
				label_in,
				input,
				btn 
			);
			hb2.getChildren().addAll( 
				cb, 
				label_res
			);

			panel.getChildren().addAll( 
				hb1,
				hb2
			);

			return panel;
		}

		/**
		 * Adds the listeners
		 * 
		 */
		private void addListeners() {
			
			// Listener for the TextField
			btn.setOnAction( e -> {
				Trace.ln( "Button has been pushed!" );

				String str = input.getText();
				Trace.ln( "Entrada: " + str );

				if ( ! str.equals( "" ))
					addNewStr( str );
			}); 
			
			// Listener for the ChoiceBox
			cb.getSelectionModel( ).selectedIndexProperty( ).addListener( 
				( ov, old_val, new_val ) -> {
					label_res.setText( 
						options.get( new_val.intValue()).toString()
					);			 
				} 
			);
		}

		private void addNewStr( String str ) {

			obList_options.add( "Esto es la Palabra: " + str );
			obList_results.add( str );
		}


	/**********************************/
	/*** Internal classes *************/

		class Utils {

			List<String> addStrArray( List<String> o, String[] arr ) {

				for ( String str : arr ) {
					o.add( str );
				}


				return o;
			}

		} //class
} //class
