package com.example.tp06;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tp06.Bases.BaseActivity;
import com.example.tp06.Bases.BaseFragment;


public class InicioFragment extends BaseFragment {
    private EditText edtNombre;
    private Button btnContinuar;

    MapaFragment mapaFragment;
    AcercaDeFragment acercaDeFragment;
    View layoutRoot;


    public InicioFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(layoutRoot == null){
            layoutRoot = inflater.inflate(R.layout.fragment_acerca_de, container, false);
        }

        ObtenerReferencias();

        SetearListeners();

        return layoutRoot;

    }

    private void ObtenerReferencias(){
        edtNombre= (EditText) layoutRoot.findViewById(R.id.edtNombre);
        btnContinuar = (Button) layoutRoot.findViewById(R.id.btnContinuar);
    }

    private void SetearListeners() {
        btnContinuar.setOnClickListener(btnContinuar_Click);
    }

    private View.OnClickListener btnContinuar_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // ir a acercaDeFragment
        }
    };


}