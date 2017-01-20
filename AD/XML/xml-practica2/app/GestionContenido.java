package app;

//imports
import app.helpers.Trace;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class GestionContenido extends DefaultHandler {
	
	private String car = "";
	private String element_name = "";
	private String str_content  = "";
	
	private static Jugador player 	 = new Jugador();
	private static Jugadores players = new Jugadores();

		
	public GestionContenido() { 
		super();
	}	
	
	@Override
	public void startDocument() {
		//System.out.println( "Comienzo del documento" );
	}	
	
	@Override
	public void endDocument() {
		//System.out.println( "Fin del documento" );
	}	
	
	public void startElement(	
		String uri, String nombre, String nombreC, Attributes atts
	) { 
		//System.out.print( nombre );
		element_name = nombre;

		if ( "usuario".equals( element_name )) {
			//Trace.ln( "Instanciando jugador..." );
			player = new Jugador();
		}
	}	
	
	@Override
	public void endElement( 
		String uri, 
		String nombre, 
		String nombreC 
	) {
		//Trace.ln( "GestionContenido / endElement() -> " + element_name );

		//System.out.println( "\tFin del Elemento: " + nombre );
		if ( str_content != "" ) {
							   
			if ( "nombre_usuario".equals( element_name ))
				player.setNombre( str_content );

			if ( "horas_jugadas".equals( element_name ))
				player.setHorasJugadas( Integer.parseInt( str_content ));

			if ( "nivel".equals( element_name ))
				player.setNivel( Integer.parseInt( str_content ));

			if ( "puntuacion".equals( element_name )) {
				player.setPuntuacion( Integer.parseInt( str_content ));

				//Guarda jugador en el array
				players.add( player );
			}

						//player = null;
			element_name = "";
			str_content  = "";
		}
	}



	
	@Override
	public void characters( 
		char[] ch, 
		int inicio, 
		int longitud 
	) throws SAXException {

		if ( longitud != 0 ) {
			car = new String( ch, inicio, longitud ); 
			// quitar saltos de línea
			car = car.replaceAll( "[\t\n]","" );		
			
						if ( car.length() > 0 )
							str_content = car;
		}/**/
	}
		
		public static List<Jugador> getPlayers() {
			return players.getListaJugadores();
		}
} //class