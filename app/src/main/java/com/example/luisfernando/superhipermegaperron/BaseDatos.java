package com.example.luisfernando.superhipermegaperron;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by andres on 10/3/2017.
 */

public class BaseDatos extends SQLiteOpenHelper{
    public static final String DB_NAME = "user_database.db";

    //Versión de la base de datos
    public BaseDatos(Context context, int VERSION){
        super(context, DB_NAME, null, VERSION);
        Log.e("DB","Constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (id integer primary key autoincrement not null, user varchar, name double, password varchar, email varchar);");
        Log.e("DB","Create");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
