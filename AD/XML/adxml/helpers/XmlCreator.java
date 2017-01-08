/**
 * @file: XmlCreator.java
 * @info: 
 * 
 * @utor: Moisés Alcocer, 2016
 */
package helpers;

//imports


/**
 * Class for create Xml files
 * 
 */
public class XmlCreator {

	/**********************************/
	/*** Properties declaration *******/

		private static String file_path;


	/**********************************/
	/*** Methods declaration **********/

		/**
		 * Adds a base node
		 * 
		 * @param file_path
		 * @param base_node_name
		 */
		public static void addContentToBaseNode( String file_path, String base_node_name ) {
			Trace.ln( "XmlCreator / addContentToBaseNode()" );
			Trace.ln( "Path fichero: " + file_path );
			Trace.ln( "Nodo raiz: "    + base_node_name );

			if ( Validations.existFile( file_path )) {

				int node_numbers = Inputs.getInt( 
					"Número de nodos a introducir en el elemento raiz: "
				);
				String node_name = Inputs.getStr( 
					"Nombre para los nodos del elemento raiz: "
				);
				node_name = Utils.replaceWhitespaces( node_name, '_' );
				
				String res = "";
				for ( int i = 0; i < node_numbers; i++ ) {

					res = res 
						+ "<" + node_name + ">\n" 
						+ Inputs.getStr( 
							"Introduce texto para el nodo " 
							+ ( i + 1 ) + ":" 
						)
						+ "\n</" + node_name + ">\n" ;
				}

				//Adds nodes in xml file
				writeStrNodesInFile( file_path, res, base_node_name );

			} else
				System.out.println( "Error. El fichero \"" + file_path + "\" no existe." );
		}

		/**
		 * Gets the xml file content
		 *
		 * @return 	The file content.
		 */
		public static String getFileContent( String root, String title ) {
			
			String content = ""
				+ "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
				+ "<" + root + ">\n";

			if ( ! title.equals( "" ))
				content = content + "<titulo>" + title + "</titulo>\n";
			

			return content + "</" + root + ">\n";
		}

		/**
		 * Aux. 
		 * Creates a base node
		 *
		 * @throws	 IOException
		 */
		private static void writeStrNodesInFile( 
			String file_path, 
			String str_with_nodes,
			String base_node_name
		) {
			//Gets content from file
			String content = Utils.getStrContent( file_path );


			/**
			 * Splits str in two parts in order to appends the new content in the middle
			 * Only run if the open tag hasnot attributes
			 * 
			 */
			int len = base_node_name.length();
			String open_tag  = "<"  + base_node_name + ">"; //without attributes
			String close_tag = "</" + base_node_name + ">";
			
			int pos = content.indexOf( open_tag ) + len + 2;
			String first = content.substring( 0, pos );
			Trace.ln( "Fragm inicial: \n" + first );

			pos = content.indexOf( close_tag );
			String last = content.substring( pos );
			Trace.ln( "Fragm final: \n" + last );

			content = first + "\n" + str_with_nodes + "\n" + last;
			//Trace.ln( "Escrito: \n" + content );

			//Writes the file
			Utils.writeFile( file_path, content );
		}

} // class
