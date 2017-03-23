package com.example.luisfernando.superhipermegaperron;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

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
    private String activeUser[] = new String[2];
    private Button btnAbout;
    private FirebaseAuth firebaseAuth;
    private BaseDatos baseDatos;

    public static final int RC_SIGN_IN = 100;


    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;

        //Se instancia la base de Datos
        baseDatos = new BaseDatos(context,VERSION);
        db = baseDatos.getWritableDatabase();
        ContentValues values = new ContentValues();

        //Se verifica el one time LOGIN
        /*firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null)
        {
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
            iniciarAcciones();
        } else {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setLogo(R.drawable.icon)
                            .setProviders(
                                    AuthUI.FACEBOOK_PROVIDER,
                                    AuthUI.GOOGLE_PROVIDER,
                                    AuthUI.EMAIL_PROVIDER)
                            .setTheme(R.style.tema)
                            .build(), RC_SIGN_IN);
        }*/

        SharedPreferences prefs =
                getSharedPreferences("ActiveUser", Context.MODE_PRIVATE);
        activeUser[0] = prefs.getString("User", "");
        activeUser[1] = prefs.getString("Password", "");
        if(!(activeUser[0].equals("") && activeUser[1].equals(""))){
            callIntent();
        }
        /*En caso de un nuevo registro se reciben los datos del nuevo usuario y se guarda en la
        base de datos*/
        try{
            Intent intent = getIntent();
            String userString = intent.getStringExtra("user");
            boolean ver = intent.getBooleanExtra("ver", false);
            if(ver){
                Log.e("intent", "working");
                Gson gson = new Gson();
                user = gson.fromJson(userString, User.class);
                values.put("user",user.getUSER_NAME());
                values.put("name",user.getNAME());
                values.put("password",user.getPASSWORD());
                values.put("email",user.getE_MAIL());
                db.insert("users", null, values);
                db.close();
            }
        }catch(Exception e){

        }

        //Se asignan los views
        txtUsuario=(EditText)findViewById(R.id.txtUsuario);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        btnEnviar=(Button)findViewById(R.id.btnEnviar);
        btnLimpiar=(Button)findViewById(R.id.btnlimpiar);
        btnRegistarse=(Button)findViewById(R.id.btnRegistrarse);
        btnAbout=(Button)findViewById(R.id.btnAbout);

        //Función botón registrarse
        btnRegistarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(context,Registrarse.class);
                startActivity(a);
                finish();
            }
        });

        //Funcion about
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(context,AboutActivity.class);
                startActivity(a);
                finish();
            }
        });


        //Función botón Enviar y verificación
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name= txtUsuario.getText().toString();
                String pass= txtPassword.getText().toString();
                //Palabras clave
                if (name.compareTo("hola") == 0 && pass.compareTo("papu") == 0) {
                    oneTimeLogIn(name, pass);
                    callIntent();
                }else{
                    db = baseDatos.getReadableDatabase();

                    //Querry para SQL
                    Cursor users_existing=db.rawQuery("SELECT password FROM users WHERE user =" + " '"+
                            txtUsuario.getText().toString()+ "'", null);

                    //Verificación real en la base de datos
                    if(users_existing.moveToFirst()) {
                        if(users_existing.getString(0).equals(pass)){
                            users_existing.close();
                            oneTimeLogIn(name, pass);
                            callIntent();
                        }else{
                            Toast.makeText(context,"Usuario o contraseña incorrectos.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(context,"Usuario o contraseña incorrectos.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //Función botón Limpiar
        btnLimpiar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUsuario.setText("");
                txtPassword.setText("");
            }
        }));


    }


    //FACTORIZACIÓN DE CÓDIGO
    public void oneTimeLogIn(String name, String pass){
        //Se crea o modifica el archivo de Preferencias
        SharedPreferences prefs =
                getSharedPreferences("ActiveUser", Context.MODE_PRIVATE);
        this.activeUser[0] = name;
        this.activeUser[1] = pass;
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("User", activeUser[0]);
        editor.putString("Password", activeUser[1]);
        editor.commit();
    }
    public void callIntent(){
        //Llama al Intent del menú principal
        Intent menu = new Intent(context,MenuActivity.class);
        menu.putExtra("activeUser", this.activeUser);
        startActivity(menu);
        finish();
    }

}
