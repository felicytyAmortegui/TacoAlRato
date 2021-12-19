package com.example.proycdraw.ui.users;

import static android.widget.Toast.makeText;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proycdraw.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class OnUserFragment extends Fragment {



    private View v;
    private Button botonGET;
    private TextView mostrarJSON;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout. fragment_on_user, container,false);
        try{

            botonGET = (Button) v.findViewById(R.id.botonGET);
            mostrarJSON = (TextView) v.findViewById(R.id.mostrarJSON);

            botonGET.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lladoGET();
                }
            });

        }catch (Exception e){
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

        return v;
    }

    private void lladoGET() {
        String url = "https://g8df87ef56c819f-dbgofood.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/bdproductos/PRODUCTS";


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        mostrarJSON.setText(jsonObject.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);

    }

}