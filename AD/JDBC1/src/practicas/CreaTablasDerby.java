/**
 * @file: CreaTablasDerby.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package practicas;

/**
 * This class ...
 * 
 */
public class CreaTablasDerby {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public CreaTablasDerby() {
        
            String sql_derby_create_departamentos = "CREATE TABLE departamentos("
                        + "dept_no      INT NOT NULL PRIMARY KEY,"
                        + "dnombre      VARCHAR(20),"
                        + "loc          VARCHAR(20))";
            
            String sql_derby_create_profesores = "CREATE TABLE profesores (" 
                        + "NRP          INT NOT NULL PRIMARY KEY,"
                        + "nombre       VARCHAR(15) NOT NULL,"
                        + "apellidos    VARCHAR(40) NOT NULL,"
                        + "email        VARCHAR(50) NOT NULL,"
                        + "fecha_alta   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
                        + "dept_no  INT NOT NULL )";
            
            String insert_a = "INSERT INTO departamentos VALUES(10, 'INFORMATICA', 'DESPA6')";
            String insert_b = "INSERT INTO departamentos VALUES(20, 'COMERCIO', 'DESPA7')";
            String insert_c = "INSERT INTO departamentos VALUES(30, 'ADMINISTRATIVO', 'DESPA8')";
            String insert_d = "INSERT INTO departamentos VALUES(40, 'FOL', 'DESPA5')";
            
            String[] inserts = {
                insert_a,
                insert_b,
                insert_c,
                insert_d
            };
            
            new universal.CreateTable( 
                    sql_derby_create_departamentos, 
                    "derby", 
                    derby.DbConstants.DB_NAME 
            );
            new universal.CreateTable( 
                    sql_derby_create_profesores,    
                    "derby", 
                    derby.DbConstants.DB_NAME 
            );
            
            System.out.println( "\nInsertanto registros..." );
            new universal.InsertInto( 
                    inserts, 
                    "derby", 
                    derby.DbConstants.DB_NAME 
            );
                    
            System.out.println( "Fin operaciones" );
            System.out.println( "---------------------" );
        }

} //class
