/**
 * @file: TestDerby.java
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
public class TestDerby {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public TestDerby() {
            System.out.println( "TestDerby / Construct()" );
            
            String db_name = "ejemplo";
            
            try {
                
                //Abre conexión
                System.out.println( "Estableciendo la conexión con la BD..." );
                Connection con = DbConnection.get( db_name, DbConstants.DB_PATH );

                //Cierra conexión
                con.close();
                

            } catch( SQLException e ) {
                
                System.out.println( "Se ha producido un error..." );
                System.out.println( "---> " + e.toString( ));
            }
        }

} //class
