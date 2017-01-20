/**
 * @file: Jugador.java
 * 
 * @utor: Moisés Alcocer, 2017
 */
package app;

//imports


public class Jugador implements java.io.Serializable {

	/**********************************/
	/*** Properties declaration *******/

		private String nombre;
		private int horas_jugadas;
		private int nivel;
		private int puntuacion;


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Construct
		 *
		 * @param	  nombre		 The nombre
		 * @param	  horas_jugadas  The horas jugadas
		 * @param	  nivel		  The nivel
		 * @param	  puntuacion	 The puntuacion
		 */
		public Jugador(
			String nombre, 
			int horas_jugadas, 
			int nivel, 
			int puntuacion
		) {
			
			this.nombre 		= nombre;
			this.horas_jugadas 	= horas_jugadas;
			this.nivel 			= nivel;
			this.puntuacion 	= puntuacion;
		}

		public Jugador() {}


	/**
	 * Getters and Setters
	 *
	 */

		public String getNombre() {
			return nombre;
		}

		public int getHorasJugadas() {
			return horas_jugadas;
		}

		public int getNivel() {
			return nivel;
		}

		public int getPuntuacion() {
			return puntuacion;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public void setHorasJugadas(int horas_jugadas) {
			this.horas_jugadas = horas_jugadas;
		}

		public void setNivel(int nivel) {
			this.nivel = nivel;
		}

		public void setPuntuacion(int puntuacion) {
			this.puntuacion = puntuacion;
		}

} //class
