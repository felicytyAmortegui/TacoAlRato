package com.example.proycdraw.ui.domicilios;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.proycdraw.R;


public class DeliveryFragment extends Fragment {
 private View v;
 private Drawable drawable;


private ImageView imagdel1, imagdel2, imagdel3, imagdel4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v = inflater.inflate(R.layout.fragment_delivery, container, false);

        drawable = getResources().getDrawable(R.drawable.mexicana1628);
        imagdel1=(ImageView) v.findViewById(R.id.mexicana);
        imagdel1.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.chilecool1);
        imagdel2=(ImageView) v.findViewById(R.id.chilecool);
        imagdel2.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.sombrero1);
        imagdel3=(ImageView) v.findViewById(R.id.sombrero1);
        imagdel3.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.tacofiesta1);
        imagdel4=(ImageView) v.findViewById(R.id.tacofiesta1);
        imagdel4.setImageDrawable(drawable);

        return v;
    }
}