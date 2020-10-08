package com.zemsania.pruebatecnica.carrodecompra.modelos;


import javax.persistence.*;


@Entity
@Table(name="producto")
public class Producto {

    @Id
    private int idProducto;
    private String nombre;
    private int precio;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
