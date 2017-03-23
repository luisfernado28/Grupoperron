package com.example.luisfernando.superhipermegaperron;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class BaseDatosWish extends SQLiteOpenHelper{

    private String userName;

    public static final String DB_NAME = "wish_database.db";

    //Versión de la base de datos
    public BaseDatosWish(Context context, int VERSION, String user){
        super(context, DB_NAME, null, VERSION);
        this.userName = user;
        Log.e("DB","Constructor wishlist");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE wish" + userName + " (id integer primary key autoincrement not null, price varchar, image integer, desc varchar);");
        Log.e("DB","Create, local wishlist");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
