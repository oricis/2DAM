/**
 * @file: DbConstants.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package derby;

/**
 * This class store credentials to open connections with the database
 * 
 */
public class DbConstants {

    /**********************************/
    /*** Properties declaration *******/
    
        public static final String DB_NAME     = "ejemplo";
        public static final String DB_PATH     = "D://practicas/derby/";
        public static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        //public static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        public static final String JDBC_URL    = "jdbc:derby:";  //EmbeddedDriver
        //public static final String JDBC_URL    = "jdbc:derby://localhost:1527/"; //ClientDriver
        
        //Database credentials
        public static final String USER = "root";
        public static final String PASS = "";
        
        /**
         * If you are planning to use everything of Derby in one machine, use EmbeddedDriver. 
         * If the JDBC client connects to Derby server on a remote machine, use ClientDriver.
         */
    
    /**********************************/
    /*** Methods declaration **********/


} //class
