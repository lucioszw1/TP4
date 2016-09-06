package com.example.gerini.tp4;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.io.IOException;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Principal extends AppCompatActivity
{

    ArrayList<Ciudad> ciudades;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Fragment fragment= new Fragment();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.contenedor, fragment).commit();

    }

    public void b1 (View view)
    {
        Fragment fragment= new Fragment();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.contenedor, fragment).commit();
    }
    //onmapready ya esta en fragmentjuego

    /*
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true); // Habilita +/- para hacer zoom
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);    // Selecciona tipo de mapa satelital
        LatLng latLng = new LatLng(-34.5440425,-58.4505259);
        CameraUpdate bsas= CameraUpdateFactory.newLatLng(latLng);
        map.moveCamera(bsas);
        CameraUpdate zoom= CameraUpdateFactory.zoomTo(2);
        map.animateCamera(zoom);
        MarkerOptions mo = new MarkerOptions()
                .position(latLng)
                .title(("Buenos Aires"));
        map.addMarker(mo);
    }

*/


    private class BuscarDatosTask extends AsyncTask<String, Void, ArrayList<Ciudad>> {

        protected void onPostExecute(ArrayList<Ciudad> datos) {
            super.onPostExecute(datos);
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://tp4ort.firebaseio.com/geonames.json")
                    .build();
            try {
                Response response = client.newCall(request).execute();  // Llamo al API Rest servicio1 en ejemplo.com
                String resultado = response.body().string();
            } catch (IOException e) {
                Log.d("Error",e.getMessage());             // Error de Network
                return;
            }
        }
        //http://campus.almagro.ort.edu.ar/informatica/prog/articulo/751649/consumiendo-apis-rest
        //Gero, llegue hasta donde dice "Como acceder a la red"
        //Ok, creo que rompi todoo el programa

        public ArrayList<Ciudad> ObtenerListaCiudades(){
            return ciudades;
        }



        @Override
        protected ArrayList<Ciudad> doInBackground(String... parametros) {
            String url = parametros[0];
            return new ArrayList<Ciudad>();
        }
    }
    String url ="https://tp4ort.firebaseio.com/geonames.json";
}
