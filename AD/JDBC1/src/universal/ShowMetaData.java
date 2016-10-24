/**
 * @file: DBMetadata.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package universal;

//imports
import java.sql.*;


/**
 * This class get information over the dababase
 * 
 */
public class ShowMetaData {

    /**********************************/
    /*** Properties declaration *******/

        private Connection con;
        private DatabaseMetaData dbmd;
        private ResultSet rs        = null,
                          rs_cols   = null,
                          rs_pk_dep = null;
        
        //private final String table_name = "departamentos";
        
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param con
         * @param db_name
         * @param table_name
         */
        public ShowMetaData( Connection con, String db_name, String table_name ) {
            System.out.println( "ShowMetaData / construct()" );
            
            //Guardar conexión
            this.con = con;
                
            String nombre;
            String driver;
            String url;
            String usuario;

            System.out.println( "Mostrando información de la BD: " + db_name );
            try {
                
                //Obtener datos
                dbmd    = con.getMetaData();
                
                nombre  = dbmd.getDatabaseProductName(); 
                driver  = dbmd.getDriverName(); 
                url     = dbmd.getURL(); 
                usuario = dbmd.getUserName();
                
                //Mostrar datos
                System.out.println( "nombre: "  + nombre );
                System.out.println( "driver: "  + driver );
                System.out.println( "url: "     + url );
                System.out.println( "usuario: " + usuario );
                System.out.println( "----------------------------------" );
                
                System.out.println( "Inicializando ResulSets...\n" );
                
                //Obtener info sobre las tablas de la base de datos
                System.out.println( "Obteniendo info sobre las tablas..." );
                rs      = dbmd.getTables( null, null, null, null );
                
                // Recuperar info de las columnas de la tabla "table_name"
                System.out.println( "Obteniendo info sobre las columnas de la tabla \"" + table_name + "\"..." );
                rs_cols = dbmd.getColumns( null, null, table_name, null );
                
                //Obtener primary keys de la tabla "table_name" 
                System.out.println( "Obteniendo primary keys de la tabla \"" + table_name + "\"..." );
                rs_pk_dep = dbmd.getPrimaryKeys( null, null, table_name );
                
 
                //Cerrar conexión
                System.out.println( "Cerrando conexión...\n" );
                con.close();
                //
                //
                //
                // IMPORTANTE !!!
                // 
                // Al cerrar la conexión, en Derby y SQLite, se cierran también los ResultSets por lo que
                // desde este punto ya no podran recorrerse para mostrar los datos que contenían
                // 
                // 
                // 
                
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

            //Mostrar datos columnas tablas "table_name"
            if ( rs_cols != null ) {

                try {
                    System.out.println( "\nCols Information table \"" + table_name + "\"....." );

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

            //Mostrar pk tabla "table_name" (puede ser una pk compuesta)
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

                    System.out.println( "\nPK table \"" + table_name + "\"..........." );
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
