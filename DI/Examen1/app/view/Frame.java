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
 * This class handles the test´s logic
 * 
 */
public class Frame extends LayoutComposer {

    /**********************************/
    /*** Properties declaration *******/

        int[] correctas = null;
        int aciertos = 0;
        int fallos   = 0;
        int nores    = 0; //preguntas no respondidas

        
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

        /**
         * Resets the counters
         * 
         */
        private void resetCounters() {

            aciertos = 0;
            fallos   = 0;
            nores    = 0;
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
                
                //Resetear contadores
                resetCounters();

                
                //Comprobar respuestas
                new Question().check1();
                new Question().check2();
                new Question().check3();
                new Question().check4();
                new Question().check5();


                //Compone string resultado
                String str_respuestas = "Aciertos: " + aciertos + " Fallos: " + fallos;
                if ( nores > 0 )
                    str_respuestas = str_respuestas + "\nNo respondidas: " + nores;


                //Muestra resultado
                JOptionPane.showMessageDialog(
                    null,
                    str_respuestas
                );
            }

    	} //class

        /**
         * This Class gets the response for every question
         * 
         */
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

        } //class

        /**
         * This Class handles the questions
         * 
         */
        private class Question {

            /**********************************/
            /*** Properties declaration *******/
                
                int pos = 0;


            /**********************************/
            /*** Methods declaration **********/
            
                public void check1() {
                    int res_pregunta_1 = new Response().getFrom1();
                    
                    //Trazas
                    System.out.println( "Respuesta 1: " + res_pregunta_1 );
                    if ( res_pregunta_1 == 5 )
                        nores++;

                    else {
                        
                        pos = correctas[0];

                        //Traza
                        System.out.println( "Correcta: " + pos + " / Respuesta: " + res_pregunta_1 );
                        //res_pregunta_1 se espera que sea acertara si es igual a (pos - 1)
                        String res = ( pregunta[pos] == pregunta[res_pregunta_1] )
                            ? "Respuesta 1: OK"
                            : "Respuesta 1: ERR";
                        System.out.println( res );

                        if (( pos - 1 ) == res_pregunta_1 )
                            aciertos++;
                        else
                            fallos++;
                    }
                }

                public void check2() {
                    int res_pregunta_2 = new Response().getFrom2();
                    System.out.println( "Respuesta 2: " + res_pregunta_2 );
                    
                    if ( res_pregunta_2 == 5 )
                        nores++;

                    else {
                        pos = correctas[1];

                        if (( pos - 1 ) == res_pregunta_2 )
                            aciertos++;
                        else
                            fallos++;
                    }
                }

                public void check3() {
                    int res_pregunta_3 = new Response().getFrom3();
                    System.out.println( "Respuesta 3: " + res_pregunta_3 );
                    
                    if ( res_pregunta_3 == 5 )
                        nores++;

                    else {
                        pos = correctas[2];

                        if (( pos - 1 ) == res_pregunta_3 )
                            aciertos++;
                        else
                            fallos++;
                    }
                }

                public void check4() {
                    int res_pregunta_4 = new Response().getFrom4();
                    System.out.println( "Respuesta 4: " + res_pregunta_4 );
                    
                    if ( res_pregunta_4 == 5 )
                        nores++;

                    else {
                        pos = correctas[3];

                        if (( pos - 1 ) == res_pregunta_4 )
                            aciertos++;
                        else
                            fallos++;
                    }
                }

                public void check5() {
                    int res_pregunta_5 = new Response().getFrom5();
                    System.out.println( "Respuesta 5: " + res_pregunta_5 );

                    if ( res_pregunta_5 == 5 )
                        nores++;

                    else {
                        pos = correctas[4];

                        if (( pos - 1 ) == res_pregunta_5 )
                            aciertos++;
                        else
                            fallos++;
                    }
                }

        } //class
        
} //class
