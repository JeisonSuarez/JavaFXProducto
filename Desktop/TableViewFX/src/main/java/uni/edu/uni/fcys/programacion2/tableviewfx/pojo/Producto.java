/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.edu.uni.fcys.programacion2.tableviewfx.pojo;

/**
 *
 * @author Sistemas-12
 */
public class Producto {
   private int id;
   private String Nombre;
   private String Descipcion;
   private int cantidad;
   private float precio;
   private String image;

    public Producto() {
    }

    public Producto(int id, String Nombre, String Descipcion, int cantidad, float precio, String image) {
        this.id = id;
        this.Nombre = Nombre;
        this.Descipcion = Descipcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescipcion() {
        return Descipcion;
    }

    public void setDescipcion(String Descipcion) {
        this.Descipcion = Descipcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
   
    
}
