/**
 * @file: AlterTable.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package universal;

import java.sql.*;

/**
 * This class ...
 * 
 */
public class AlterTable {

    /**********************************/
    /*** Properties declaration *******/

        private Connection con;
        private Statement st;
    
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param   sgbd
         * @param   bd_name
         * @param   sql
         */
        public AlterTable( String sgbd, String bd_name, String sql ) {
            System.out.println( "AlterTable / construct()" );
            
            String sgbd_driver = getDriver( sgbd );
            String db_name     = getDbName( sgbd, bd_name );
            String sgbd_url    = getUrl( sgbd, db_name );
            
            try {
                
                //Registrando driver
                System.out.println( "Registrando driver..." );
                Class.forName( sgbd_driver );

                //Abriendo conexión
                System.out.println( "Abriendo conexión..." );
                con = DriverManager.getConnection( 
                    sgbd_url,
                    "root",
                    ""
                );
                
                System.out.println( "Creando Statement..." );
                st = con.createStatement();
                
                System.out.println( "Ejecutando sentencia SQL..." );
                st.executeUpdate( sql );
                
                //Cerrar instancias
                System.out.println( "Liberando recursos..." );
                st.close();
                con.close();
                
            } catch( ClassNotFoundException e ) {

                System.out.println( "Error: clase no encontrada" );
                System.out.println( "---> " + e.toString( ));
                
            } catch( SQLException e ) {

                System.out.println( "Error: no se modifico la estructura de la tabla" );
                System.out.println( "---> " + e.toString( ));
            }
        }
        
        /**
         * Select and return db name for connection
         *
         * @param      sgbd     The sgbd
         * @param      bd_name  The name for the DataBase
         * @return     The db name
         */
        private String getDbName( String sgbd, String bd_name ) {
            
            if ( "derby".equals( sgbd ))
                return derby.DbConstants.DB_PATH + bd_name;
                //return "org.apache.derby.jdbc.ClientDriver";

            if ( "sqlite".equals( sgbd ))
                return sqlite.DbConstants.DB_PATH + bd_name;

            if ( "mysql".equals( sgbd ))
                return "ad-ud2";


            System.out.println( "Error. No hay nombre para la BD..." );
            return "";
        }
        
        /**
         * Select and return driver for connection
         *
         * @param      sgbd  The sgbd
         * @return     The driver
         */
        private String getDriver( String sgbd ) {
            System.out.println( "AlterTable / getDriver() -> SGBD: " + sgbd );

            /**
             * If you are planning to use everything of Derby in one machine, use EmbeddedDriver. 
             * If the JDBC client connects to Derby server on a remote machine, use ClientDriver.
             */
            if ( "derby".equals( sgbd ))
                return "org.apache.derby.jdbc.EmbeddedDriver";
                //return "org.apache.derby.jdbc.ClientDriver";

            if ( "sqlite".equals( sgbd ))
                return "org.sqlite.JDBC";

            if ( "mysql".equals( sgbd ))
                return "com.mysql.jdbc.Driver";


            System.out.println( "Error. No hay driver..." );
            return "";
        }

        /**
         * Select and return base url for connection
         *
         * @param      sgbd     The sgbd
         * @param      db_name  The db_name
         * @return     The url
         */
        private String getUrl( String sgbd, String db_name ) {
            System.out.println( "AlterTable / getUrl() -> SGBD: " + sgbd );

            if ( "derby".equals( sgbd ))
                return "jdbc:derby:" + db_name;             //db_name = path + db_name

            if ( "sqlite".equals( sgbd ))
                return "jdbc:sqlite:" + db_name + ".db";    //db_name = path + db_name + ".db";

            if ( "mysql".equals( sgbd ))
                return "jdbc:mysql://localhost/" + db_name;


            System.out.println( "Error. No hay url..." );
            return "";
        }

} //class
