/**
 * @file: TempConverter.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package conversortemperaturas;

/**
 * This class convert between diferent types of degrees, 
 * for example from Celcius degrees to Kelvin
 * 
 */
public class TempConverter {

    /**********************************/
    /*** Properties declaration *******/

        static int res = 0;
        static final float  KELVINS = (float ) 273.15;
        
        
    /**********************************/
    /*** Methods declaration **********/

        /**
         * Convert from Celcius to Kelvin degrees
         *
         * @param  degrees -> The Celcius degrees
         * @return degrees -> The Kelvin degrees
         */
        public static float celciusToKelvins( float  degrees ) {
            System.out.println( "TempConverter / celciusToKelvins()" );
                
            
            return (float) ( degrees + KELVINS );
        }

        /**
         * Convert from Kelvin to Celcius degrees
         *
         * @param  degrees -> The Kelvin degrees
         * @return degrees -> The Celcius degrees
         */
        public static float kelvinToCelcius( float  degrees ) {
            System.out.println( "TempConverter / kelvinToCelcius()" );

            
            return (float) ( degrees - KELVINS );
        }


        /**
         * Determines if a string is a number value
         * 
         * Source:
         * http://jdevelopment.nl/efficient-determine-string-number/?ref=dzone
         *
         * @param  str The string
         * @return boolean
         */
        public static boolean isNumber( String str ) {
            
            if ( str == null || str.isEmpty( )) {
                return false;
            }
            str = replaceDecimalMarks( str );
            
            char c;
            int i  = 0;
            
            if ( str.charAt( 0 ) == '-' ) {
                
                if ( str.length() > 1 ) {
                    i++;
                    
                } else {
                    
                    return false;
                }
            }

            for ( ; i < str.length(); i++ ) {
                
                c = str.charAt( i );
                if ( ! Character.isDigit( c ) && c != '.' ) {

                    return false;
                }
            }


            return true;
        }
        
        /**
         * Replace commas with points in a string
         * 
         * @param str
         * @return 
         */
        public static String replaceDecimalMarks( String str ) {
            
            return str.replaceAll( ",", "." );
        }
        
} //class
