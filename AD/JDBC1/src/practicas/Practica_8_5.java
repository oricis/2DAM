/**
 * @file: Practica_8_5.java
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
public class Practica_8_5 {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public Practica_8_5() {
            System.out.println( "Practica_8_5 -> Actualizando salario" );

            double salary_increment = 1.05; // 5%
            String dept = "INFORMATICA";
            
            // Crear una vista que obtenga para cada departamento su localización 
            // y cuántos profesores tiene, con el sueldo medio de los mismos
            String sql  = "CREATE VIEW vista_8_5 AS " +
		"SELECT dnombre, loc FROM departamentos " +
		"UNION ALL " +
		"SELECT COUNT(dept_no), salario FROM profesores";

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

/*
CREATE VIEW Auto AS 
	SELECT * FROM dbo.auto2005 
	UNION ALL 
	SELECT * FROM dbo.auto2006 
*/