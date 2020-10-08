package com.zemsania.pruebatecnica.carrodecompra.modelos;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="producto")
public class Producto {

    @Id
    private int idProducto;
    private String nombre;
    private int precio;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idProducto", cascade = CascadeType.ALL)
    private List<DetalleVenta> detallesVenta;

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

    public List<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }
}
