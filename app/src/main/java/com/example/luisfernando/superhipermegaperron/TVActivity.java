package com.example.luisfernando.superhipermegaperron;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TVActivity extends AppCompatActivity {


    private Context context;
    private EditText searchTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);

        context=this;
        final Intent intent = getIntent();


        ListView lista=(ListView)findViewById(R.id.listview);


        final ArrayList<Item> items=new ArrayList<>();
        items.add(new Item(1, "Samsung Curva 48 plg Ultra HD Smart Led TV", " 2241,35 $us", R.drawable.img1));
        items.add(new Item(2, "Samsung 65 plg Full HD Smart Led HDTV", " 1493,85 $us", R.drawable.img2));
        items.add(new Item(3, "Samsung 55 plg 4k Ultra HD Smart Led TV", "916,55 $us", R.drawable.img3));
        items.add(new Item(1, "Samsung 54'6 plg HD Smart Led TV", "442,46  $us", R.drawable.img4));
        items.add(new Item(1, "Samsung 43 plg HD Smart Led TV", " 333,33 $us", R.drawable.img5));
        items.add(new Item(1, "Samsung 40 plg HD Led TV", " 315,12 $us", R.drawable.img6));


        final AdaptadorItem adaptador=new AdaptadorItem(TVActivity.this, items);


        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> array, View vista, int posicion,
                                    long id) {
                TextView titulo=(TextView)vista.findViewById(R.id.titulo);
                Log.e("Item seleccionado", titulo.getText().toString());

                Intent prod = new Intent(context,Product_Activity.class);
                prod.putExtra("imagen", items.get(posicion).getImagen());
                prod.putExtra("desc", items.get(posicion).getDescripcion());
                prod.putExtra("precio", items.get(posicion).getPrecio());
                prod.putExtra("activeUser", intent.getStringExtra("activeUser"));

                startActivity(prod);


            }
        });

        searchTxt = (EditText) findViewById(R.id.searchTxt);
        //Agrego el filtro
        searchTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Aplico el filtro
                adaptador.getFilter().filter(s.toString());
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
}
