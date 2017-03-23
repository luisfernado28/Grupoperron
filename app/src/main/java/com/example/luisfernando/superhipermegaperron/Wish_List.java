package com.example.luisfernando.superhipermegaperron;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Wish_List extends AppCompatActivity {
    private Context context;
    private BaseDatosWish baseDatos;
    private SQLiteDatabase db;
    public static final int VERSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish__list);
        context=this;

        ListView lista=(ListView)findViewById(R.id.listviewwish);
        final ArrayList<Item> items=new ArrayList<Item>();
        Intent intent = getIntent();
        String activeUser = intent.getStringExtra("activeUser");
        baseDatos = new BaseDatosWish(context, VERSION, activeUser);
        db = baseDatos.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM wish" + activeUser, null);
        if (cursor.moveToFirst()) {
            int cont = 1;
            while (cursor.isAfterLast() == false){
                items.add(new Item(cont, cursor.getString(3),
                        cursor.getString(1), cursor.getInt(2)));
                cursor.moveToNext();
                cont++;
            }

        }

        AdaptadorItem adaptador=new AdaptadorItem(Wish_List.this, items);
        lista.setAdapter(adaptador);
    }
}
