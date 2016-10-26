/**
 * @file: Practica_10_2.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package practicas;

//imports
import java.sql.*;


/**
 * This class solve practice 10.2 - CallableStatement
 * 
 * Programa que ejecuta el procedimiento "subida_sal" ya creado en MySQL:
 * el procedimiento "subida_sal" permite subir el salario a los profesores de un dept.
 * 
 */
public class Practica_10_2 {

    /**********************************/
    /*** Properties declaration *******/

        private Connection con;
        private CallableStatement cs;

        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         *
         * @param salary_increment
         * @param dept_name
         */
        public Practica_10_2( int salary_increment, String dept_name ) {
            System.out.println( "Practica_10_2 / Construct()" );
        
            
            //Abrir conexión
            con = universal.GetConnection.get( "mysql", mysql.DbConstants.DB_NAME );
            
            try {
                String sentence = "CALL subida_sal( ?, ? )";
                cs = con.prepareCall( sentence );

                System.out.println( "Cargando parámetros..." );
                cs.setInt(   1, salary_increment );
                cs.setString( 2, dept_name );

                System.out.println( "Ejecutando llamada al procedimiento..." );
                cs.executeUpdate();

                System.out.println( "Actualización completada. \n" );
                

            } catch( SQLException e ) {
                
                System.out.println( "Error con el CallableStatement..." );
                System.out.println( "---> " + e.toString( ));
            }

            //Free resources
            try {
                System.out.println( "Cerrando CallableStatement..." );
                cs.close();

                System.out.println( "Cerrando Connection..." );
                con.close();

            } catch( SQLException e ) {

                System.out.println( "Error librerando recursos..." );
                System.out.println( "---> " + e.toString( ));
            }
        }
        
} //class
