/**
 * @file: Jugadores.java
 * 
 * @utor: Moisés Alcocer, 2017
 */
package app;

//imports
import java.util.ArrayList;
import java.util.List;


public class Jugadores {

	/**********************************/
	/*** Properties declaration *******/

		private List<Jugador> lista = new ArrayList<>();


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 *
		 */
		public Jugadores() {}

		/**
		 * Adds a player to the list
		 *
		 * @param	  player  The player
		 */
		public void add( Jugador player ) {
			lista.add( player );
		}
 
		/**
		 * Adds the list
		 *
		 * @param lista
		 */
		public void setList( List<Jugador> lista ) {
			this.lista = lista;
		}

		/**
		 * Gets the list of players
		 *
		 * @return	 The lista jugadores.
		 */
		public List<Jugador> getListaJugadores() {
			return lista;
		}

} //class
