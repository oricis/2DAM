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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Main class
 * 
 */
public class Main extends Application {

	/**********************************/
	/*** Properties declaration *******/

		//Components
		private Button btn_accept	= new Button( "Aceptar" );
		private Button btn_cancel	= new Button( "Cancelar" );

		private Label lbl_name 		= new Label( "Nombre:" );
		private Label lbl_address 	= new Label( "Dirección:" );
		private Label lbl_tlf 		= new Label( "Teléfono:" );

		private Label lbl_dough		= new Label( "Masa:" );
		private Label lbl_ingredts	= new Label( "Ingredientes:" );
		private Label lbl_message 	= new Label( "¡Haga su pedido ahora!" );
		private Label lbl_size 		= new Label( "Tamaño:" );
		
		private TextField input_name	= new TextField();
		private TextField input_address	= new TextField();
		private TextField input_tlf		= new TextField();

		//Components of group
		private CheckBox cb1 = new CheckBox( "Peperonni" );
		private CheckBox cb2 = new CheckBox( "Salchicha" );
		private CheckBox cb3 = new CheckBox( "Parmesano" );
		private CheckBox cb4 = new CheckBox( "Olivas" );
		private CheckBox cb5 = new CheckBox( "Champiñon" );
		private CheckBox cb6 = new CheckBox( "Tomates" );
		private CheckBox cb7 = new CheckBox( "Anchoas" );

		private RadioButton rb_dough_slim	= new RadioButton( "Delgada" );
		private RadioButton rb_dough_huge	= new RadioButton( "Gruesa" );

		private RadioButton rb_size_small	= new RadioButton( "Pequeña" );
		private RadioButton rb_size_medium	= new RadioButton( "Mediana" );
		private RadioButton rb_size_big		= new RadioButton( "Grande" );

		private ToggleGroup group_dough		= new ToggleGroup();
		private ToggleGroup group_size		= new ToggleGroup();


		//panels
		private VBox panel; //main panel
		private VBox panel_a, panel_b, panel_dough, panel_ingredts, panel_size;
		private HBox panel_inputs, panel_selections, panel_buttons;

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

			configureComponents();
			createPanel();
			setListeners();

			Scene scene = new Scene( panel, 400, 420 );
			stage.setTitle( "Pedido de pizza" );
			stage.setScene( scene );
			stage.show();
		}

		/**
		 * Configures the GUI components
		 * 
		 */
		private void configureComponents() {
			setRadioGroups(); //Groupes radios
			
			lbl_message.setFont( Font.font( "Arial", 18 ));

			input_address.setPrefWidth( 220 );
			input_name.setPrefWidth( 220 );
			input_tlf.setPrefWidth( 220 );

			rb_dough_slim.setSelected( true );
			rb_size_medium.setSelected( true );
		}

		/**
		 * Configures the panels
		 * 
		 */
		private void configurePanels() {

			//Main panel
			panel.setSpacing( 10 );
			panel.setPadding( new Insets( 10 ));

			panel_a.setSpacing( 18 );
			panel_a.setAlignment( Pos.CENTER_LEFT );
			panel_b.setSpacing( 10 );

			panel_dough.setSpacing( 10 );
			panel_ingredts.setSpacing( 10 );
			panel_size.setSpacing( 10 );


			//Panel to input personal data 
			panel_inputs.setPadding( new Insets( 10, 30, 10, 30 ));
			panel_inputs.setSpacing( 30 );
			panel_inputs.setStyle(
				"-fx-border-style: solid inside;" + 
				"-fx-border-radius: 5;" + 
				"-fx-border-color: grey;"
			);

			//Panel selection ingredients, dough and size of pizzas
			panel_selections.setAlignment( Pos.CENTER );
			panel_selections.setPadding( new Insets( 10 ));
			panel_selections.setSpacing( 40 );
			panel_selections.setStyle(
				"-fx-border-style: solid inside;" + 
				"-fx-border-radius: 5;" + 
				"-fx-border-color: grey;"
			);

			//Panel with buttons
			panel_buttons.setAlignment( Pos.BOTTOM_RIGHT );
			panel_buttons.setSpacing( 10 );
		}

		/**
		 * Creates a panel
		 * 
		 */
		private void createPanel() {
			
			//Vertical panels
			panel_a			= new VBox( lbl_name, lbl_address, lbl_tlf );
			panel_b			= new VBox( input_name, input_address, input_tlf );
			panel_dough		= new VBox( lbl_dough, rb_dough_slim, rb_dough_huge );
			panel_ingredts	= new VBox( lbl_ingredts, cb1, cb2, cb3, cb4, cb5, cb6, cb7 );
			panel_size		= new VBox( lbl_size, rb_size_small, rb_size_medium, rb_size_big );

			//Horizontal panels
			panel_inputs 	 = new HBox( panel_a, panel_b );
			panel_selections = new HBox( panel_dough, panel_ingredts, panel_size );
			panel_buttons 	 = new HBox( btn_accept, btn_cancel );

			//Main panel
			panel = new VBox( lbl_message, panel_inputs, panel_selections, panel_buttons );

			//Panel spacing / padding / borders
			configurePanels();
		}

		/**
		 * Returns the GUI to the initial state (nothing selected, 
		 * but personal data is maintained)
		 * 
		 */
		private void resetGUI() {

			input_name.setText( "" );
			input_address.setText( "" );
			input_tlf.setText( "" );

			cb1.setSelected( false );
			cb2.setSelected( false );
			cb3.setSelected( false );
			cb4.setSelected( false );
			cb5.setSelected( false );
			cb6.setSelected( false );
			cb7.setSelected( false );
			rb_dough_slim.setSelected( true );
			rb_dough_huge.setSelected( false );
			rb_size_small.setSelected( false );
			rb_size_medium.setSelected( true );
			rb_size_big.setSelected( false );
		}

		/**
		 * Groupes radios
		 * 
		 */
		private void setRadioGroups() {

			group_dough.getToggles().addAll( 
				rb_dough_slim,
				rb_dough_huge
			);
			group_size.getToggles().addAll( 
				rb_size_small,
				rb_size_medium,
				rb_size_big
			);
		}

		/**
		 * Sets the listeners
		 * 
		 */
		private void setListeners() {

			btn_accept.setOnAction( e -> {
				//System.out.println( "\"btn_accept\" has been pushed!" );

				new Printer().run( panel, stage );
			});
			btn_cancel.setOnAction( e -> {
				//System.out.println( "\"btn_cancel\" has been pushed!" );

				resetGUI();
			});
		}

} //class
