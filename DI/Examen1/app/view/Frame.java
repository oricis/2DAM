/**
 * @file: Frame.php
 * 
 * @utor: Moisés Alcocer, 2016
 */

package app.view;

//imports

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



/**
 * This class ...
 * 
 */
public class Frame extends LayoutComposer {

    /**********************************/
    /*** Properties declaration *******/

        int[] correctas = null;

        
    /**********************************/
    /*** Methods declaration **********/

	    /**
	     * Method description
	     *
	     * @param  preguntas
         * @param   correctas
	     */
	    public Frame( String[][] preguntas, int[] correctas ) {
			super( preguntas );
            this.correctas = correctas;


            btn.addActionListener( new AppListener( ));
	    }


    /**********************************/
    /*** Internal clases **************/

    	/**
    	 * Class to listen events
    	 * 
    	 */
    	private class AppListener implements ActionListener {

            @Override
            public void actionPerformed( ActionEvent e ) {
                
                int aciertos = 0;
                int fallos   = 0;
                int pos      = 0;
                String res   = "";

                //respuestas
                int res_pregunta_1 = new Response().getFrom1();
                if ( res_pregunta_1 == 5 )
                    fallos++;

                else {
                    System.out.println( "Respuesta 1: " + res_pregunta_1 );
                    pos = correctas[0];
                    res = ( pregunta[pos] == pregunta[res_pregunta_1] )
                        ? "Respuesta 1: OK"
                        : "Respuesta 1: ERR";
                    System.out.println( res );
                }
                

                int res_pregunta_2 = new Response().getFrom2();
                System.out.println( "Respuesta 2: " + res_pregunta_2 );
                pos = correctas[1];

                int res_pregunta_3 = new Response().getFrom3();
                System.out.println( "Respuesta 3: " + res_pregunta_3 );
                pos = correctas[2];

                int res_pregunta_4 = new Response().getFrom4();
                System.out.println( "Respuesta 4: " + res_pregunta_4 );
                pos = correctas[3];

                int res_pregunta_5 = new Response().getFrom5();
                System.out.println( "Respuesta 5: " + res_pregunta_5 );
                pos = correctas[5];


                String str_respuestas = "Aciertos: " + aciertos + " Fallos: " + fallos;
                JOptionPane.showMessageDialog(
                    null,
                    str_respuestas
                );
            }

    	} //class



        private class Response {
            
            public int getFrom1() {
                System.out.println( "Response / getFrom1" );

                if ( rb_1a.isSelected( ))
                    return 0;

                if ( rb_2a.isSelected( ))
                    return 1;

                if ( rb_3a.isSelected( ))
                    return 2;


                return 5;
            }

            public int getFrom2() {
                System.out.println( "Response / getFrom1" );

                if ( rb_1b.isSelected( ))
                    return 0;

                if ( rb_2b.isSelected( ))
                    return 1;

                if ( rb_3b.isSelected( ))
                    return 2;


                return 5;
            }

            public int getFrom3() {
                System.out.println( "Response / getFrom1" );

                if ( rb_1c.isSelected( ))
                    return 0;

                if ( rb_2c.isSelected( ))
                    return 1;

                if ( rb_3c.isSelected( ))
                    return 2;


                return 5;
            }

            public int getFrom4() {
                System.out.println( "Response / getFrom1" );

                if ( rb_1d.isSelected( ))
                    return 0;

                if ( rb_2d.isSelected( ))
                    return 1;

                if ( rb_3d.isSelected( ))
                    return 2;


                return 5;
            }

            public int getFrom5() {
                System.out.println( "Response / getFrom1" );

                if ( rb_1e.isSelected( ))
                    return 0;

                if ( rb_2e.isSelected( ))
                    return 1;

                if ( rb_3e.isSelected( ))
                    return 2;


                return 5;
            }

        }//class

} //class
