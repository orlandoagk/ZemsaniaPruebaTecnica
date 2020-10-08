package com.zemsania.pruebatecnica.carrodecompra.servicios.ServiciosCarro;

import com.zemsania.pruebatecnica.carrodecompra.modelos.Cliente;
import com.zemsania.pruebatecnica.carrodecompra.modelos.Venta;
import com.zemsania.pruebatecnica.carrodecompra.persistencia.CarroCompraPersistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ImplServiciosCarroCompra {
    @Autowired
    private CarroCompraPersistencia carroCompraPersistencia;

    public void añadirCliente(Cliente cliente){
        carroCompraPersistencia.añadirCliente(cliente);
    }

    public void añadirVenta(Venta venta, String dni){
        carroCompraPersistencia.añadirVenta(venta, dni);
    }

    public List<Venta> obtenerVentasDeCliente(String dni){
        return carroCompraPersistencia.obtenerVentasUsuario(dni);
    }
}
