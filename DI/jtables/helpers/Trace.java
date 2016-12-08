/**
 * @file: Trace.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package jtables.helpers;

/**
 * This class ...
 * 
 */
public class Trace {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Print one bar-line in order to separate trece content
         * 
         * @param str
         */
        public static void lsep() {

            ln( "-------------------------------------" );
        }

        /**
         * Print one or more bar-lines in order to separate trece content
         * 
         * @param str
         */
        public static void lsep( int lines ) {

            if ( lines == 1 )
                ln( "-------------------------------------" );

            else {

                int cont = 0;

                while ( cont < lines ) {

                    ln( "-------------------------------------" );

                    cont++;
                }
            }
        }

        /**
         * Print str and jump one line
         * 
         * @param str
         */
        public static void ln( String str ) {
        
            System.out.println( str );
        }

} //class
