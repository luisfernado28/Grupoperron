package com.example.luisfernando.superhipermegaperron;

/**
 * Created by andres on 10/3/2017.
 */
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FilaClass_Activity extends AppCompatActivity{


    private String[] arraySpinner1;
    private String[] arraySpinner2;
    private CoordinatorLayout coordinador;
    private int spinnerPos = 1;
    private ArrayAdapter<String> adaptador1;
    private ArrayAdapter<String> adaptador2;

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
        arraySpinner1 = new String[] {"ALL" };
        arraySpinner2 = getResources().getStringArray(R.array.array_prods);
        //SPINNER
        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        adaptador2 = new ArrayAdapter<>(this,
                R.layout.spinner_item, arraySpinner1);
        spinner.setAdapter(adaptador2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> array, View vista,
                                       int pos, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> array) {

            }
        });

        //LIST VIEW
        ListView lista=(ListView)findViewById(R.id.listProductos);
        adaptador1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraySpinner2);
        lista.setAdapter(adaptador1);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> array, View vista, int position, long id) {
                TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                String contenido = texto.getText().toString();
                Log.e("Item seleccionado", contenido);
            }
        });


        //ITEM LISTA Y ADAPTADOR
       /*ArrayList<Item> items=new ArrayList<Item>();
       items.add(new Item(1, "Icono", "Esta es la descripcion del icono",android.R.drawable.ic_menu_camera ));
       items.add(new Item(1, "Play", "Esta es la descripcion de Play", android.R.drawable.ic_media_play));

       AdaptadorItem adaptador=new AdaptadorItem(MusicaActivity.this, items);

        lista.setAdapter(adaptador);

*/
    }
    public void refreshListView(){

    }
}
