package com.example.tp06;

import android.graphics.Camera;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.example.tp06.Utils.LogHelper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

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
                layoutRoot = inflater.inflate(R.layout.fragment_mapa, container, false);

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

        cameraPosition = new CameraPosition.Builder().target(latLngEstatuaDeLaLibertad).zoom(10).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        /*
        ZOOM
        https://developers.google.com/maps/documentation/android-sdk/views
        1: World
        5: Continent
        10: City
        15: Streets
        20: Buildings
         */
    }

    private void PropiedadesDeUnMarker(){
        LatLng latLngEstatuaDeLaLibertad, latLngLaTorreEiffel, latLngInsadong, latLngCabildo;
        MarkerOptions markerEstatuaDeLaLibertad, markerLaTorreEiffel, markerInsadong, markerCabildo;
        CameraPosition cameraPosition;

        markerEstatuaDeLaLibertad.alpha(0.5f); //opacidad

        markerEstatuaDeLaLibertad.icon(BitmapDescriptorFactory.fromResource(R.drawable.custom_marker));

        //rotando el marker 90 grados
        markerEstatuaDeLaLibertad.rotation(90.f);
        markerLaTorreEiffel.rotation(90.f);
        markerInsadong.rotation(90.f);
        markerCabildo.rotation(90.f);

        googleMap.addMarker(markerEstatuaDeLaLibertad);
        googleMap.addMarker(markerLaTorreEiffel);
        googleMap.addMarker(markerInsadong);
        googleMap.addMarker(markerCabildo);

        //pongo el target, el Zoom y animo la camara.

        cameraPosition = new CameraPosition.Builder().target(latLngEstatuaDeLaLibertad).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private void AgregarUnListDeMarkers(){
        ArrayList<MarkerOptions> markerList;
        LatLng firstMarkerPosition;
        CameraPosition cameraPosition;

        googleMap.clear();

        //obtengo un ArrayList de Markers, y me guardo el primero asi le seteo como Target.

        markerList = GetUsuarioMarkeroptions();
        firstMarkerPosition = markerList.get(0).getPosition();

        //agrego los markers al mapa

        for(int i = 0; i < markerList.size(); i++){
            googleMap.addMarker(markerList.get(i));
        }

        //pongo el target, el zoom y animo la camara.

        cameraPosition = new CameraPosition.Builder().target(firstMarkerPosition).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private void Polylines(){
        LatLng latLngEstatuaDeLaLibertad, latLngLaTorreEiffel, latLngInsadong, latLngCabildo;
        MarkerOptions markerEstatuaDeLaLibertad, markerLaTorreEiffel, markerInsadong, markerCabildo;
        CameraPosition cameraPosition;

        latLngEstatuaDeLaLibertad = new LatLng(19.314512, -99.112203);
        latLngLaTorreEiffel = new LatLng(48.8583701, 2.2944813);
        latLngInsadong = new LatLng(37.566, 126.9784);
        latLngCabildo = new LatLng(-38.4833, -61.9);

        markerEstatuaDeLaLibertad = GoogleMapHelper.CreateMarker(latLngEstatuaDeLaLibertad,
                "Estatua de la libertad", "Primera vision de los inmigrantes europeos al llegar a Estados Unidos",
                BitmapDescriptorFactory.fromResource(R.drawable.custom_marker));

        markerLaTorreEiffel = GoogleMapHelper.CreateMarker(latLngLaTorreEiffel,
                "La Torre Eiffel", "Una de las obras más importantes",
                BitmapDescriptorFactory.fromResource(R.drawable.custom_marker));

        markerInsadong = GoogleMapHelper.CreateMarker(latLngInsadong,
                "Insadong", "Lugar turistico de corea",
                BitmapDescriptorFactory.fromResource(R.drawable.custom_marker));

        markerCabildo = GoogleMapHelper.CreateMarker(latLngCabildo,
                "El Cabildo", "Fue una de las primeras expresiones democráticas que vivió esta gran aldea",
                BitmapDescriptorFactory.fromResource(R.drawable.custom_marker));

        googleMap.addMarker(markerEstatuaDeLaLibertad);
        googleMap.addMarker(markerLaTorreEiffel);
        googleMap.addMarker(markerInsadong);
        googleMap.addMarker(markerCabildo);

        //https://developers.google.com/maps/documentation/android-sdk/polygon-tutorial
        //agrego los polylines

        Polyline polyline = googleMap.addPolyline(new PolylineOptions()
        .add(latLngEstatuaDeLaLibertad, latLngLaTorreEiffel, latLngInsadong, latLngCabildo));

        cameraPosition = new CameraPosition.Builder().target(latLngEstatuaDeLaLibertad).zoom(12).build();
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