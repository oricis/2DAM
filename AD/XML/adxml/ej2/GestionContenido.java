package ej2;


/*import java.util.jar.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;*/

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler{
	
	private String car = "";
	private String element_name = "";
	private String str_content  = "";
        private boolean has_content = false;
	
        
	public GestionContenido() { 
		super();

		
	}	
	
	@Override
	public void startDocument() {
		//System.out.println( "Comienzo del documento" );
		System.out.println( "------------------" );
	}	
	
	@Override
	public void endDocument() {
		//System.out.println( "Fin del documento" );
                if ( ! has_content )
                    System.out.println( "El fichero no contiene datos." );
	}	
	
	public void startElement(	
		String uri, String nombre, String nombreC, Attributes atts
	) { 
		//System.out.print( nombre );
		element_name = nombre;
	}	
	
	@Override
	public void endElement( 
		String uri, 
		String nombre, 
		String nombreC 
	) { 
		//System.out.println( "\tFin del Elemento: " + nombre );
		if ( element_name != "" && str_content != "" ) {
			System.out.println( element_name + ":" + str_content );

			element_name = "";
			str_content  = "";
                        
                        has_content = true;
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
		}
	}
	
} //class