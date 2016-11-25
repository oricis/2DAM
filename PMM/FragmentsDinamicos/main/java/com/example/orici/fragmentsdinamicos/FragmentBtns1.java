package com.example.orici.fragmentsdinamicos;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Incluye fragmento con los botones en la actividad
 *
 */
public class FragmentBtns1 extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        try {
            Log.d( "@", "Inflating the layout for buttons fragment..." );

            return inflater.inflate( R.layout.fr_btns1, container, false );

        } catch ( InflateException e ) {
            Log.e( "@Err", e.getMessage( ));
        }


        return null;
    }

} //class
