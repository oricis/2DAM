/**
 * @file: TestSQLite.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package sqlite;

import universal.ShowTables;

/**
 * Class
 * 
 */
public class TestSQLite {

    /**
     * 
     * 
     */
    public TestSQLite() {
        System.out.println( "TestSQLite / construct()" );
        
        String db_name = "ejemplo";
        // Create a BD
        /*new CreateDb( 
            "PolloLoco", 
            "D://practicas/" 
        );
        /**/
        
        // Display tables in DB
        new universal.ShowTables( 
            DbConnection.get( db_name, DbConstants.DB_PATH ),
            db_name
        );
        /**/
    }

} //class