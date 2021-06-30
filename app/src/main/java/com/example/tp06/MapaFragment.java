package com.example.tp06;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;

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

                try{
                    MapsInitializer.initialize(getMainActivity().getApplicationContext());
                } catch (Exception e) {
                    LogHelper.d(e.getMessage());
                }
             }
             mapView.getMapAsync(mapView_getMapAsync);

             setActivityTitle('MAPA');

             return layoutRoot;
    }

    private void ObtenerReferencias(){
        mapView = (MapView) layoutRoot.findViewById(R.id.mapView);
        btn1 = (Button) layoutRoot.findViewById(R.id.btn1);
        btn2 = (Button) layoutRoot.findViewById(R.id.btn2);
        btn3 = (Button) layoutRoot.findViewById(R.id.btn3);
        btn4 = (Button) layoutRoot.findViewById(R.id.btn4);
    }

    private void SetearListeners(){
        btn1.setOnClickListener(btn1_Click);
        btn2.setOnClickListener(btn2_Click);
        btn3.setOnClickListener(btn3_Click);
        btn4.setOnClickListener(btn4_Click);
    }

    private View.OnClickListener btn1_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AgregarMarkersAlGoogleMap();
        }
    };

    private View.OnClickListener btn2_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            PropiedadesDeUnMarker();
        }
    };

    private View.OnClickListener btn3_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AgregarUnListDeMarkers();
        }
    };

    private View.OnClickListener btn4_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Polylines();
        }
    };

    private void AgregarMarkersAlGoogleMap(){
        LatLng latLngEstatuaDeLaLibertad, latLngLaTorreEiffel, latLngInsadong, latLngCabildo;
        MarkerOptions markerEstatuaDeLaLibertad, markerLaTorreEiffel, markerInsadong, markerCabildo;
        CameraPosition cameraPosition;

        googleMap.clear();

        markerList = GetUsuariosMarkeroptions();
        firstMarkerPosition = markerList.get(0).getPosition();

        for (int i = 0; i < markerList.size(); i++){
            googleMap.addMarker(markerList.get(i));
        }

        cameraPosition = new CameraPosition.Builder().target(firstMarkerPosition).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    protected OnMapReadyCallback mapView_getMapAsync = new OnMapReadyCallback() {
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap = map;

            LatLng latLngEstatuaDeLaLibertad = new LatLng(-99.112203, 19.314512);
            MarkerOptions markerEstatuaDeLaLibertad = new MarkerOptions()
                    .position(latLngEstatuaDeLaLibertad)
                    .title("Estatua de la libertad, New York")
                    .snippet("Lugar hermoso para visitar..");
             googleMap.addMarker(markerEstatuaDeLaLibertad);

             CameraPosition cameraPosition;
             cameraPosition = new CameraPosition.Builder().target(latLngEstatuaDeLaLibertad).zoom(12).build();
             googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));




        }
    };

}