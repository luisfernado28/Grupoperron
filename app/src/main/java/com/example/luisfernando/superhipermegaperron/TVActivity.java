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
        items.add(new Item(1, "Tv Sumsung 44 plg", "UHD ", R.drawable.tv1));
        items.add(new Item(1, "Play", "Esta es la descripcion de Play", android.R.drawable.ic_media_play));
        items.add(new Item(1, "Galeria", "Esta es la descripcion de Galeria", android.R.drawable.ic_menu_gallery));
        items.add(new Item(1, "Nuevo", "Esta es la descripcion de Nuevo", android.R.drawable.ic_menu_more));
        items.add(new Item(1, "poi", "asdfasdfasdfaso", android.R.drawable.ic_delete)) ;
        items.add(new Item(1, "Icono", "Esta es la descripcion del icono", android.R.drawable.ic_menu_camera));
        items.add(new Item(1, "Play", "Esta es la descripcion de Play", android.R.drawable.ic_media_play));
        items.add(new Item(1, "Galeria", "Esta es la descripcion de Galeria", android.R.drawable.ic_menu_gallery));
        items.add(new Item(1, "Tv Sumsung 44 plg", "UHD ", R.drawable.tv1));
        items.add(new Item(1, "Play", "Esta es la descripcion de Play", android.R.drawable.ic_media_play));
        items.add(new Item(1, "Galeria", "Esta es la descripcion de Galeria", android.R.drawable.ic_menu_gallery));
        items.add(new Item(1, "Nuevo", "Esta es la descripcion de Nuevo", android.R.drawable.ic_menu_more));


        //Instanciamos el adaptador
        AdaptadorItem adaptador=new AdaptadorItem(TVActivity.this, items);
        //Utilizamos el adaptador
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
