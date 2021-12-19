package com.example.proycdraw.ui.productos;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.proycdraw.R;
import com.example.proycdraw.activity_form;
import com.example.proycdraw.adapters.ProductoAdapter;
import com.example.proycdraw.casos_uso.CasoUsoProducto;
import com.example.proycdraw.datos.DBhelper;
import com.example.proycdraw.modelos.Producto;

import java.util.ArrayList;


public class MenuFragment extends Fragment {
    private String TABLE_NAME = "PRODUCTOS";
    private CasoUsoProducto casoUsoProducto;
    private GridView gridView;
    private DBhelper dbHelper;
    private ArrayList<Producto> productos;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_menu, container,false);
        try{
            casoUsoProducto = new CasoUsoProducto();
            dbHelper = new DBhelper(getContext());
            Cursor cursor = dbHelper.getData(TABLE_NAME);
            productos = casoUsoProducto.llenarListaProductos(cursor);
            gridView = (GridView) root.findViewById(R.id.gridProductos);
            ProductoAdapter productoAdapter = new ProductoAdapter(root.getContext(), productos);
            gridView.setAdapter(productoAdapter);
        }catch (Exception e){
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




}