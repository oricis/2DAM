/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsamples;

import app.helpers.Utils;

/**
 *
 * @author orici
 */
public class TestUtils {
    
    private final String LETTERS = "áéíóúüñabcdefghijklmnopqrstuvwxyzÁÉÍÓÚÜÑABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public TestUtils() {
        
        
        String str = "Hola mundo!";
        
        char c1 = 'o';
        char c2 = 'x';
        int[] positions;
        
        //Test
        /*if ( Utils.isLetterInStr( c1, str )) {
            System.out.println( "Letra \"" + c1 + "\" esta en: \"" + str + "\"" );
            positions = Utils.getPositionsInStr( c1, str );
            System.out.println( "Número de apariciones: " + positions.length );
            System.out.print( "En las posiciones: " );
            for ( int i = 0; i < positions.length; i++ ) {
                System.out.print( positions[ i ] + " " );
            }
            System.out.println( "\n" );
            
        } else
            System.out.println( "Letra \"" + c1 + "\" NO esta en: \"" + str + "\" \n" );
        
        
        
        if ( Utils.isLetterInStr( c2, str )) {
            System.out.println( "Letra \"" + c2 + "\" esta en: \"" + str + "\"" );
            positions = Utils.getPositionsInStr( c2, str );
            System.out.println( "Número de apariciones: " + positions.length );
            System.out.print( "En las posiciones: " );
            for ( int i = 0; i < positions.length; i++ ) {
                System.out.print( positions[ i ] + " " );
            }
            System.out.println( "\n" );
            
        } else
            System.out.println( "Letra \"" + c2 + "\" NO esta en: \"" + str + "\" \n" );

            */
        
        positions = new int[]{ 0, 1, 2, 3 };
        System.out.println( Utils.changeLettersIn( c2, str, positions ));
    }
}
