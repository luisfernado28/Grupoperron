package com.example.luisfernando.superhipermegaperron;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        TV_BUTTON = (ImageButton)findViewById(R.id.TV_BUTTON);
        PHONES_BUTTON = (ImageButton)findViewById(R.id.PHONES_BUTTON);
        GAMES_BUTTON = (ImageButton)findViewById(R.id.GAMES_BUTTON);
        HHITEMS_BUTTON = (ImageButton)findViewById(R.id.HHITEMS_BUTTON);
        MUSIC_BUTTON = (ImageButton)findViewById(R.id.MUSIC_BUTTON);
        LOG_OUT_BUTTON = (ImageButton)findViewById(R.id.LOG_OUT_BUTTON);

        TV_BUTTON.setOnClickListener(this);
        PHONES_BUTTON.setOnClickListener(this);
        GAMES_BUTTON.setOnClickListener(this);
        HHITEMS_BUTTON.setOnClickListener(this);
        MUSIC_BUTTON.setOnClickListener(this);
        LOG_OUT_BUTTON.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
