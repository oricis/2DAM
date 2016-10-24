/**
 * @file: CreateDb.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package sqlite;

//imports
import java.sql.*;

/**
 * This class ...
 * 
 */
class CreateDb {

    /**********************************/
    /*** Properties declaration *******/

        private Connection con;
        
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public CreateDb( String db_name, String db_path ) {
            System.out.println( "CreateDb / construct()" );
            
            //Obtiene la conexión
            System.out.println( "Obteniendo conexión...\n" );
            con = DbConnection.get( db_name, db_path );
            
            System.out.println( "Creada DB: " + db_name + ".db" );
            
            /**
             * IMPORTANTE !!!
             * 
             * SQLite crea la BD automaticamente al intentar realizar la 
             * conexión si la BD no existe
             * 
             */
        }

} //class
