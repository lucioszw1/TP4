package com.example.gerini.tp4;


import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 41665767 on 9/8/2016.
 */
public class FragmentJuego extends android.support.v4.app.Fragment implements OnMapReadyCallback {

        GoogleMap map;
        Button btn1;
        Button btn2;
        Button btn3;
        Button btn4;
        Ciudad ciudadcorrecta;

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.juego_fragment, container, false);
            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.mapa);
            mapFragment.getMapAsync(this);
            btn1 = (Button) v.findViewById(R.id.btn1);
            btn2 = (Button) v.findViewById(R.id.btn2);
            btn3 = (Button) v.findViewById(R.id.btn3);
            btn4 = (Button) v.findViewById(R.id.btn4);
            return v;
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            Principal pr=(Principal) getActivity();
            //ArrayList<Ciudad> ciudades = pr.ObtenerListaCiudades();
            //ArrayList<Ciudad> ciudadesclon =(ArrayList<Ciudad>)ciudades.clone();
            ArrayList<Ciudad> ciudadeselegidas= new ArrayList<>();



            for(int i=0;i>=4;i++){
                Random random= new Random();
              //  i=random.nextInt(ciudades.size());
                // Ciudad c=ciudades.get(i);
                // ciudadeselegidas.add(c);
                //ciudades.remove(i);
            }
            Random ran= new Random();
            int x=ran.nextInt(4);
            ciudadcorrecta= ciudadeselegidas.get(x);
            btn1.setText(ciudadeselegidas.get(1).getName());
            btn2.setText(ciudadeselegidas.get(2).getName());
            btn3.setText(ciudadeselegidas.get(3).getName());
            btn4.setText(ciudadeselegidas.get(4).getName());


            map = googleMap;
            map.getUiSettings().setZoomControlsEnabled(true); // Habilita +/- para hacer zoom
            map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);    // Selecciona tipo de mapa satelital
            LatLng marker = new LatLng(ciudadcorrecta.getLat(),ciudadcorrecta.getLng());
            CameraUpdate cu= CameraUpdateFactory.newLatLng(marker);
            map.moveCamera(cu);
            CameraUpdate zoom= CameraUpdateFactory.zoomTo(3);
            map.animateCamera(zoom);

            MarkerOptions mo = new MarkerOptions()
                    .position(marker);
            map.addMarker(mo);

        }


    }







