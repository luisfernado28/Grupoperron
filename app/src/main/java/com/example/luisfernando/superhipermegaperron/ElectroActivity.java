package com.example.luisfernando.superhipermegaperron;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ElectroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electro);

        ListView lista=(ListView)findViewById(R.id.listview);

        ArrayList<Item> items=new ArrayList<Item>();
        items.add(new Item(1, "Lavadora de carga frontal Samsung AddWash Ecobubble",
                " 615,25 $us", R.drawable.lavadora));
        items.add(new Item(1, "Frigorífico combi Samsung RB37J5000SA/EF No Frost", " 700 $us", R.drawable.frigorifico));
        items.add(new Item(1, "Conjunto de Horno multifunción + Placa de inducción Beko BSE22341X",
                "574 $us", R.drawable.horno));
        items.add(new Item(1,"Aspirador Nilfisk Select Comfort Allergy con filtro H 14"," 700 $us", R.drawable.aspiradora2));
        items.add(new Item(1, "Robot aspirador iRobot Roomba 886", "800  $us", R.drawable.aspiradora));
        items.add(new Item(1, "Cafetera espresso manual Philips-Saeco Focus", " 85 $us", R.drawable.cafetera));
        items.add(new Item(1, "Microondas Saivod MS2814W con capacidad de 20 litros", " 60 $us", R.drawable.microondas));


        AdaptadorItem adaptador=new AdaptadorItem(ElectroActivity.this, items);

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
