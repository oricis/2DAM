/**
 * @file: CreateTable.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package universal;

//imports
import java.sql.*;


/**
 * This class execute a "create table" sentence
 * 
 */
public class CreateTable {

    /**********************************/
    /*** Properties declaration *******/

        private Connection con;
        
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param sql
         * @param sgbd
         * @param db_name
         */
        public CreateTable( String sql, String sgbd, String db_name ) {
            System.out.println( "CreateTable / construct()" );
            
            //Guarda conexión para el SGBD
            con = GetConnection.get( sgbd, db_name );
                    
            //Ejecuta sentencia
            create( sql );
            
            //Cierra conexión
            try {
                System.out.println( "Cerrando conexión...\n" );
                con.close();
                
            } catch( SQLException e ) {
                System.out.println( "Error cerrando conexión." );
                System.out.println( e.toString( ));
            }
        }
        
        /**
         * Run sql sentence to create new table
         *
         * @param      sql   The sql
         */
        private void create( String sql ) {
            System.out.println( "CreateTable / create()" );

            System.out.println( "Ejecutando sentencia SQL..." );
            try ( Statement st = this.con.createStatement( )) {
                st.executeUpdate( sql );
                st.close();
                
            } catch( SQLException e ) {
                
                System.out.println( "Error creando tabla." );
                System.out.println( "---> " + e.toString( ));
            }
        }

} //class

//CREATE TABLE departamentos (
//  dept_no INT NOT NULL PRIMARY KEY,
//  dnombre VARCHAR(20),
//  loc VARCHAR(20));
//INSERT INTO departamentos VALUES(10, 'INFORMATICA', 'DESPA6');
//INSERT INTO departamentos VALUES(20, 'COMERCIO', 'DESPA7');
//INSERT INTO departamentos VALUES(30, 'ADMINISTRATIVO', 'DESPA8');
//INSERT INTO departamentos VALUES(40, 'FOL', 'DESPA5');
//SELECT * FROM DEPARTAMENTOS;
//CREATE TABLE profesores (
//  NRP 		INT(12) NOT NULL,
//  nombre 		VARCHAR(15) NOT NULL,
//  apellidos 	VARCHAR(40) NOT NULL,
//  email 		VARCHAR(50) NOT NULL,
//  fecha_alta 	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
//  dept_no 	INT(12) NOT NULL );
