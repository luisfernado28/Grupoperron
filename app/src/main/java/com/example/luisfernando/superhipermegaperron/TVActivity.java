package com.example.luisfernando.superhipermegaperron;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);

        ListView lista=(ListView)findViewById(R.id.listview);

        ArrayList<Item> items=new ArrayList<Item>();
        items.add(new Item(1, "Samsung Curva 48 plg Ultra HD Smart Led TV", " 2241,35 $us", R.drawable.img1));
        items.add(new Item(1, "Samsung 65 plg Full HD Smart Led HDTV", " 1493,85 $us", R.drawable.img2));
        items.add(new Item(1, "Samsung 55 plg 4k Ultra HD Smart Led TV", "916,55 $us", R.drawable.img3));
        items.add(new Item(1, "Samsung 54'6 plg HD Smart Led TV", "442,46  $us", R.drawable.img4));
        items.add(new Item(1, "Samsung 43 plg HD Smart Led TV", " 333,33 $us", R.drawable.img5));
        items.add(new Item(1, "Samsung 40 plg HD Led TV", " 315,12 $us", R.drawable.img6));


        AdaptadorItem adaptador=new AdaptadorItem(TVActivity.this, items);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> array, View vista, int posicion,
                                    long id) {
                TextView titulo=(TextView)vista.findViewById(R.id.titulo);
                Log.e("Item seleccionado", titulo.getText().toString());
            }
        });


    }
}
