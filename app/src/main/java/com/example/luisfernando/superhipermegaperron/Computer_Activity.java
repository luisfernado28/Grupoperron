package com.example.luisfernando.superhipermegaperron;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by andres on 10/3/2017.
 */

public class Computer_Activity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        ListView lista=(ListView)findViewById(R.id.listview1);

        ArrayList<Item> items=new ArrayList<Item>();
        items.add(new Item(1, "Apple iMac 1TB PCIe", " 2999.90 $us", R.drawable.mac));
        items.add(new Item(1, "Custom PC i7 7700k, 64GB DDR4 RAM", " 1139.99 $us", R.drawable.pc1));
        items.add(new Item(1, "Asus maximus Z270 Motherboard", "199.99  $us", R.drawable.asus));
        items.add(new Item(1,"32GB RAM Corsair Dominator Platinum DDR4"," 139.00 $us", R.drawable.ddr4));
        items.add(new Item(1, "AMD Ryzen7 1800X", "499.99  $us", R.drawable.ryzen));

        items.add(new Item(1, "Lenovo thinkpad X1", "522.99 $us", R.drawable.lenovo));



        AdaptadorItem adaptador=new AdaptadorItem(Computer_Activity.this, items);

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
