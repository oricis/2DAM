/**
 * @file: GetMetaData.java
 * 
 * @utor: Moisés Alcocer, 2016
 */

package universal;

//imports
import java.sql.*;


/**
 * This class ...
 * 
 */
public class GetMetaData {

    /**********************************/
    /*** Properties declaration *******/

        private Connection con;
        private String db_name = "ejemplo";
    
        
    /**********************************/
    /*** Methods declaration **********/
        
        /**
         * Construct
         * 
         */
        public GetMetaData() {
            Tools.pln( "GetMetaData / construct()" );

            //Get a number (between 1 and 3) for select SGBD to consult
            Tools.pln( "Seleccionando SGBD..." );
            int selected = Tools.getSelectedSGBD();
            
            Tools.pln( "Mostrando MetaDatos del SGBD seleccionado..." );
            showMetaData( selected );
        }

        /**
         * Show the MetaData for the selected SGBD
         * 
         * @param   selected
         */
        private void showMetaData( int selected ) {
            Tools.pln( "GetMetaData / showMetaData()" );

            if ( selected == 1 )
                showDerby();
            
            if ( selected == 2 )
                showSqlite();
            
            if ( selected == 3 )
                showMysql();
        }

        
        private void showDerby() {
            Tools.pln( "GetMetaData / showDerby()" );
            Tools.pln( "Mostrando Metadatos con Derby..." );
            
            derby.DbConnection derbycon = null;
            
            con = derbycon.get( 
                db_name, 
                derby.DbConstants.DB_PATH 
            );

            new ShowMetaData( con, db_name, "departamentos" );
            //new ShowMetaData( con, db_name, "profesores" );
            //new ShowMetaData( con, db_name, "noexisto" );
        }

        private void showSqlite() {
            Tools.pln( "GetMetaData / showSqlite()" );
            Tools.pln( "Mostrando Metadatos con SQLite..." );
            
            sqlite.DbConnection derbycon = null;
            
            con = derbycon.get(
                db_name, 
                sqlite.DbConstants.DB_PATH
            );

            new ShowMetaData( con, db_name, "departamentos" );
            //new ShowMetaData( con, db_name, "profesores" );
            //new ShowMetaData( con, db_name, "noexisto" );
        }

        private void showMysql() {
            Tools.pln( "GetMetaData / showMysql()" );
            Tools.pln( "Mostrando Metadatos con MySql..." );
            
            mysql.DbConnection mysqlcon = null;
            db_name = "ad-ud2";

            con = mysqlcon.get(
                db_name
            );

            new ShowMetaData( con, db_name, "departamentos" );
            //new ShowMetaData( con, db_name, "profesores" );
            //new ShowMetaData( con, db_name, "noexisto" );
        }
        
} //class
