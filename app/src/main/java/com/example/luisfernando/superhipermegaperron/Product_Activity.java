package com.example.luisfernando.superhipermegaperron;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Luis Fernando on 19/03/2017.
 */

public class Product_Activity extends AppCompatActivity {

    private ImageView foto;
    private TextView descrip;
    private TextView precio;
    private Button wish;
    private String activeUser;
    private BaseDatosWish baseDatos;
    private SQLiteDatabase db;
    public static final int VERSION = 1;
    Context context;
    private String descpripcion;
    private String preciot;
    private int ap;
    private ContentValues values;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        Intent intent = getIntent();
        activeUser = intent.getStringExtra("activeUser");
        context = this;


        baseDatos = new BaseDatosWish(context, VERSION, activeUser);
        db = baseDatos.getWritableDatabase();
        values = new ContentValues();

        ap= intent.getIntExtra("imagen",R.drawable.aspiradora);

        foto = (ImageView) findViewById(R.id.foto_decs);
        foto.setImageDrawable(ContextCompat.getDrawable(this, ap));

        descpripcion = intent.getStringExtra("desc");

        descrip=(TextView)findViewById(R.id.descrip);
        precio=(TextView)findViewById(R.id.precio);
        wish=(Button)findViewById(R.id.btnadd);

        precio.setText(descpripcion);

        preciot = intent.getStringExtra("precio");

        descrip.setText(preciot);

        wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.put("price", preciot);
                values.put("image", ap);
                values.put("desc", descpripcion);
                db.insert("wish" + activeUser, null, values);


                Intent wish = new Intent(context, Wish_List.class);
                wish.putExtra("activeUser", activeUser);
                startActivity(wish);
            }
        });
    }
}
