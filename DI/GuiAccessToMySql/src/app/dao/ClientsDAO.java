/**
 * @file: ClientsDAO.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.dao;

//imports
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.helpers.Trace;
import java.sql.Array;


/**
 * This class connect the App with the DataBase
 * 
 */
public final class ClientsDAO implements DAO {
    
    /**********************************/
    /*** Properties declaration *******/
    
        private Connection con = null;
        private ResultSet rs;
        private Statement st;
        
        private Client c;
        private Client[] arr;

        private final String table_name = "clients";

    
    /**********************************/
    /*** Methods declaration **********/
    
        /**
         * Construct
         * 
         */
        public ClientsDAO() {
            
            setConnection();
        }


    //////////////////////////////////////////////////////////////////////
    //// Methods to handle DB Connection /////////////////////////////////
    ////
        
        /**
         * Closes a connection
         * 
         * @Override
         */
        public void closeConnection() {
            Trace.ln( "ClientsDAO / closeConnection()" );
            Trace.ln( "Trying close the db connection..." );

            if ( this.con != null ) {

                try {
                    this.con.close();

                } catch( SQLException e ) {

                    System.out.println( "Error closing db connection !" );
                    System.out.println( "---> " + e.toString( ));
                }
            }
        }

        /**
         * Opens the connection and sets in class propertie
         * 
         * @Override
         */
        public void setConnection() {

            DbConnection dbcon = new DbConnection(
                DbConstants.DB_NAME, 
                DbConstants.USER,
                DbConstants.PASS
            );

            this.con = dbcon.get();
        }


    //////////////////////////////////////////////////////////////////////
    //// CRUD Methods ////////////////////////////////////////////////////
    ////

        /**
         * Returns a row from table "clients"
         * 
         * @param id
         * @return  c
         */
        @Override
        public Client selectOne( int id ) {

            if ( con != null ) {
                
                //Select
                String sql = "SELECT * FROM " + table_name + " WHERE id=" + id;

                try {

                    //Create a Statement
                    st = con.createStatement();

                    //Run the query
                    rs = st.executeQuery( sql );

                    if ( rs.next( )) {

                        c = new Client( 
                            rs.getInt( "id" ),
                            rs.getString( "notes" )
                        );


                        return c;

                    } else
                        System.out.println( "The ResultSet is empty !" );

                    Trace.ln( "Free resources..." );
                    rs.close();


                } catch( SQLException e ) {

                    System.out.println( "Error getting a client !" );
                    System.out.println( "---> " + e.toString( ));

                    //To avoid errors in future queries when the actual 
                    //not found nothing ( connection won´t be closing)
                    return null;
                }

            } else
                System.out.println( "Err. The Connection is closed !" );
            

            return null;
        }

        /**
         * Returns all rows from table "clients"
         * 
         * @return  arr
         */
        @Override
        public Client[] selectAll() {
                
            if ( con != null ) {
                
                //Select
                String sql = "SELECT * FROM " + table_name;

                try {

                    //Create a Statement
                    st = con.createStatement();

                    //Run the query
                    rs = st.executeQuery( sql );

                    setClients( rs );

                    if ( arr.length > 0 )
                        return arr;

                    else
                        System.out.println( "The ResultSet is empty !" );

                    Trace.ln( "Free resources..." );
                    rs.close();
                    closeConnection();

                } catch( SQLException e ) {

                    System.out.println( "Error getting a client !" );
                    System.out.println( "---> " + e.toString( ));
                }

            } else
                System.out.println( "Err. The Connection is closed !" );
            

            return null;
        }

        @Override
        public void delete(Object o) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        @Override
        public void edit(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        @Override
        public void insert(Object o) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
        /**
         * Sets array with the clients from the ResultSet
         *
         * @param   rs  ResultSet
         * @return  Client[]
         */
        private Client[] setClients( ResultSet rs ) {
            
            //Gets number of rows in a ResultSet
            int i = app.helpers.SQL.getResultSetSize( rs );

            //Create the array
            arr = new Client[ i ];

            //Reinitialize var
            i = 0;
            
            try {
                
                while ( rs.next( )) {
                    
                    int id     = rs.getInt( "id" );
                    String str = rs.getString( "notes" );
                    
                    Client x = new Client( id, str );
                    arr[ i ] = x;
                    
                    i++;
                }
                
            } catch( SQLException e ) {
                
                System.out.println( "Error looping the ResultSet !" );
                System.out.println( "---> " + e.toString( ));
            }
                
            return arr;
        }
        
} //class
