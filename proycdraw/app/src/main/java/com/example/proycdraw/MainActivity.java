package com.example.proycdraw;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.proycdraw.ui.domicilios.DeliveryFragment;
import com.example.proycdraw.ui.ubicacion.LocationFragment;
import com.example.proycdraw.ui.productos.MenuFragment;
import com.example.proycdraw.ui.empleados.OnEmployesFragment;
import com.example.proycdraw.ui.users.OnUserFragment;
import com.example.proycdraw.ui.servicios.ServiciosFragment;
import com.google.android.material.navigation.NavigationView;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mdrawerlayaout;
    NavigationView navigationView;
    Toolbar toolbar;


    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ui
        mdrawerlayaout = findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);

        getSupportFragmentManager().beginTransaction().add(R.id.content,
                new MenuFragment()).commit();
        setTitle("Menu");

        //setup toolbar

        setSupportActionBar(toolbar);
        toggle = setUpDrawelToggle();
        mdrawerlayaout.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(this);
            }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItemNav(item);
        return true;
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    private ActionBarDrawerToggle setUpDrawelToggle(){
        return new ActionBarDrawerToggle(this,mdrawerlayaout,toolbar,
                R.string.drawer_open,R.string.drawer_closed);
    }


    private void selectItemNav(MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (item.getItemId()){
            case R.id.nav_Menu:
                ft.replace(R.id.content,new MenuFragment()).commit();
                break;
            case R.id.nav_delivery:
                ft.replace(R.id.content,new DeliveryFragment()).commit();
                break;
            case R.id.nav_location:
                ft.replace(R.id.content,new LocationFragment()).commit();
                break;
            case R.id.nav_servicios:
                ft.replace(R.id.content,new ServiciosFragment()).commit();
                break;
            case R.id.nav_onemployes:
                ft.replace(R.id.content,new OnEmployesFragment()).commit();
                break;
            case R.id.nav_onuser:
                ft.replace(R.id.content,new OnUserFragment()).commit();
                break;
    }
    setTitle(item.getTitle());
    mdrawerlayaout.closeDrawers();



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}


