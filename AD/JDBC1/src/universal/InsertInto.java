/**
 * @file: InsertInto.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package universal;

//imports
import derby.DbConnection;
import java.sql.*;


/**
 * This class execute a "create table" sentence
 * 
 */
public class InsertInto {

    /**********************************/
    /*** Properties declaration *******/

        private Connection con;
        
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param arr_sql
         * @param sgbd
         * @param db_name
         */
        public InsertInto( String[] arr_sql, String sgbd, String db_name ) {
            System.out.println( "InsertInto / construct()" );
            
            //Guarda conexión para el SGBD
            con = GetConnection.get( sgbd, db_name );
                    
            //Ejecuta sentencias
            insert( arr_sql );
            
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
         * @param      arr_sql   The sql sentences
         */
        private void insert( String[] arr_sql ) {
            System.out.println( "InsertInto / insert()" );

            System.out.println( "Ejecutando sentencias SQL..." );
            try ( Statement st = this.con.createStatement( )) {
                
                System.out.println( "Statement creado !" );
                
                //Cuenta los strings del array
                int len = arr_sql.length;
                int i   = 0;
                
                while ( i < len ) {
                    
                    st.executeUpdate( arr_sql[ i ] );
                    i++;
                }
                
                System.out.println( "Cerrando conexión..." );
                st.close();
                
            } catch( SQLException e ) {
                
                System.out.println( "Error realizando inserts." );
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
