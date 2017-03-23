package com.example.luisfernando.superhipermegaperron;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis Fernando on 10/03/2017.
 */

public class AdaptadorItem extends BaseAdapter implements Filterable {

    private Activity activity;
    private ArrayList<Item> items;

    //Creo un array ccon los items filtrados
    private ArrayList<Item> itemsFiltrados;

    //Creo una variable para el filtro
    private ItemFilter filtro = new ItemFilter();

    public AdaptadorItem(Activity activity, ArrayList<Item> items)
    {
        this.activity=activity;
        this.items=items;
        this.itemsFiltrados=items; //Llenamos los filtrados
    }

    public int getCount() {
        return itemsFiltrados.size();
    }

    public Object getItem(int posicion) {
        return itemsFiltrados.get(posicion);
    }

    public long getItemId(int posicion) {
        return itemsFiltrados.get(posicion).getId();
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

        Item item = itemsFiltrados.get(posicion);
        holder.titulo.setText(item.getPrecio());
        holder.descripcion.setText(item.getDescripcion());
        holder.imagen.setImageResource(item.getImagen());

        return vista;
    }

    @Override
    public Filter getFilter() {
        return filtro;
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String cadenaAFiltrar = constraint.toString().toLowerCase();
            FilterResults resultadoFiltros = new FilterResults();

            final List<Item> list = items;

            int contadorItems = list.size();
            final List<Item> itemsEncontrados = new ArrayList<Item>(contadorItems);

            String filterableString ;

            for (int i = 0; i < contadorItems; i++) {
                filterableString = list.get(i).getPrecio();
                if (filterableString.toLowerCase().contains(cadenaAFiltrar)) {
                    itemsEncontrados.add(list.get(i));
                }
            }

            resultadoFiltros.values = itemsEncontrados;
            resultadoFiltros.count = itemsEncontrados.size();

            return resultadoFiltros;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            //Publico los items ya filtrados
            itemsFiltrados = (ArrayList<Item>) results.values;
            notifyDataSetChanged();
        }
    }
}
