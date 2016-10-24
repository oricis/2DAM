/**
 * @file: Seek.iava
 * 
 * @utor: Moisés Alcocer, 2016
 */

package tools;

/**
 * This class ...
 * 
 */
public class Seek {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/

            
        /**
         * Seek a int in array and return position or -1 if not find it
         * 
         * @param   arr
         * @param   needle
         * @return  int
         */
        public static int arrayIntValue( int[] arr, int needle ) {
        
            int len = arr.length;
            
            for( int i=0; i<len; i++ ) {
                
                if( arr[ i ] == needle ) {
                    
                    return i;
                }
            }
            
            
            return -1;
        }
        
        /**
         * Seek an string in array and return position or -1 if not find it
         * 
         * @param   arr
         * @param   needle
         * @return  int
         */
        public static int arrayStrValue( String[] arr, String needle ) {
        
            int len = arr.length;
            
            for( int i=0; i<len; i++ ) {
                
                if( arr[ i ].equals( needle )) {
                    
                    return i;
                }
            }
            
            
            return -1;
        }


} //class
