package com.example.luisfernando.superhipermegaperron;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class JuegosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);
        ListView lista=(ListView)findViewById(R.id.listview);

        ArrayList<Item> items=new ArrayList<Item>();
        items.add(new Item(1, "Sony PlayStation 4 500GB", " 267.90 $us", R.drawable.ps4));
        items.add(new Item(1, "Sony PlayStation 4 Pro 1TB", " 439.99 $us", R.drawable.ps4pro));
        items.add(new Item(1, "Overwatch - Origins Edition - PlayStation 4", "49.99  $us", R.drawable.overwatch));
        items.add(new Item(1,"Microsoft Xbox One 500 GB"," 239.00 $us", R.drawable.xboxone));
        items.add(new Item(1, "Xbox One S 500GB", "257.47  $us", R.drawable.xboxones));
        items.add(new Item(1, "Halo 5: Guardians", "22.25 $us", R.drawable.halo5));



        AdaptadorItem adaptador=new AdaptadorItem(JuegosActivity.this, items);

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
