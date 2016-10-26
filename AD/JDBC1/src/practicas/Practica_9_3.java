/**
 * @file: Practica_9_3.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package practicas;

//imports
import java.sql.*;


/**
 * This class solve practice 9.3 - PreparedStatement
 * 
 * Obtener, por orden alfabético los datos de los profesores de un departamento,
 * con salario superior a una cantidad. 
 * Introducir departamento y cantidad por línea de argumentos del main.
 * 
 */
public class Practica_9_3 {

    /**********************************/
    /*** Properties declaration *******/

        private Connection con;
        private PreparedStatement pst;
        private ResultSet rs;

        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param args
         */
        public Practica_9_3( String[] args ) {
            
            //Number of args diferent to three -> finalize execution
            if ( args.length != 3 ) {
                System.out.println( "Número de argumentos incorrecto." );
                
                //Finalize execution
                System.exit( 0 );
            }
            
            //Get data
            String sgbd = args[ 0 ];
            String dept = args[ 1 ];
            int salary  = 0;
            
            try {
                salary  = Integer.parseInt( args[ 2 ] ); //int
                
            } catch( NumberFormatException e ) {
                
                System.out.println( "Error: el tercer parámetro debe ser un entero" );
                System.out.println( "---> " + e.toString( ));
                
                //Finalize execution
                System.exit( 0 );
            }
            
            
            if ( "mysql".equals( sgbd )) {

                //Set base query
                String sql = "SELECT nombre, apellidos, salario FROM profesores"
                    + " WHERE salario > ? AND "
                    + " dept_no=(SELECT dept_no FROM departamentos WHERE dnombre=?)"
                    + " ORDER BY nombre ASC";
                System.out.println( "SQL*: " + sql );
                
                //Open and get connection
                con = universal.GetConnection.get( sgbd, mysql.DbConstants.DB_NAME );

                try {
                    
                    //Create PreparedStatement
                    System.out.println( "Creando PreparedStatement..." );
                    pst = con.prepareStatement( sql );

                    //Set PreparedStatement params
                    System.out.println( "Seteando parámetros..." );
                    pst.setInt(    1, salary );
                    pst.setString( 2, dept );
                    

                    System.out.println( "Ejecutando sentencia..." );
                    rs = pst.executeQuery();
                    // SELECT nombre, apellidos, salario FROM profesores 
                    // WHERE salario > 1000 AND dept_no=(
                    //   SELECT dept_no FROM departamentos WHERE dnombre='FOL') 
                    //   ORDER BY nombre ASC

                    System.out.println( "\nResultados:" );
                    while ( rs.next( )) {

                        System.out.print( rs.getString( "nombre" ) + " " );
                        System.out.print( rs.getString( "apellidos" ));
                        System.out.println( " / Salario: " + rs.getInt( "salario" ));
                    }
                    System.out.println( "---------------------------------\n" );
                    
                    //Free resources
                    System.out.println( "Cerrando PreparedStatement..." );
                    pst.close();

                    System.out.println( "Cerrando Connection..." );
                    con.close();

                } catch( SQLException e ) {

                    System.out.println( "Cerrando PreparedStatement..." );
                    System.out.println( "---> " + e.toString( ));
                }

            } else
                System.out.println( "Error. No has pasado mysql como SGBD" );
        }

} //class
