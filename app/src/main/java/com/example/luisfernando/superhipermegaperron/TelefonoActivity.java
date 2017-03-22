package com.example.luisfernando.superhipermegaperron;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TelefonoActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefono);
        ListView lista=(ListView)findViewById(R.id.listview);
        context=this;

        final ArrayList<Item> items=new ArrayList<Item>();
        items.add(new Item(1, "Samsung Galaxy S7 32GB "," 462.49 $us", R.drawable.galaxys7));
        items.add(new Item(1, "Samsung Galaxy S5  16GB  ", " 154.00$us", R.drawable.galaxys5));
        items.add(new Item(1, "Samsung J3  16GB ","140 $us", R.drawable.galaxyj3));
        items.add(new Item(1,"Samsung Galaxy Tab A 16GB "," 299.99 $us", R.drawable.galaxytaba));
        items.add(new Item(1, "Samsung Gear S3 Frontier", "335.23  $us", R.drawable.samsungears3));
        items.add(new Item(1, "Samsung Galaxy J5", " 164.99 $us", R.drawable.galaxyj5));

        AdaptadorItem adaptador=new AdaptadorItem(TelefonoActivity.this, items);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> array, View vista, int posicion,long id) {

                TextView titulo=(TextView)vista.findViewById(R.id.titulo);
                Log.e("Item seleccionado", titulo.getText().toString());

                Intent product = new Intent(context,Product_Activity.class);
                product.putExtra("imagen", items.get(posicion).getImagen());
                product.putExtra("desc", items.get(posicion).getDescripcion());
                product.putExtra("precio", items.get(posicion).getPrecio());
                startActivity(product);
            }
        });
    }
}
