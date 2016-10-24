/**
 * @file: GetConnection.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package universal;

//imports
import java.sql.Connection;

/**
 * This class ...
 * 
 */
public class GetConnection {

    /**********************************/
    /*** Properties declaration *******/
        
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param   sgbd
         * @param   db_name
         * @return  Connection
         */
        public static Connection get( String sgbd, String db_name ) {
            System.out.println( "GetConnection / get()" );
            System.out.println( "Abriendo conexión para " + sgbd + "/" + db_name);
            
            if ( "derby".equals( sgbd )) {
                //derby.DbConnection derbycon = null;

                return derby.DbConnection.get( 
                    db_name, 
                    derby.DbConstants.DB_PATH 
                );
            }
            
            if ( "sqlite".equals( sgbd )) {
                //sqlite.DbConnection derbycon = null;
            
                return sqlite.DbConnection.get(
                    db_name, 
                    sqlite.DbConstants.DB_PATH
                );
            }

            if ( "mysql".equals( sgbd )) {
                //mysql.DbConnection mysqlcon = null;
                //con = mysqlcon.get(
                return mysql.DbConnection.get(
                    db_name
                );
            }
            
            System.out.println( "Error abriendo la conexión..." );
            return null;
        }

} //class
