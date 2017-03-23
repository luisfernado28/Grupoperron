package com.example.luisfernando.superhipermegaperron;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class MenuActivity extends AppCompatActivity{

    private Context context;
    private Activity activity;
    private Button TV_BUTTON;
    private Button PHONES_BUTTON;
    private Button GAMES_BUTTON;
    private Button HHITEMS_BUTTON;
    private Button PC_BUTTON;
    private Button LOG_OUT_BUTTON;
    private NotificationManager notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TV_BUTTON = (Button)findViewById(R.id.TV_BUTTON);
        PHONES_BUTTON = (Button)findViewById(R.id.PHONES_BUTTON);
        GAMES_BUTTON = (Button)findViewById(R.id.GAMES_BUTTON);
        HHITEMS_BUTTON = (Button)findViewById(R.id.HHITEMS_BUTTON);
        PC_BUTTON = (Button)findViewById(R.id.PC_BUTTON);
        LOG_OUT_BUTTON = (Button)findViewById(R.id.LOG_OUT_BUTTON);

        context=this;

        Intent logIn = getIntent();
        String activeUser[] = new String[2];
        activeUser = logIn.getStringArrayExtra("activeUser");
        if(activeUser[0].equals("hola")){
            Toast.makeText(getApplicationContext(),"Welcome developer", Toast.LENGTH_SHORT ).show();
        }else{
            Toast.makeText(getApplicationContext(),"Welcome " + activeUser[0], Toast.LENGTH_SHORT ).show();
        }

        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        PendingIntent pIntent = null;
        try{
            pIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
        }catch (Exception e){

        }/*
        final Notification notification = new NotificationCompat.Builder(MenuActivity.this)
                .setContentTitle("Eloy, ahora!")
                .setContentText("Bienvenido")
                .setSmallIcon(R.drawable.notification)
                .setContentIntent(pIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .build();*/
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //notificationManager.notify(0, notification);


        TV_BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TV = new Intent(context,TVActivity.class);
                startActivity(TV);
            }
        });
        PHONES_BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phone = new Intent(context,TelefonoActivity.class);
                startActivity(phone);
            }
        });
        GAMES_BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(context,JuegosActivity.class);
                startActivity(game);
            }
        });
        HHITEMS_BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent electro = new Intent(context,ElectroActivity.class);
                startActivity(electro);
            }
        });
        PC_BUTTON.setOnClickListener(new View.OnClickListener() {
                    /*@Override
                    public void onClick(View view) {
                        Snackbar snackbar = Snackbar
                                .make(coordinador, "Funciona!", Snackbar.LENGTH_LONG)
                                .setAction("No funciona", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                                "Claro que funciona!",
                                                Toast.LENGTH_SHORT);
                                        toast1.show();
                                    }
                                });

                        snackbar.setActionTextColor(Color.RED);
                        snackbar.show();
                    }*/
                    @Override
                    public void onClick(View v) {
                        Intent musica = new Intent(context,Computer_Activity.class);
                        startActivity(musica);
                    }
        });


        LOG_OUT_BUTTON.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v)
                    {

                        AlertDialog.Builder Dialogo = new AlertDialog.Builder(
                                MenuActivity.this);

                        Dialogo.setTitle("Esta seguro que desea salir?");
                        Dialogo.setMessage("La sesion se cerrara");
                        Dialogo.setIcon(android.R.drawable.sym_def_app_icon);

                        Dialogo.setPositiveButton("Si",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        try {
                                            OutputStreamWriter fout =
                                                    new OutputStreamWriter(
                                                            openFileOutput("login.panqueque", Context.MODE_PRIVATE));
                                            fout.write("");
                                            fout.close();
                                        }catch(Exception e){

                                        }
                                        Intent logOut = new Intent(context,MainActivity.class);
                                        notificationManager.cancelAll();
                                        SharedPreferences prefs =
                                                getSharedPreferences("ActiveUser", Context.MODE_PRIVATE);
                                        String[] activeUser = {"",""};
                                        SharedPreferences.Editor editor = prefs.edit();
                                        editor.putString("User", activeUser[0]);
                                        editor.putString("Password", activeUser[1]);
                                        editor.commit();
                                        startActivity(logOut);
                                        finish();
                                    }
                                });

                        Dialogo.setNegativeButton("No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getApplicationContext(), ":(", Toast.LENGTH_SHORT).show();
                                        dialog.cancel();
                                    }
                                });
                        Dialogo.show();

                    }
                });

    }
    @Override
    public void onDestroy(){
        notificationManager.cancelAll();
        super.onDestroy();
    }
}
