/**
 * @file: DbConnection.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.dao;

//imports
import java.sql.*;


/**
 * This class try oper a Db connection
 * 
 */
public class DbConnection {

    /**********************************/
    /*** Properties declaration *******/

        private static Connection con = null;
        
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param   db_name
         * @param   user
         * @param   pass
         */
        public DbConnection (
            String db_name,
            String user, 
            String pass 
        ) {
            
            try {
                
                //Registrar driver
                System.out.println( "Loading driver..." );
                Class.forName( DbConstants.JDBC_DRIVER ); // p.e. "com.mysql.jdbc.Driver"
                System.out.println( "Driver was loaded !" );

                //Establecer conexión
                String url = DbConstants.JDBC_URL + db_name;
                System.out.println( "Open connection with " + url );
                
                con = DriverManager.getConnection( 
                    url,
                    user,
                    pass
                );
                System.out.println( "Connection open!\n" );

               
            } catch( ClassNotFoundException e ) {

                System.out.println( "Error loading the driver" );
                System.out.println( "---> " + e.toString( ));
                
            } catch( SQLException e ) {

                System.out.println( "Error opening connection" );
                System.out.println( "---> " + e.toString( ));
            }
        }
        
        /**
         * Gets the connection
         * 
         * @return  Connection
         */
        public Connection get() {
            
            return con;
        }
        
} //class
