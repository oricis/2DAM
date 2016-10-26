/**
 * @file: Practica_9_4.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package practicas;

//imports
import java.sql.*;
import javax.xml.transform.*;

/**
 * This class solve practice 9.4 - PreparedStatement
 * 
 * Visualizar los datos de los empleados de un departamento. 
 * Al final de la lista aparecerá una línea del estilo: 
 * El departamento INFORMATICA tiene XX profesores con un sueldo máximo de xxxxxx. 
 * Si el departamento no existe deberá aparecer la línea:  
 * El departamento no existe. 
 * Si el departamento no tiene profesores deberá aparecer la línea:  
 * El departamento XXXXXX no tiene profesores.
 * 
 * 
 * ¿Qué necesito entrar al programa? Nombre de dept
 * ¿Cómo obtengo los datos? 1 o varias consultas
 * ¿Cómo se que una consulta no devolvio resultados, p.e. departamento inexistente? Contar filas del ResultSet
 * 
 */
public class Practica_9_4 implements Result {

    /**********************************/
    /*** Properties declaration *******/

        private Connection con;
        private PreparedStatement pst;
        private ResultSet rs;

        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         *
         * @param dept
         */
        public Practica_9_4( String dept ) {
            System.out.println( "Practica_9_4 / Construct()" );


            String sgbd  = "mysql";
            int num_prof = 0;
            
            
            if ( "mysql".equals( sgbd )) {

                //Set queries
                String subselect = "SELECT dept_no FROM departamentos WHERE dnombre=?";
                String select    = "SELECT nombre, apellidos, salario FROM profesores"
                    + " WHERE dept_no=( " + subselect + " ) ORDER BY nombre ASC";

                System.out.println( "SQL*: " + select );
                
                //Open and get connection
                con = universal.GetConnection.get( sgbd, mysql.DbConstants.DB_NAME );
                System.out.println( "Conexión establecida !" );

                try {
                    
                    //Create PreparedStatement
                    System.out.println( "Creando PreparedStatement..." );
                    pst = con.prepareStatement( select );

                    //Set PreparedStatement params
                    System.out.println( "Seteando parámetros..." );
                    pst.setString( 1, dept );
                    

                    System.out.println( "Ejecutando sentencia..." );
                    rs = pst.executeQuery();
                    //SELECT nombre, apellidos, salario FROM profesores 
                    //WHERE dept_no=( SELECT dept_no FROM departamentos WHERE dnombre='FOL' ) 
                    //  ORDER BY nombre ASC

                    System.out.println( "\nResultados:" );
                    while ( rs.next( )) {
                        
                        //System.out.print( "Número: " + rs.getInt( "num" ) + " " );
                        System.out.print( rs.getString( "nombre" ) + " " );
                        System.out.print( rs.getString( "apellidos" ));
                        System.out.println( " / Salario: " + rs.getInt( "salario" ));
                        
                        //Count teachers
                        num_prof++;
                    }
                    System.out.println( "---------------------------------" );
                    
                    //Muestra número de profesores del dept
                    
                    //Hay profesores
                    if ( num_prof > 0 )
                        System.out.println( "En el dept de " + dept + " hay " + num_prof + " profesores." );

                    //NO hay profesores
                    //ResultSet sin registros -> 2 causas posibles:
                    //  - El departamento no existe. 
                    //  - El departamento existe pero no tiene profesores
                    else {

                        //System.out.println( "Comprobando si dept de " + dept + " existe..." );

                        //Crear otro PrepareStatement para saber si el dept existe
                        pst = con.prepareStatement( subselect );
                        pst.setString( 1, dept );

                        //System.out.println( "Ejecutando sentencia..." );
                        rs = pst.executeQuery();

                        //El ResulSet tiene contenido (dept_no del dept dado)
                        if ( rs.next( ))
                            System.out.println( "El dept de " + dept + " no tiene profesores." );
                        else
                            System.out.println( "El dept de " + dept + " NO existe..." );
                    }


                    System.out.println( "---------------------------------\n" );
                    


                    //Free resources
                    System.out.println( "Cerrando PreparedStatement..." );
                    pst.close();

                    System.out.println( "Cerrando Connection..." );
                    con.close();

                } catch( SQLException e ) {

                    System.out.println( "Cerrando PreparedStatement..." );
                    System.out.println( "---> " + e.toString( ));
                } /**/

            } else
                System.out.println( "Error. No has pasado mysql como SGBD" );
        }

    @Override
    public void setSystemId(String systemId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSystemId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} //class
