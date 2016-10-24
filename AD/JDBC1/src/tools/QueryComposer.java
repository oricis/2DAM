/**
 * @file: QueryComposer.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package tools;

/**
 * This class has methods to compose queries
 * 
 */
public class QueryComposer {

    /**********************************/
    /*** Properties declaration *******/
        
    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Create Derby insert sentence
         * 
         * @param   table_name
         * @param   values
         * @param   qmarks_pos -> determine the values put with quotation marks, for example Strings
         * @return  sql
         */
        public String getDerbyInsert( 
                String   table_name, 
                String[] values, 
                int[]    qmarks_pos 
        ) {
            System.out.println( "QueryComposer / getDerbyInsert()" );
            
            String sql = "INSERT INTO " + table_name + " VALUES(";
            
            int i   = 0;
            int len = values.length;
            
            
            String str_values = getSequence( values, qmarks_pos );
            
            return "INSERT INTO " + table_name
                + " VALUES(" + str_values + "')";
        }
        
        /**
         * Compose a sequence de strings separate by commas, some of them 
         * with quotation marks, for example: "1, 'Pepe', 'Botijo'"
         * 
         * @param   arr
         * @param   qmarks_pos
         * @return 
         */
        public static String getSequence( String[] arr, int[] qmarks_pos ) {
            String a;
            String str = "";
            
            int i   = 0;
            int len = arr.length;
            
            int ended = len - 1;  //to determine if no put a comma
            int pos;    //to determine if use q. marks
            

            while ( i < len) {
                
                //Get position (-1 if not found it)
                pos = Seek.arrayIntValue( qmarks_pos, i );
                System.out.print( "Posición: " );
                System.out.println( pos );
                
                //Set string to add
                a = ( pos >= 0 )    
                        ? "'" + arr[ i ] + "'" 
                        : arr[ i ];
                
                //Set comma to the end of string
                str = ( i != ended )
                    ? str + a + ", "
                    : str + a;

                //count
                i++;
            }


            return str;
        }
        
        /**
         * Create MySql / SQLite insert sentence
         * 
         * @param   values
         * @param   fields
         * @param   table_name
         * @return  sql
         */
        public String getQuery( 
            String[] values, 
            String[] fields,
            String table_name 
        ) {
            System.out.println( "QueryComposer / getQuery()" );
            
            String field1 = fields[ 0 ];
            String field2 = fields[ 1 ];
            String field3 = fields[ 2 ];

            String pk     = values[ 1 ];
            String name   = values[ 2 ];
            String loc    = values[ 3 ];
            
            return "INSERT INTO " + table_name + "(" 
                + field1 + ", " + field2 + ", " + field3 + ") "
                + " VALUES(" + pk + ", '" + name + "', '" + loc + "')";
        }


} //class
