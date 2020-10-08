package com.zemsania.pruebatecnica.carrodecompra.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVenta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private Cliente idCliente;
    private String fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private DetalleVenta idDetalleVenta;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public DetalleVenta getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(DetalleVenta idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }
}
