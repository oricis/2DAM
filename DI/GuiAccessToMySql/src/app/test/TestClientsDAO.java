/**
 * @file: TestClientsDAO.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.test;

//imports
import app.dao.Client;
import app.dao.ClientsDAO;
import app.helpers.Trace;


/**
 * Test class "ClientsDAO"
 *
 */
public class TestClientsDAO {

    /**********************************/
    /*** Properties declaration *******/

        private Client c = null;
        private final ClientsDAO cdao = new ClientsDAO();

    
    /**********************************/
    /*** Methods declaration **********/

        /**
         * Construct
         * 
         */
        public TestClientsDAO() {
            Trace.ln( "\nTestClientsDAO / Construct()" );



            Trace.ln( "Show data for the Client with ID: 1" );
        	showOne( 1 );

        	Trace.ln( "Show data for the Client with ID: 3" );
        	showOne( 3 );

            Trace.lsep();
            
            Trace.ln( "Show data for all Clients" );
        	showAll();
            
            Trace.lsep( 2 );
        }

        /**
         * Gets a Client from DB and shows data content
         *
         * @param   id
         */
        private void showOne( int id ) {
            
            c = cdao.selectOne( id );
            showClientData();
        }

        /**
         * Gets all Clients from DB and shows data content
         * 
         */
        private void showAll() {
            
            Client[] arr = cdao.selectAll();
            Trace.ln( "Rows loaded !" );
            
            int i   = 0;
            int len = arr.length;
            
            Trace.ln( "Has been retrieved " + len + " rows !\n" );
            
            while ( i < len ) {

                c = arr[ i ];
                showClientData();

                i++;
            }
        }


        /**
         * Aux. 
         * Shows the client data
         * 
         */
        private void showClientData() {
            
            if ( c != null ) {

                System.out.print( "ID: " + c.getId( ));
                System.out.println( " -> " + c.getNotes( ));
                
            } else
                System.out.println( "Error retrieve Client !" );
        }

} //class
