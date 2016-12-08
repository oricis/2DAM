/**
 * @file: SQL.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package jtables.helpers;

//imports
import java.sql.*;


/**
 * Class of type Client
 * 
 */
public class SQL {
	
    /**********************************/
    /*** Properties declaration *******/



    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Gets number of rows in a ResultSet
         *
         * @param   rs
         * @return  size
         */
        public static int getResultSetSize( ResultSet rs ) {
            Trace.ln( "SQL / getResultSetSize()" );


            int size = 0;

            try {

                if ( rs.last( )) {

                    size = rs.getRow();
                    rs.beforeFirst();
                    // not rs.first() because the rs.next() below will move on, 
                    // missing the first element
                }

            } catch( SQLException e ) {
                
                System.out.println( "Error getting ResultSet size !" );
                System.out.println( "---> " + e.toString( ));
            }


            return size;
        }
        
} //class
