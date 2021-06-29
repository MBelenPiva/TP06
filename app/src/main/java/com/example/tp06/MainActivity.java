package com.example.tp06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtNombre;
    private Button btnContinuar;

    MapaFragment mapaFragment;
    AcercaDeFragment acercaDeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ObtenerReferencias();

        SetearListeners();

        createFragments();

        showInitialFragment();
    }

    private void ObtenerReferencias(){
        edtNombre = findViewById(R.id.edtNombre);
        btnContinuar = findViewById(R.id.btnContinuar);
    }

    private void SetearListeners(){
        btnContinuar = findViewById(btnContinuar_Click);
    }

    private View.OnClickListener btnContinuar_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToFragmentWithReplace(acercaDeFragment, true);
        }
    };

    private void createFragments(){
        mapaFragment = new MapaFragment();
        acercaDeFragment = new AcercaDeFragment();
    }

    private void showInitialFragment(){
        goToFragmentWithReplace(mapaFragment, true);
    }
}