package com.example.proycdraw.ui.ubicacion;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.proycdraw.BuildConfig;
import com.example.proycdraw.R;
import com.example.proycdraw.activity_form;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;


public class LocationFragment extends Fragment {

    private MapView myOpenMapView;
    private MapController myMapController;
View v;
    Drawable drawable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeoPoint madrid = new GeoPoint(40.416775, -3.70379);






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_location, container, false);
        /* ---- necesitamos establecer el valor del agente de usuario en la configuración ------- */
        //pre 5.6
        //OpenStreetMapTileProviderConstants.setUserAgentValue(BuildConfig.APPLICATION_ID);
        //5.6 and newer
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        /* -------------------------------------------------------------------------------------- */

        /*   punto de geolocalizacion de ejemplo */
        GeoPoint Bogota1 = new GeoPoint(4.6351, -74.0703);
        GeoPoint Bogota = new GeoPoint(4.6510, -74.0821);
        GeoPoint Bogota2 = new GeoPoint(4.6410, -74.0921);
        //----------------------------------------------------------------------------------
        myOpenMapView = (MapView) v.findViewById(R.id.openmapview);
        myOpenMapView.setBuiltInZoomControls(true);

        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(Bogota);
        myMapController.setZoom(16);

        myOpenMapView.setMultiTouchControls(true);
        //----------------------------------------------------------------------------------

        /* -------------------------------------------------------------------------------------------------- */
        final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay
                (new GpsMyLocationProvider
                (getContext().getApplicationContext()), myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationoverlay); //No añadir si no quieres una marca
        myLocationoverlay.enableMyLocation();
        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                myMapController.animateTo(myLocationoverlay.getMyLocation());
            }
        });
        /* -------------------------------------------------------------------------------------------------- */
        /**---------------------------------------*/

        ArrayList<OverlayItem> puntos1 = new ArrayList<OverlayItem>();
        puntos1.add(new OverlayItem("Tienda 1", "Carrera 3 # 18‑ 45", Bogota1));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap1 = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa1 = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), puntos1, tap1);
        capa1.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa1);


        /**---------------------------------------*/

        ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
        puntos.add(new OverlayItem("Tienda 3", "Carrera 7 # 84‑ 72", Bogota));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);

/**---------------------------------------*/

        ArrayList<OverlayItem> puntos2 = new ArrayList<OverlayItem>();
        puntos2.add(new OverlayItem("Tienda 2", "Calle 4 No. 5 – 10", Bogota2));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap2 = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa2 = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), puntos2, tap2);
        capa2.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa2);



        /* -------------------------------------------------------------------------------------------------- */



        return v;
    }


}