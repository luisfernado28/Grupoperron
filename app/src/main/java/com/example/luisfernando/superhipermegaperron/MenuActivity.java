package com.example.luisfernando.superhipermegaperron;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Activity activity;
    private ImageButton TV_BUTTON;
    private ImageButton PHONES_BUTTON;
    private ImageButton GAMES_BUTTON;
    private ImageButton HHITEMS_BUTTON;
    private ImageButton PC_BUTTON;
    private ImageButton LOG_OUT_BUTTON;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toast welcome = Toast.makeText(getApplicationContext(),"welcome", Toast.LENGTH_SHORT );
        welcome.show();


        TV_BUTTON = (ImageButton)findViewById(R.id.TV_BUTTON);
        PHONES_BUTTON = (ImageButton)findViewById(R.id.PHONES_BUTTON);
        GAMES_BUTTON = (ImageButton)findViewById(R.id.GAMES_BUTTON);
        HHITEMS_BUTTON = (ImageButton)findViewById(R.id.HHITEMS_BUTTON);
        PC_BUTTON = (ImageButton)findViewById(R.id.PC_BUTTON);
        LOG_OUT_BUTTON = (ImageButton)findViewById(R.id.LOG_OUT_BUTTON);
        context=this;


        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

        PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

        Notification notification = new NotificationCompat.Builder(MenuActivity.this)
                .setContentTitle("BIENVENIDO")
                .setContentText("OYE VOLVÉ")
                .setSmallIcon(R.drawable.notification)
                .setContentIntent(pIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);


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
    public void onClick(View v) {

    }
}
