package controles;

//imports
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * ChoiceBox
 *
 */
public class MiChoiceBox extends Application {

	final Label label = new Label();


	public static void main( String[] args ) {
		launch( args );
	}

	@Override 
	public void start( Stage stage ) {
	  
		label.setFont( Font.font( "Arial", 25 ));
		//label.setLayoutX( 40 );
 
		String[] contenidosP = new String[] {
			"Esto es la Palabra 1",  
			"Esto es la Palabra 2", 
			"Esto es la Palabra 3",  
			"Esto es la Palabra 4", 
			"Esto es la Palabra 5"
		};

		//Crear el Choice Box: 
		ChoiceBox cb = new ChoiceBox( 
			FXCollections.observableArrayList( 
				"Palabra 1",
				"Palabra 2",
				"Palabra 3",
				"Palabra 4",
				"Palabra 5" 
			) 
		);
		
		//establecer un escuchador al ChoiceBox	:							 
		cb.getSelectionModel( ).selectedIndexProperty( ).addListener( 
			( ov, old_val, new_val ) -> {
				label.setText( contenidosP[new_val.intValue( )] );			 
			} 
		);

		//tooltip para choicebox:	 
		cb.setTooltip( new Tooltip( "Selecciona palabra" ));

		//valor por defecto del choicebox: 
		cb.setValue( "Palabra 1" );
		 
		//panel y escena: 
		HBox hb = new HBox();
		hb.getChildren( ).addAll( cb, label );
		hb.setSpacing( 30 );
		hb.setAlignment( Pos.CENTER );
		hb.setPadding( new Insets( 10, 0, 0, 10 ));
 
		Scene scene = new Scene( hb, 400, 200 );
		scene.setFill( Color.ALICEBLUE );
		stage.setTitle( "ChoiceBox Ejemplo" );
		stage.setScene( scene );
		stage.show();
	}

} //class
 
