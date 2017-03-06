package com.example.luisfernando.superhipermegaperron;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText txtPassword;
    private Button btnEnviar;
    private Button btnLimpiar;
    private Button btnRegistarse;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

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
                String campo_usuario = txtUsuario.getText().toString();
                String campo_password = txtPassword.getText().toString();

                if (campo_usuario.compareTo("hola") == 0 && campo_password.compareTo("papu") == 0)
                {
                    Intent a=new Intent(context,MenuPrincipal.class);
                    String[] info=new String[2];
                    info[0]=txtUsuario.getText().toString();
                    info[1]=txtPassword.getText().toString();
                    a.putExtra("datos_usuario", info);
                    startActivity(a);

                }


            }
        });
    }
}
