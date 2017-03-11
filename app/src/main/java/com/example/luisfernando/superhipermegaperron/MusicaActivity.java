package com.example.luisfernando.superhipermegaperron;

import android.content.ClipData;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicaActivity extends AppCompatActivity {

    private String[] arraySpinner;
    private CoordinatorLayout coordinador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        coordinador=(CoordinatorLayout)findViewById(R.id.activity_musica);
        Snackbar snackbar = Snackbar.make(coordinador, "Funciona!", Snackbar.LENGTH_LONG)
                .setAction("No funciona", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "Claro que funciona!",
                                Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                });

        snackbar.setActionTextColor(Color.RED);
        snackbar.show();

        arraySpinner = new String[] {
                "Apple", "Nokia", "LG", "Samsung", "Huawei"
        };
        Spinner spinner = (Spinner)findViewById(R.id.spinner1);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> array, View vista,
                                       int posicion, long id) {
                Log.e("Item seleccionado", (String) array.getItemAtPosition(posicion));
            }

            public void onNothingSelected(AdapterView<?> array) {
            }
        });
       ListView lista=(ListView)findViewById(R.id.listProductos);


        lista.refreshDrawableState();
/*
       ArrayList<Item> items=new ArrayList<Item>();
       items.add(new Item(1, "Icono", "Esta es la descripcion del icono",android.R.drawable.ic_menu_camera ));
       items.add(new Item(1, "Play", "Esta es la descripcion de Play", android.R.drawable.ic_media_play));

       AdaptadorItem adaptador=new AdaptadorItem(MusicaActivity.this, items);

        lista.setAdapter(adaptador);*/

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> array, View vista, int posicion,
                                    long id) {
                TextView titulo=(TextView)vista.findViewById(R.id.titulo);
                Log.e("Item seleccionado", titulo.getText().toString());
            }
        });



        arraySpinner=getResources().getStringArray(R.array.array_prods);
        ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        lista.setAdapter(adaptador1);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {
                    TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                    String contenido = texto.getText().toString();
                    Log.e("Item seleccionado", contenido);

            }
        });
    }
}
