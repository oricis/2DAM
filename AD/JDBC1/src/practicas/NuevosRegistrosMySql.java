/**
 * @file: NuevosRegistrosMySql.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package practicas;

/**
 * This class ...
 * 
 */
public class NuevosRegistrosMySql {

    /**********************************/
    /*** Properties declaration *******/

    
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public NuevosRegistrosMySql() {
        
            String[] inserts = { 
                "INSERT INTO profesores (NRP, nombre, apellidos, email, fecha_alta, dept_no)"
                + "VALUES (NULL, 'Luis', 'Caracol Orujo', 'lcar@center.ol', CURRENT_TIMESTAMP, '10')",
                "INSERT INTO profesores (NRP, nombre, apellidos, email, fecha_alta, dept_no)" 
                + "VALUES (NULL, 'Isma', 'Serra Fabra', 'ismalion@mail.es', CURRENT_TIMESTAMP, '20')"
            };
            
            new universal.InsertInto(
                inserts,
                "mysql",
                mysql.DbConstants.DB_NAME
            );
        }

} //class
