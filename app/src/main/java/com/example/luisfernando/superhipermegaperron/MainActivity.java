package com.example.luisfernando.superhipermegaperron;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText txtPassword;
    private Button btnEnviar;
    private Button btnLimpiar;
    private Button btnRegistarse;
    private SQLiteDatabase db;
    public static final int VERSION = 1;
    private User user;


    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        context=this;

        BaseDatos crearBD = new BaseDatos(context,VERSION);
        db = crearBD.getWritableDatabase();

        ContentValues values = new ContentValues();


        try{
            BufferedReader archivo = new BufferedReader(new InputStreamReader(
                    openFileInput("login.panqueque")));
            String string = archivo.readLine();
            archivo.close();
            if(string.equals("true")){
                Intent menu=new Intent(context,MenuActivity.class);
                startActivity(menu);
                finish();
            }
        }catch(Exception e){

        }

        txtUsuario=(EditText)findViewById(R.id.txtUsuario);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        btnEnviar=(Button)findViewById(R.id.btnEnviar);
        btnLimpiar=(Button)findViewById(R.id.btnlimpiar);
        btnRegistarse=(Button)findViewById(R.id.btnRegistrarse);



        btnRegistarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(context,Registrarse.class);
                startActivity(a);
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name= txtUsuario.getText().toString();
                String password= txtPassword.getText().toString();


                if (name.compareTo("hola") == 0 && password.compareTo("papu") == 0) {
                    try {
                        OutputStreamWriter fout =
                                new OutputStreamWriter(
                                        openFileOutput("login.panqueque", Context.MODE_PRIVATE));
                        fout.write("true");
                        fout.close();
                    }catch(Exception e){

                    }
                    Intent menu=new Intent(context,MenuActivity.class);
                    String[] info=new String[2];
                    info[0]=txtUsuario.getText().toString();
                    info[1]=txtPassword.getText().toString();
                    menu.putExtra("datos_usuario", info);
                    startActivity(menu);
                    finish();
                }

            }
        });



    }
}
