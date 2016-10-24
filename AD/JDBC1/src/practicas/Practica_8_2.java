/**
 * @file: Practica_8_2.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package practicas;

/**
 * This class ...
 * 
 */
public class Practica_8_2 {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public Practica_8_2() {
        
            //String sql_derby = "ALTER TABLE profesores ADD COLUMN salario INT DEFAULT 1000 NOT NULL";
            String sql_derby = "ALTER TABLE profesores ADD COLUMN horario_tarde BOOLEAN";
            new universal.AlterTable( "derby", "ejemplo", sql_derby );
            /**/
            System.out.println( "@@@@@@@@@@@@@@@@@@@@@@@@@\n");
            String sql_sqlite = "ALTER TABLE profesores ADD salario INT";
            new universal.AlterTable( "sqlite", "ejemplo", sql_sqlite );
            /**/
            System.out.println( "@@@@@@@@@@@@@@@@@@@@@@@@@\n");
            String sql_mysql = "ALTER TABLE profesores ADD salario INT(10) NOT NULL AFTER dept_no";
            new universal.AlterTable( "mysql", "ad2", sql_mysql );
        }

} //class
