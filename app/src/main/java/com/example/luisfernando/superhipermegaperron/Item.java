package com.example.luisfernando.superhipermegaperron;

/**
 * Created by Luis Fernando on 10/03/2017.
 */

public class Item {
    protected int id;
    protected String precio;
    protected String descripcion;
    protected int imagen;

    //Creamos el constructor
    public Item(int id,String precio, String descripcion, int imagen)
    {
        this.id=id;
        this.precio=precio;
        this.descripcion=descripcion;
        this.imagen=imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String titulo) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}
