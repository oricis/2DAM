/**
 * @file: DbConnection.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package mysql;

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
         * @return  Connection
         */
        public static Connection get( String db_name ) {
            
            try {
                
                //Registrar driver
                System.out.println( "Registrar driver..." );
                Class.forName( DbConstants.JDBC_DRIVER ); // p.e. "com.mysql.jdbc.Driver"
                System.out.println( "Driver registrado !" );

                //Establecer conexión
                System.out.println( "Establecer conexión..." );
                con = DriverManager.getConnection( 
                    DbConstants.JDBC_URL + db_name,
                    DbConstants.USER,
                    DbConstants.PASS
                );

                if( db_name != null )
                    System.out.println( "Conexión establacida \"" + db_name + "\"\n" );
                else
                    System.out.println( "Conexión establacida !\n" );
                
                
                //Devolver conexión
                return con;
               
            } catch( ClassNotFoundException e ) {

                System.out.println( "Error registrando driver" );
                System.out.println( "---> " + e.toString( ));
                
            } catch( SQLException e ) {

                System.out.println( "Error establaciendo conexión" );
                System.out.println( "---> " + e.toString( ));
            }
            
            
            return null;
        }

} //class
