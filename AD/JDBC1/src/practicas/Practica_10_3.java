/**
 * @file: Practica_10_3.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package practicas;

//imports
import java.sql.*;


/**
 * This class solve practice 10.3 - CallableStatement
 * 
 * Programa basado en el anterior para ejecutar el procedimiento y la función: 
 * "p_nombredep" y "f_nombredep" respectivamente, anteriormento creados en MySQL.
 * El procedimiento y la función tienen el mismo comportamiento: devuelva el 
 * nombre de un departamento.
 * 
 */
public class Practica_10_3 {

    /**********************************/
    /*** Properties declaration *******/

        private Connection con;
        private CallableStatement cs_procedure, cs_function;
        private ResultSet rs1, rs2;
        private String name;

        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         *
         * @param dept_no
         */
        public Practica_10_3( int dept_no ) {
            System.out.println( "Practica_10_3 / Construct()" );
        
            
            //Abrir conexión
            con = universal.GetConnection.get( "mysql", mysql.DbConstants.DB_NAME );
            
            try {
                String str_procedure = "CALL p_nombredep( ? )";
                String str_function  = "SELECT f_nombredep( ? )";

                System.out.println( "Creando CallableStatements..." );
                cs_procedure = con.prepareCall( str_procedure );
                cs_function  = con.prepareCall( str_function );

                System.out.println( "Cargando parámetros..." );
                cs_procedure.setInt( 1, dept_no );
                cs_function.setInt(  1, dept_no );

                System.out.println( "Ejecutando llamada al procedimiento..." );
                if ( cs_procedure.execute( ))
                    rs1 = cs_procedure.getResultSet();

                System.out.println( "Ejecutando llamada a la función..." );
                if ( cs_function.execute( ))
                    rs2 = cs_function.getResultSet();

                //Show results from queries 
                showResults( dept_no );


            } catch( SQLException e ) {
                
                System.out.println( "Error en la ejecución..." );
                System.out.println( "---> " + e.toString( ));
            }

            //Free resources
            try {
                System.out.println( "Liberando resursos...\n" );

                System.out.println( "Cerrando ResultSets..." );
                rs1.close();
                rs2.close();

                System.out.println( "Cerrando CallableStatements..." );
                cs_procedure.close();
                cs_function.close();

                System.out.println( "Cerrando Connection..." );
                con.close();


            } catch( SQLException e ) {

                System.out.println( "Error librerando recursos..." );
                System.out.println( "---> " + e.toString( ));
            }
        }
        
        /**
         * Show results from queries 
         *
         * @param   dept_no  The dept no
         */
        private void showResults( int dept_no ) {
            
            System.out.println( "\n----------------------" );

            try {
                rs1.next();
                name = rs1.getString( 1 );
                System.out.println( "Resultado llamada a procedimiento almacenado." );
                System.out.println( "Dept número " + dept_no + " -> " + name );

                System.out.println( "----------------------" );

                rs2.next();
                name = rs2.getString( 1 );
                System.out.println( "Resultado llamada a la función almacenada." );
                System.out.println( "Dept número " + dept_no + " -> " + name );
                
            } catch( SQLException e ) {
                
                System.out.println( "Error obteniendo resultados..." );
                System.out.println( "---> " + e.toString( ));
            }

            System.out.println( "----------------------\n" );
        }

} //class
