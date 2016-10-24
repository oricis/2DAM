package mysql;

/**
 * @file: DBMetadata.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

//imports
import java.sql.*;


/**
 * This class get information over the dababase
 * 
 */
public class DBMetadata {

    /**********************************/
    /*** Properties declaration *******/

        private Connection con;
        private DatabaseMetaData dbmd;
        private ResultSet rs        = null,
                          rs_cols   = null,
                          rs_pk_dep = null;
        
        private final String table_dept = "departamentos";
        
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param db_name
         */
        public DBMetadata( String db_name ) {
            
            String nombre;
            String driver;
            String url;
            String usuario;

            //Registrar driver
            try {
                Class.forName( DbConstants.JDBC_DRIVER ); //p.e. "com.mysql.jdbc.Driver"
                
            } catch ( ClassNotFoundException e ) {
                
                System.out.println( "Error registrando driver..." );
                System.out.println( e.toString( ));
                
                return;
            }
            System.out.println( "Driver registrado.\n" );
            
            
            try {
                
                //Establecer conexión
                con = DriverManager.getConnection(
                    DbConstants.JDBC_URL + db_name, 
                    DbConstants.USER, 
                    DbConstants.PASS
                );
                
                
                //Obtener datos
                dbmd    = con.getMetaData();
                
                nombre  = dbmd.getDatabaseProductName(); 
                driver  = dbmd.getDriverName(); 
                url     = dbmd.getURL(); 
                usuario = dbmd.getUserName();
                
                
                //Obtener info sobre las tablas de la base de datos
                rs      = dbmd.getTables( null, db_name, null, null );
                
                // Recuperar info de las columnas de la tabla "departamentos"
                rs_cols = dbmd.getColumns( null, db_name, table_dept, null );
                
                //Obtener primary keys de la tabla "departamentos" 
                rs_pk_dep = dbmd.getPrimaryKeys( null, db_name, table_dept );
                
                
                //Mostrar datos
                System.out.println( "nombre: "  + nombre );
                System.out.println( "driver: "  + driver );
                System.out.println( "url: "     + url );
                System.out.println( "usuario: " + usuario );
            
                //Cerrar conexión
                System.out.println( "Cerrando conexión...\n" );
                con.close();
                
            } catch( SQLException e ) {
                
                System.out.println( "Error obteniendo datos" );
                System.out.println( e.toString( ));
            }
            
            
            
            
            //Mostrar datos
            if ( rs != null ) { // || ( ! rs.wasNull( )) -> need caught SQLException

                try {
                    System.out.println( "\nDataBase Information ........................" );
                    
                    //Recorrer ResultSet y mostrar datos
                    while ( rs.next( )) { 

                        String catalogo = rs.getString( 1 ); //la columna 1  
                        String esquema  = rs.getString( 2 ); //la columna 2  
                        String tabla    = rs.getString( 3 ); //la columna 3  
                        String tipo     = rs.getString( 4 ); 
                        
                        System.out.println( 
                            "Catalogo: " + catalogo + 
                            " Esquema: " + esquema + 
                            " tipo: "    + tipo + 
                            " Nombre tabla: " + tabla +
                            "\n------------------"
                        );
                    }
                    
                    //Cerrar ResultSet
                    System.out.println( "Cerrando ResultSet rs...\n" );
                    rs.close();
                    
                } catch( SQLException e ) {
                    
                    System.out.println( "Err recorriendo ResultSet rs" );
                    System.out.println( "---> " + e.toString( ));
                }
            }

            //Mostrar datos columnas tablas "departamentos"
            if ( rs_cols != null ) {

                try {
                    System.out.println( "\nCols Information table \"departamentos\"..........." );

                    //Recorrer ResultSet
                    while( rs_cols.next()) {

                        String nombreCol = rs_cols.getString( "COLUMN_NAME" );
                        String tipoCol   = rs_cols.getString( "TYPE_NAME"   );
                        String tamCol    = rs_cols.getString( "COLUMN_SIZE" );
                        String nula      = rs_cols.getString( "IS_NULLABLE" );

                        System.out.println( 
                            "Columna: " + nombreCol + 
                            "\nTipo: "   + tipoCol + 
                            "\nTamaño: " + tamCol + 
                            "\nAdmite null: " + nula +
                            "\n------------------"
                        );
                    }

                        

                    //Cerrar ResultSet
                    System.out.println( "Cerrando ResultSel rs_cols..." );
                    rs_cols.close();

                } catch( SQLException e ) {

                    System.out.println( "Err recorriendo ResultSet rs_cols" );
                    System.out.println( "---> " + e.toString( ));
                }
            }

            //Mostrar pk tabla "departamentos" (puede ser una pk compuesta)
            if ( rs_pk_dep != null ) {

                String pk = "";
                int n = 0;

                try {

                    //Recorrer ResultSet y mostrar datos
                    while ( rs_pk_dep.next( )) {

                        if ( n == 0 )
                            pk = rs_pk_dep.getString( "COLUMN_NAME" );

                        else
                            pk = pk + " - " + rs_pk_dep.getString( "COLUMN_NAME" );


                        n++;
                    }

                    System.out.println( "\nPK table \"departamentos\"..........." );
                    String str_fields = ( n > 1 )
                        ? " campos: "
                        : " campo: ";
                    System.out.println( "PK formada por: " + n + str_fields + pk );
                    

                    //Cerrar ResultSet
                    System.out.println( "Cerrando ResultSel rs_cols..." );
                    rs_cols.close();

                } catch( SQLException e ) {

                    System.out.println( "Err recorriendo ResultSet rs_cols" );
                    System.out.println( "---> " + e.toString( ));
                }
            }
        }

} //class
