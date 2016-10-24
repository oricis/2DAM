/**
 * @file: Test.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

/**
 * This class ...
 * 
 */
public class Test {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public Test() {
        
            /*** Test / tools.Seek.arrayIntValue() ***/
            /*System.out.println( "Test / tools.Seek.arrayIntValue()\n" );
            
            int[] arr_ints = { 1, 2, 3, 4, 5 };
            int int_to_find = 3;
            
            int ires = tools.Seek.arrayIntValue( arr_ints, int_to_find );
            System.out.println( ires );
            ires = tools.Seek.arrayIntValue( arr_ints, 10 );
            System.out.println( ires );
            /*** Fin Test ***********************************/
            
            /*** Test / tools.Seek.arrayStrValue() ***/
            /*System.out.println( "Test / tools.Seek.arrayStrValue()\n" );
            
            String[] arr_strs  = { "uno", "dos", "tres" };
            String str_to_find = "dos";
            
            ires = tools.Seek.arrayStrValue( arr_strs, str_to_find );
            System.out.println( ires );
            ires = tools.Seek.arrayStrValue( arr_strs, "xxx" );
            System.out.println( ires );
            /*** Fin Test ***********************************/
            
            /*** Test / tools.QueryComposer.getSequence() ***/
            /*System.out.println( "Test / tools.QueryComposer.getSequence()\n" );
            
            String[] a = { "uno", "dos", "tres" };
            int[] qpos = { 1, 2 };
            
            res = tools.QueryComposer.getSequence( a, qpos );
            System.out.println( res );
            /*** Fin Test ***********************************/
        }

} //class
