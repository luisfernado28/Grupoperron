package com.example.luisfernando.superhipermegaperron;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class Computer_Activity extends AppCompatActivity{

    private Context context;
    private EditText searchTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        ListView lista=(ListView)findViewById(R.id.listview);
        final Intent intent = getIntent();


        context=this;

        final ArrayList<Item> items=new ArrayList<Item>();
        items.add(new Item(1, "Apple iMac 1TB PCIe", " 2999.90 $us", R.drawable.mac));
        items.add(new Item(1, "Custom PC i7 7700k, 64GB DDR4 RAM", " 1139.99 $us", R.drawable.pc1));
        items.add(new Item(1, "Asus maximus Z270 Motherboard", "199.99  $us", R.drawable.asus));
        items.add(new Item(1,"32GB RAM Corsair Dominator Platinum DDR4"," 139.00 $us", R.drawable.ddr4));
        items.add(new Item(1, "AMD Ryzen7 1800X", "499.99  $us", R.drawable.ryzen));
        items.add(new Item(1, "Lenovo thinkpad X1", "522.99 $us", R.drawable.lenovo));

        final AdaptadorItem adaptador=new AdaptadorItem(Computer_Activity.this, items);

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
