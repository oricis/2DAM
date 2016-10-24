/**
 * @file: ShowTables.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package universal;

//imports
import java.sql.*;


/**
 * This class ...
 * 
 */
public class ShowTables {

    /**********************************/
    /*** Properties declaration *******/

        private final Connection con;
        private DatabaseMetaData dbmd;
        private ResultSet rs;

    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param con
         * @param db_name
         */
        public ShowTables( Connection con, String db_name ) {
            System.out.println( "ShowTables / construct()" );
            
            //Guarda conexión
            this.con = con;
            
            try {

                System.out.println( "Obteniendo metadatos..." );
                dbmd = con.getMetaData();
                
                //Obtiene SGBD
                String sgbd = dbmd.getDatabaseProductName();
                System.out.println( "SGBD ---> " + sgbd + "\n");
                
                System.out.println( "Obteniendo info sobre las tablas de la BD..." );
                rs   = dbmd.getTables( null, null, null, null );

                //Show the information
                System.out.println( "\nTablas en \"" + db_name + "\"" );
                System.out.println( "-----------------------------" );

                while ( rs.next( )) {

                    String tabla    = rs.getString( 3 ); //la columna 3
                    String tipo     = rs.getString( 4 ); //la columna 4
                    
                    System.out.println( tabla );
                }
                System.out.println( "-----------------------------" );

                
            } catch( SQLException e ) {
                System.out.println( "Se ha producido un error" );
                System.out.println( "---> " + e.toString( ));
            }
        }



} //class
