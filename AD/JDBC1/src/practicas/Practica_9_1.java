/**
 * @file: Practica_9_1.java
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
public class Practica_9_1 {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public Practica_9_1() {
            System.out.println( "Practica_9_1 -> PreparedStatement" );

            String sql = "INSERT INTO departamentos"//( dept_no, dnombre, loc )
                + " VALUES( ?, ?, ? )";
                //+ " VALUES(?,\'?\',\'?\')"; //err -> avoid quotation marks
            System.out.println( "SQL -> " + sql );


            System.out.println( "Obtener conexión..." );
            Connection con = universal.GetConnection.get( "mysql", mysql.DbConstants.DB_NAME );

            try {
                
                System.out.println( "Creando PreparedStatement..." );
                try ( PreparedStatement pst = con.prepareStatement( sql )) {
                    
                    System.out.println( "Cargando parámetros..." );
                    pst.setInt(    1, 70 );
                    pst.setString( 2, "BIO" );
                    pst.setString( 3, "DESPA1" );
                    
                    System.out.println( "Introducidos parámetros..." );
                    System.out.println( "Ejecuta sentencia recogiendo filas afectatas..." );
                    
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
