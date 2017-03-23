package com.example.luisfernando.superhipermegaperron;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Wish_List extends AppCompatActivity {
    private Context context;
    private BaseDatosWish baseDatos;
    private SQLiteDatabase db;
    public static final int VERSION = 1;
    private String activeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish__list);
        context=this;

        final ListView lista=(ListView)findViewById(R.id.listviewwish);
        final ArrayList<Item> items=new ArrayList<Item>();
        final Intent intent = getIntent();
        activeUser = intent.getStringExtra("activeUser");
        baseDatos = new BaseDatosWish(context, VERSION, activeUser);
        db = baseDatos.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM wish" + activeUser, null);
        if (cursor.moveToFirst()) {


            while (cursor.isAfterLast() == false){
                items.add(new Item(cursor.getInt(0), cursor.getString(3),
                        cursor.getString(1), cursor.getInt(2)));
                cursor.moveToNext();

            }

        }

        final AdaptadorItem adaptador=new AdaptadorItem(Wish_List.this, items);
        lista.setAdapter(adaptador);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> array, View vista, final int posicion,
                                    final long id) {

                Log.e("Item seleccionado"," "+ posicion);

                AlertDialog.Builder Dialogo = new AlertDialog.Builder(
                        Wish_List.this);

                Dialogo.setTitle("Esta seguro de eliminar este objeto de sulista de articulos?");
                Dialogo.setMessage("Sera permanente");
                Dialogo.setIcon(android.R.drawable.sym_def_app_icon);
                Dialogo.setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                db = baseDatos.getWritableDatabase();
                                db.delete("wish"+activeUser, "id="+id,null);
                                Log.e("la cosa del id", ""+posicion);
                                adaptador.notifyDataSetChanged();
                                recreate();

                            }
                        });

                Dialogo.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Bien echo hijo", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });
                Dialogo.show();
            }
        });

    }
}
