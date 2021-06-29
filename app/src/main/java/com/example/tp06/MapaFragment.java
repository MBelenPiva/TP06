package com.example.tp06;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

public class MapaFragment extends Fragment {
    private View layoutRoot = null;
    private Button btn1, btn2, btn3, btn4;
    private MapView mapView;
    private GoogleMap googleMap;


    public MapaFragment() {
    }

    @Override
    public void onCreate(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

        LogHelper.d("MapaFragment -> onCreateView");

             if (layoutRoot == null) {
                LayoutRoot = inflater.inflate(R.layout.fragment_mapa, container, false);

                ObtenerReferencias();

                SetearListeners();

                mapView.OnCreate(savedInstanceState);
                mapView.OnResume();

        }
    }
}