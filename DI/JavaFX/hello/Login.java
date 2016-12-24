package hello;

import javafx.application.Application; 
//import javafx.event.ActionEvent; 
import javafx.geometry.Insets; 
import javafx.geometry.Orientation;
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.GridPane; 
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color; 
import javafx.scene.text.*; 
import javafx.stage.Stage;

/**
 * Class for generate a GUI: login form
 * Added links for register user and remember password
 * 
 */
public class Login extends Application {

    @Override 
    public void start( Stage primaryStage ) {
        
        //Nodo raíz tipo GridPane (similar a GridLayout de Swing) 
        GridPane grid = new GridPane();

        /**
         * Descomentar siguiente línea para crear la GUI
         * 
         */
        //grid.setGridLinesVisible( true );
        

        //Alinea al cento el GridPane
        grid.setAlignment( Pos.CENTER );

        //distancia horizontal y vertical entre elementos  
        grid.setHgap( 10 );
        grid.setVgap( 10 );
        
        //Distancia entre el GridPane y el resto de los elementos   
        //externos al gridpane  
        //grid.setPadding( new Insets( 25, 25, 25, 25 ));
        
        //Crear un texto y establecer tipo y tamaño de la fuente 
        Text title = new Text( "Welcome" );
        title.setFont(  
            Font.font( "Tahoma", FontWeight.NORMAL, 20 ) 
        );
        
        //Añade el texto al nodo raiz, en la columna 0, fila 0,   
        // con 2 de colspan y 0 de rowspan 
        grid.add( title, 0, 0, 2, 1 ); //add( elemento, ncol, nrow, colspan, rowspan );
        
        //Crear una etiqueta y añadirla a la columna 0 fila 1
        //grid.add( new Text( "User Name:" ), 0, 1 );
        grid.add( new Label( "User Name:" ), 0, 1 ); 
        
        //Crear un campo de texto. Añadirlo a la columna 1 fila 1
        grid.add( new TextField(), 1, 1 );
        
        //Crear una etiqueta. Añadirla a la columna 0 fila 2
        grid.add( new Label( "Password:" ), 0, 2 );
        
        //Campo de contraseña, Se añade a la columna 1 fila 2
        grid.add( new PasswordField(), 1, 2 ); 
        
        //Botón en columna 1 fila 4  
        Button btn = new Button( "Sign in" ); 
        grid.add( btn, 1, 4 );

        //Enlaces registro / recordar
        addLinks( grid );

        //texto, en princio vacío para usar en el evento del botón  
        final Text actiontarget = new Text(); 
        grid.add( actiontarget, 1, 7 );

        //evento del botón  
        btn.setOnAction( e -> { 
            actiontarget.setFill( Color.FIREBRICK ); 
            actiontarget.setText( "Sign in button pressed" ); 
        });  

        //Creamos la escena 
        Scene scene = new Scene( grid, 300, 275 ); 
        primaryStage.setScene( scene ); 
        primaryStage.setTitle( "JavaFX Welcome" ); 
        primaryStage.show(); 
    }
    
    /**
     * Adds links to register user and remember password
     * 
     * @param grid 
     */
    private void addLinks( GridPane grid ) {
        HBox hbox = new HBox(); 

        hbox.getChildren().addAll(
            new Hyperlink ( "Registrarse" ),
            new Separator( Orientation.VERTICAL ),
            new Hyperlink ( "Recordar pw" )
        );

        grid.add( hbox, 1, 5 );
    }

    /**
     * Main method
     * 
     * @param args 
     */
    public static void main( String[] args ) { 
        launch( args ); 
    }
    
} //class