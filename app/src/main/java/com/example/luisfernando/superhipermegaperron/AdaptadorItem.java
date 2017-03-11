package com.example.luisfernando.superhipermegaperron;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Luis Fernando on 10/03/2017.
 */

public class AdaptadorItem extends BaseAdapter{
    protected Activity activity;
    protected ArrayList<Item> items;

    public AdaptadorItem(Activity activity, ArrayList<Item> items)
    {
        this.activity=activity;
        this.items=items;
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int posicion) {
        return items.get(posicion);
    }

    public long getItemId(int posicion) {
        return items.get(posicion).getId();
    }

    static class ViewHolder{
        TextView titulo;
        TextView descripcion;
        ImageView imagen;
    }

    public View getView(int posicion, View vista, ViewGroup vista_grupal) {
        ViewHolder holder;
        if (vista == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.vistaitem, null);

            holder.titulo = (TextView) vista.findViewById(R.id.titulo);
            holder.descripcion = (TextView) vista.findViewById(R.id.descripcion);
            holder.imagen = (ImageView) vista.findViewById(R.id.imagen);

            vista.setTag(holder);
        } else {
            holder = (ViewHolder) vista.getTag();
        }

        Item item = items.get(posicion);
        holder.titulo.setText(item.getPrecio());
        holder.descripcion.setText(item.getDescripcion());
        holder.imagen.setImageResource(item.getImagen());

        return vista;
    }
}
