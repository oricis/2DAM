/**
 * @file: Practica_8_4.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package practicas;

//imports
import java.sql.*;

/**
 * This class ...
 * 
 */
public class Practica_8_4 {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public Practica_8_4() {
            System.out.println( "Practica_8_4 -> Actualizando salario" );

            double salary_increment = 1.05; // 5%
            String dept = "INFORMATICA";
            
            String sql  = "UPDATE profesores SET salario=( salario * " + salary_increment + 
                    " ) WHERE dept_no=(SELECT dept_no FROM departamentos" +
                    " WHERE dnombre='" + dept + "')";

            System.out.println( "Obtener conexión..." );
            Connection con = universal.GetConnection.get( "mysql", mysql.DbConstants.DB_NAME );

            try {
                System.out.println( "Creando Statement..." );
                try (Statement st = con.createStatement()) {
                    
                    System.out.println( "Ejecutando sentencia..." );
                    System.out.println( "SQL -> " + sql );
                    st.executeUpdate( sql );
                    
                    System.out.println( "Cerrando conexión..." );
                }
                con.close();

            } catch ( SQLException e ) {

                System.out.println( "Error ---> " + e.toString( ));
            }
        }

} //class
