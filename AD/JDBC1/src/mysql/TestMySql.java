/**
 * @file: TestMySql.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package mysql;

/**
 * Class
 * 
 */
public class TestMySql {

    /**
     * 
     * 
     */
    public TestMySql() {
        System.out.println( "TestMySql / construct()" );
        
        String db_name = "ad-ud2";
        
        // Create a BD if no exists
        new CreateDb( "potos" );
        
        //Obtener info de la BD
        //new DBMetadata( db_name );
        
        //Obtener info sobre las columnas de una tabla
        //new DBResultSetMetadata( db_name, "departamentos" );
        
        // Display tables in DB
        new universal.ShowTables( 
            DbConnection.get( db_name ),
            db_name
        );
        /**/
    }
} //class
