package com.example.tp06;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tp06.Utils.ValidacionesHelpers;

public class AcercaDeFragment extends Fragment {
    MapaFragment mapaFragment;
    AcercaDeFragment acercaDeFragment;
    RankingFragment rankingFragment;

    TextView textView;
    Button btnComenzar;
    Button btnRanking;

    View layoutroot;

    public AcercaDeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(layoutroot == null){
            layoutroot = inflater.inflate(R.layout.fragment_acerca_de, container, false);
        }

        ObtenerReferencias();

        SetearListeners();

        return layoutroot;

    }

    private void ObtenerReferencias(){
        textView = (TextView) layoutroot.findViewById(R.id.textView);
        btnComenzar = (Button)layoutroot.findViewById(R.id.btnComenzar);
        btnRanking = (Button)layoutroot.findViewById(R.id.btnRanking);
    }

    private void SetearListeners(){
        btnComenzar.setOnClickListener(btnComenzar_Click);
    }

    View.OnClickListener btnComenzar_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
              // ir a MapaFragment
        }
    };

}