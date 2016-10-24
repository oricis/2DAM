/**
 * @file: InsertsArgs.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package universal;

/**
 * This class ...
 * 
 */
public class InsertsArgs {

    /**********************************/
    /*** Properties declaration *******/

        public String db_name;
        public String sgbd;    // "derby" | "sqlite" | "mysql"
        
    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         * @param args [ sgbd, value1, value2, valuen... ]
         */
        public InsertsArgs( String[] args ) {
            System.out.println( "InsertsArgs / construct()" );
            
            int len = args.length;
            
            if ( len == 4 ) {
                sgbd = args[ 0 ];
                System.out.println( "SGBD: " + sgbd );
                System.out.println( "------------------------" );

                String table_name   = "departamentos";
                String[] dep_fields = {
                    "dept_no",
                    "dnombre",
                    "loc",
                };

                String sql = ( "derby".equals( sgbd ))
                    ? getQueryDerby( args, table_name )
                    : getQuery( args, dep_fields, table_name );
                
                System.out.println( "SQL: " + sql );
                
                //Select database name
                db_name = ( "mysql".equals( sgbd ))
                    ? "ad-ud2"
                    : "ejemplo";

                    
                //Ejecuta la insert
                run( sql );
                
            } else {
                
                System.out.println( "Pasado un numero de argumentos erroneo." );
                System.out.println( "Esperados:" );
                System.out.println( "dept_no    -> int multiplo de 10" );
                System.out.println( "dnombre    -> String" );
                System.out.println( "loc        -> String, p.e. DESPA7" );
            }
        }
        
        /**
         * Create Derby insert sentence
         * 
         * @param   args
         * @param   table_name
         * @return  sql
         */
        private String getQueryDerby( String[] args, String table_name ) {
            System.out.println( "InsertsArgs / getQueryDerby()" );

            String pk     = args[ 1 ];
            String name   = args[ 2 ];
            String loc    = args[ 3 ];
            
            return "INSERT INTO " + table_name
                + " VALUES(" + pk + ", '" + name + "', '" + loc + "')";
        }

        /**
         * Create MySql / SQLite insert sentence
         * 
         * @param   args
         * @param   fields
         * @param   table_name
         * @return  sql
         */
        private String getQuery( 
            String[] args, 
            String[] fields,
            String table_name 
        ) {
            System.out.println( "InsertsArgs / getQuery()" );
            
            int[] qmarks_pos = {};

            String pk     = args[ 1 ];
            String name   = args[ 2 ];
            String loc    = args[ 3 ];
            
            return "INSERT INTO " + table_name + "(" 
                + tools.QueryComposer.getSequence( fields, qmarks_pos )
                + ") VALUES(" + pk + ", '" + name + "', '" + loc + "')";
        }

        /**
         * Realiza insert
         *
         * @param      sql   The sql
         */
        private void run( String sql ) {
            System.out.println( "InsertsArgs / run()" );
            System.out.println( "SQL -> " + sql );
            
            
            String[] arr = { sql };
            
            new InsertInto( arr, sgbd, db_name );
        }

} //class
