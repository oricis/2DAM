/**
 * @file: DBResultSetMetadata.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package mysql;

//imports
import java.sql.*;

/**
 * This class allow get detailed information about the colums of a table
 * 
 */
public class DBResultSetMetadata {

    /**********************************/
    /*** Properties declaration *******/
        
        private Connection con;
        
    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param db_name
         * @param table_name
         */
        public DBResultSetMetadata( String db_name, String table_name ) {
            
            try {
                
                //Obtener conexión
                con = DbConnection.get( db_name );
                
                System.out.println( "Obteniendo ResultSetMetaData para la tabla \"" + 
                    table_name + "\"" );

                //Consulta SQL
                String sql   = "SELECT * FROM " + table_name;
                
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery( sql );
                ResultSetMetaData rsmd = rs.getMetaData();

                System.out.println( "ResultSetMetaData preparado !\n" );


                //Consultando información
                int ncols = rsmd.getColumnCount();

                String cols = ( ncols > 1 )
                    ? ncols + " columnas."
                    : "1 columna.";

                System.out.println( "La tabla \"" + table_name + "\" tiene " + cols );
                System.out.println( "---------------------------" );
                
                //Recorre las columnas del ResultSetMetaData
                for ( int i=1; i < ncols; i++ ) {

                    System.out.println( "Columna: " + i );
                    System.out.println( "Nombre: "  + rsmd.getColumnName( i ));
                    System.out.println( "Tipo: "    + rsmd.getColumnTypeName( i ));
                    System.out.println( "Admite nulos: " + rsmd.isNullable( i ));
                    System.out.println( 
                        "Ancho máximo de display: " +  
                        rsmd.getColumnDisplaySize( i )
                    );
                    System.out.println( "---------------------------" );
                }

                System.out.println( "\nOperaciones finalizadas." );
                System.out.println( "Liberando recursos...\n" );


                //Cierra ResultSet
                //Cierra Connection
                rs.close();
                con.close();

                
            } catch( SQLException e ) {
                
                System.out.println( "Error conexión" );
                System.out.println( "--->" + e.toString( ));
            }
        }   

} //class
