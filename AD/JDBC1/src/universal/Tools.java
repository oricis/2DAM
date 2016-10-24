/**
 * @file: Tools.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package universal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * This class ...
 * 
 */
public class Tools {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Get number of tables in ResultSet
         * 
         * @param   rs
         * @return  int
         */
        public static int getNumberOfTables( ResultSet rs ) {

            try {
                
                if ( rs.TYPE_FORWARD_ONLY == 0 ) {
                    
                    rs.last();  //Move to the end
                    int res = rs.getRow();
                    rs.first(); //Move to beginning
                    
                    return res;
                    
                } else
                    System.out.println( "ResultSet TYPE_FORWARD_ONLY" );
                

            } catch( SQLException e ) {

                System.out.println( "Error obteniendo número de tablas" );
                System.out.println( "---> " + e.toString( ));
            }
            
            return 0;
        }
        
        
        
        /**
         * Ask for database type to user
         * 
         * @return n_sgbd
         */
        public static int getSelectedSGBD() {
            
            int input;

            do {
                input = askToUser();
                
            } while ( input < 1 | input > 3 );
            
            
            return input;
        }
        
        /**
         * Aux. getSelectedSGBD()
         * Ask to user for a number
         * 
         * @return 
         */
        private static int askToUser() {

            System.out.println( "\nEscribe el número del SGBD a consultar: ");
            System.out.println( "1. Derby" );
            System.out.println( "2. SQLite" );
            System.out.println( "3. MySql" );

            //Create a Scanner instance and read input
            Scanner input = new Scanner( System.in );
            int readed    = input.nextInt();


            //return readed int
            return readed;
        }
        
        /**
         * 
         * @param str 
         */
        public static void p( String str ) {
            
            System.out.print( str );
        }
        
        /**
         * 
         * @param str 
         */
        public static void pln( String str ) {
            
            System.out.println( str );
        }
        
} //class
