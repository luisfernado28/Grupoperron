package com.example.luisfernando.superhipermegaperron;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Luis Fernando on 19/03/2017.
 */

public class Product_Activity extends AppCompatActivity {

    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        Intent intent = getIntent();

        int ap= intent.getIntExtra("imagen",R.drawable.aspiradora);

        foto = (ImageView) findViewById(R.id.foto_decs);
        foto.setImageDrawable(getDrawable(ap));



        String descpripcion = intent.getStringExtra("desc");
        String precio = intent.getStringExtra("precio");
    }
}
