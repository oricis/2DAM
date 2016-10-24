/**
 * @file: CreateDb.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package mysql;

//imports
import java.sql.*;
        
/**
 * This class create a Mysql DB
 * 
 */
public class CreateDb {

    /**********************************/
    /*** Properties declaration *******/
        
        private String db_name;
        
    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param db_name
         */
        public CreateDb( String db_name ) {
            
            //Set db name in class propertie
            this.db_name = db_name;
            
            
            // Try load driver
            try {
                Class.forName( DbConstants.JDBC_DRIVER );
                
            } catch( ClassNotFoundException e ) {
                
                System.out.println( "Error registrando driver." );
                System.out.println( e.getMessage( ));

		return;
            }

            
            System.out.println( "MySQL JDBC Driver registrado !" );
            System.out.println( "Conectando con la BD..." );
            Connection con;
            
            try {
                // Set BD connection
                // getConnection(url, nombre de usuario, contraseña) 
                con = DriverManager.getConnection(
                    DbConstants.JDBC_URL,
                    DbConstants.USER, 
                    DbConstants.PASS
                );
                
                // Execute instructions
                run( con );
                
                // Close connection 
                con.close();
                
                
            } catch( SQLException e ) {
                
                System.out.println( "Error de conexion." );
                System.out.println( e.getMessage( ));
            }
        }
        
        /**
         * Execute instructions
         * 
         */
        private void run( Connection con ) throws SQLException {
            
            String sql = "CREATE DATABASE IF NOT EXISTS " + db_name;
            
            try (Statement st = con.createStatement()) {
                st.executeUpdate( sql );
                st.close();
                
            } catch( SQLException e ) {
                
                System.out.println( "Error creando la BD." );
            }
        }
} //class
