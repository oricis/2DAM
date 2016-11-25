package com.example.orici.fragmentsdinamicos;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Incluye fragmento con TextView en la actividad
 *
 */
public class FragmentLabel extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        try {
            Log.d( "@", "Inflating the layout for label fragment..." );

            return inflater.inflate( R.layout.fr_label, container, false );

        } catch ( InflateException e ) {
            Log.e( "@Err", e.getMessage( ));
        }


        return null;
    }

} //class
