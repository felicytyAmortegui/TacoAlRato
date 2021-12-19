package com.example.proycdraw.ui.servicios;

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

import com.example.proycdraw.R;
import com.example.proycdraw.activity_form;


public class ServiciosFragment extends Fragment {


    View v;
    ImageView servimage2,  servimage1, servimage3, servimage6, servimage4;
    ImageButton servimageB;
    Drawable drawable;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v=inflater.inflate(R.layout.fragment_servicios, container, false);

        drawable = getResources().getDrawable(R.drawable.alpastor);
        servimage2=(ImageView) v.findViewById(R.id.servimage2);
        servimage2.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.burrito1);
        servimage3=(ImageView) v.findViewById(R.id.servimage3);
        servimage3.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.tacomolida);
        servimage4=(ImageView) v.findViewById(R.id.servimage4);
        servimage4.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.enchilada1);
        servimage6=(ImageView) v.findViewById(R.id.servimage6);
        servimage6.setImageDrawable(drawable);


        drawable = getResources().getDrawable(R.drawable.guacamole);
        servimageB= (ImageButton) v.findViewById(R.id.servimageB);
        servimageB.setImageDrawable(drawable);



        return v;
    }


}