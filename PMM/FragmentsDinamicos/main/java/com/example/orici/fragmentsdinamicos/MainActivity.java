package com.example.orici.fragmentsdinamicos;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean flag = false;

    final private FragmentManager fm = getFragmentManager();
    private FragmentTransaction ft = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main );

        //Trazas
        /*Log.e( "xxx", "Mensaje de error");
        Log.w( "xxx", "Mensaje de warning");
        Log.i( "xxx", "Mensaje de información");
        Log.d( "xxx", "Mensaje de depuración");
        Log.v( "xxx", "Mensaje de verbose"); /**/

        final TextView label = (TextView) findViewById( R.id.label );
        final Button btn_change = (Button) findViewById( R.id.btn1 );
        final Button btn_reset  = (Button) findViewById( R.id.btn2 );
        final Button btn_erase  = (Button) findViewById( R.id.btn3 );

        Log.i( "@@@", "Recuperadas vistas del XML. Añadiendo listeners..." );

        btn_change.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {
                label.setText( R.string.text2 );

                changeFrBtns();
            }
        });
        btn_reset.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {
                label.setText( R.string.text1 );
            }
        });

        if ( flag ) {
            btn_erase.setOnClickListener( new View.OnClickListener() {
                public void onClick( View v ) {
                    label.setText( "" );
                }
            });
        } //flag

    }

    private void changeFrBtns() {
        //Acciones para mostrar el fragment fr_btns2
        flag = true;
        ft   = fm.beginTransaction();
                ft.replace(
                        R.id.place_btns,
                        new FragmentBtns2()
                );
        /*
         * Replacement is equal that remove and add
         *
        ft.remove(
                new FragmentBtns1()
        );
        ft.add(
                R.id.place_btns,
                new FragmentBtns2()
        );*/

        ft.addToBackStack( null );
        ft.commit();
    } /**/

    private void resetFrBtns() {
        //Acciones para mostrar el fragment fr_btns2
        flag = true;
        ft   = fm.beginTransaction();
                ft.replace(
                        R.id.place_btns,
                        new FragmentBtns1()
                );
        ft.addToBackStack( null );

        ft.commit();
    } /**/

} //class
