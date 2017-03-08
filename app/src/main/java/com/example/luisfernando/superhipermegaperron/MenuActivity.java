package com.example.luisfernando.superhipermegaperron;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Activity activity;
    private ImageButton TV_BUTTON;
    private ImageButton PHONES_BUTTON;
    private ImageButton GAMES_BUTTON;
    private ImageButton HHITEMS_BUTTON;
    private ImageButton MUSIC_BUTTON;
    private ImageButton LOG_OUT_BUTTON;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast welcome = Toast.makeText(getApplicationContext(),"welcome", Toast.LENGTH_SHORT );
        welcome.show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        context=this;
        TV_BUTTON = (ImageButton)findViewById(R.id.TV_BUTTON);
        PHONES_BUTTON = (ImageButton)findViewById(R.id.PHONES_BUTTON);
        GAMES_BUTTON = (ImageButton)findViewById(R.id.GAMES_BUTTON);
        HHITEMS_BUTTON = (ImageButton)findViewById(R.id.HHITEMS_BUTTON);
        MUSIC_BUTTON = (ImageButton)findViewById(R.id.MUSIC_BUTTON);
        LOG_OUT_BUTTON = (ImageButton)findViewById(R.id.LOG_OUT_BUTTON);

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
        MUSIC_BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent music = new Intent(context,MusicaActivity.class);
                startActivity(music);
            }
        });
        LOG_OUT_BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logOut = new Intent(context,MainActivity.class);
                startActivity(logOut);
            }
        });
    }


    @Override
    public void onClick(View v) {

    }
}
