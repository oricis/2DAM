/**
 * @file: Practica_9_2.java
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
public class Practica_9_2 {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public Practica_9_2() {
            System.out.println( "Practica_9_2 -> PreparedStatement" );

            //Añadir una determinada cantidad al salario de los profesores 
            //de un determinado departamento
            String sql = "UPDATE profesores SET salario=( salario + ? )"
                + " WHERE dept_no=(SELECT dept_no FROM departamentos"
                + " WHERE dnombre=?)";
            System.out.println( "SQL* -> " + sql );


            System.out.println( "Obtener conexión..." );
            Connection con = universal.GetConnection.get( 
                "mysql", 
                mysql.DbConstants.DB_NAME 
            );

            try {
                
                System.out.println( "Creando PreparedStatement..." );
                try ( PreparedStatement pst = con.prepareStatement( sql )) {
                    
                    System.out.println( "Cargando parámetros..." );
                    pst.setInt(    1, 50 );
                    pst.setString( 2, "FOL" );
                    
                    System.out.println( "Introducidos parámetros..." );
                    System.out.println( 
                        "Ejecuta sentencia recogiendo filas afectatas..." 
                    );
                    
                    int rows = pst.executeUpdate();
                    
                    System.out.println( "Filas afectatas: " + rows );

                    //Cerrar PreparedStatement
                    System.out.println( "Cerrando PreparedStatement..." );
                    pst.close();
                }

                //Cerrar conexión
                System.out.println( "Cerrando conexión..." );
                con.close();

            } catch ( SQLException e ) {

                System.out.println( "Error ---> " + e.toString( ));
            }
        }

} //class
