package com.example.tp06;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
        return inflater.inflate(R.layout.fragment_acerca_de, container, false);
    }
}