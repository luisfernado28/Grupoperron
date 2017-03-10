package com.example.luisfernando.superhipermegaperron;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MusicaActivity extends AppCompatActivity {

    private String[] arraySpinner;
    private CoordinatorLayout coordinador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        coordinador=(CoordinatorLayout)findViewById(R.id.activity_musica);
        Snackbar snackbar = Snackbar.make(coordinador, "Funciona!", Snackbar.LENGTH_LONG)
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

        arraySpinner = new String[] {
                "Apple", "Nokia", "LG", "Samsung", "Huawei"
        };
        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        spinner.setAdapter(adapter);
    }
}
