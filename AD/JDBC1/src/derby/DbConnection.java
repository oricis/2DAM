/**
 * @file: DbConnection.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package derby;

//imports
import java.sql.*;

/**
 * This class ...
 * 
 */
public class DbConnection {

    /**********************************/
    /*** Properties declaration *******/

        //static Connection con = null;
        
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param   db_name
         * @param   db_path
         * @return  Connection
         */
        public static Connection get( String db_name, String db_path ) {
            
            try {
                
                //Registrar driver
                Class.forName( DbConstants.JDBC_DRIVER ); // p.e. "com.mysql.jdbc.Driver"
                System.out.println( "Driver registrado !" );
                
            } catch( ClassNotFoundException e ) {

                System.out.println( "Error registrando driver" );
                System.out.println( "---> " + e.toString( ));
                
                return null;
            }
            
            try {
                //Establecer conexión
                String url = getUrlToConnection( db_name, db_path );
                System.out.println( "Establecieno conexión con \"" + url + "\"\n" );
                
                Connection con = DriverManager.getConnection( 
                    url,
                    DbConstants.USER,
                    DbConstants.PASS
                );

                if( db_name != null )
                    System.out.println( "Conexión establacida \"" + db_name + "\"\n" );
                else
                    System.out.println( "Conexión establacida !\n" );
                
                
                //Devolver conexión
                return con;
                
            } catch( SQLException e ) {

                System.out.println( "Error establaciendo conexión" );
                System.out.println( "---> " + e.toString( ));
            }
            
            
            return null;
        }
        
        /**
         * Compose the URL to create a connection
         * 
         * @param   db_name
         * @param   db_path
         * @return  String url
         */
        private static String getUrlToConnection( String db_name, String db_path ) {
            
            String url = DbConstants.JDBC_URL;
            
            if ( db_path != null )
                url = url + db_path;
            
            url = url + db_name + ";create=true";
            
            
            return url;
            //return "jdbc:sqlite:";    //No se crea
            //return "jdbc:sqlite:d://practicas/"; //Exception in thread "main" java.lang.NullPointerException
            //return "jdbc:sqlite:d://practicas/PolloLoco.db"; //Crea la BD si no existe al realizar la conexión
        }
} //class