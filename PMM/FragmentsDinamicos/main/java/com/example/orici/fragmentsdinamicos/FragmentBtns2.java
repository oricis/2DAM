package com.example.orici.fragmentsdinamicos;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by orici on 24/11/2016.
 */

public class FragmentBtns2 extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        try {
            Log.d( "@@@", "Inflating the layout for bottom fragment..." );

            return inflater.inflate( R.layout.fr_btns2, container, false );

        } catch ( InflateException e ) {
            Log.e( "@Err", e.getMessage( ));
        }


        return null;
    }

} //class

