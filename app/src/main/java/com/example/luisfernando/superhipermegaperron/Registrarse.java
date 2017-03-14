package com.example.luisfernando.superhipermegaperron;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class Registrarse extends AppCompatActivity {

    private EditText TXT_USER;
    private EditText TXT_NAME;
    private EditText TXT_PASSWORD;
    private EditText TXT_PASS_AGAIN;
    private EditText TXT_EMAIL;
    private Button BTN_SUBMIT;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        TXT_USER = (EditText)findViewById(R.id.txtUsuario);
        TXT_NAME = (EditText)findViewById(R.id.txtLast_name);
        TXT_PASSWORD = (EditText)findViewById(R.id.txtPassword);
        TXT_PASS_AGAIN = (EditText)findViewById(R.id.txtPassA);
        TXT_EMAIL = (EditText)findViewById(R.id.txtEmail);
        BTN_SUBMIT = (Button)findViewById(R.id.btnSubmit);

        context = this;

        BTN_SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TXT_PASSWORD.getText().toString().equals("")&&
                        !TXT_NAME.getText().toString().equals("")&&
                        !TXT_USER.getText().toString().equals("")&&
                        !TXT_EMAIL.getText().toString().equals("")){
                    if(!TXT_EMAIL.getText().toString().contains("@")&&!TXT_EMAIL.getText().toString().contains(".")){
                        Toast.makeText(context, "Enter a valid E-mail", Toast.LENGTH_LONG).show();
                    } else if(TXT_PASSWORD.getText().toString().equals(TXT_PASS_AGAIN.getText().toString())){
                        Intent intent=new Intent(context,MainActivity.class);
                        Gson gson = new Gson();
                        User user = new User(new String[]{TXT_USER.getText().toString(), TXT_NAME.getText().toString(),
                                TXT_EMAIL.getText().toString(), TXT_PASSWORD.getText().toString()});
                        String userString = gson.toJson(user);
                        intent.putExtra("user", userString);
                        intent.putExtra("ver", true);
                        startActivity(intent);
                        finish();
                    }else{
                    Toast.makeText(context, "Password texts must be equal", Toast.LENGTH_LONG).show();
                      }
                }else{
                    Toast.makeText(context, "Please fill the form", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
