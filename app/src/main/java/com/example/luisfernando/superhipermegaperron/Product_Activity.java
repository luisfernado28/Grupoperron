package com.example.luisfernando.superhipermegaperron;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Luis Fernando on 19/03/2017.
 */

public class Product_Activity extends AppCompatActivity {

    private ImageView foto;
    private TextView descrip;
    private TextView precio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        Intent intent = getIntent();

        int ap= intent.getIntExtra("imagen",R.drawable.aspiradora);

        foto = (ImageView) findViewById(R.id.foto_decs);
        foto.setImageDrawable(ContextCompat.getDrawable(this, ap));

        String descpripcion = intent.getStringExtra("desc");

        descrip=(TextView)findViewById(R.id.descrip);
        precio=(TextView)findViewById(R.id.precio);

        precio.setText(descpripcion);

        String preciot = intent.getStringExtra("precio");

        descrip.setText(preciot);
    }
}
