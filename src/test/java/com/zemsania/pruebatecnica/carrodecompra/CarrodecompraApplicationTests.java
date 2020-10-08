package com.zemsania.pruebatecnica.carrodecompra;

import com.zemsania.pruebatecnica.carrodecompra.modelos.Cliente;
import com.zemsania.pruebatecnica.carrodecompra.modelos.Venta;
import com.zemsania.pruebatecnica.carrodecompra.servicios.AuthServices.AuthServices;
import com.zemsania.pruebatecnica.carrodecompra.servicios.ServiciosCarro.ImplServiciosCarroCompra;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CarrodecompraApplicationTests {
    @Autowired
    private AuthServices authServices;
    @Autowired
    private ImplServiciosCarroCompra implServiciosCarroCompra;

    @Test
    void contextLoads() {
    }

    @Test
    void loginCorrecto(){
        Assert.isTrue(authServices.loginCorrecto("orlando","contraseñaPrueba"),"Debe realizar un login correcto");
    }

    @Test
    void loginIncorrecto(){
        Assert.isTrue(!authServices.loginCorrecto("orlando","contraseñaPruseba"),"Debe realizar un login correcto");
    }

    @Test
    void contarCuantasVentasTieneElCliente(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Orlando");
        cliente.setApellido("Gelves");
        cliente.setEmail("orlando@hotmail.com");
        cliente.setDni("1067961563");
        cliente.setTelefono("31073848293");
        cliente.setVentas(new ArrayList<>());
        implServiciosCarroCompra.añadirCliente(cliente);
        Venta venta = new Venta();
        venta.setFecha("7/10/2020");
        implServiciosCarroCompra.añadirVenta(venta,cliente.getDni());
        List<Venta> ventas = implServiciosCarroCompra.obtenerVentasDeCliente(cliente.getDni());
        Assert.isTrue(ventas.size()==1,"Las ventas deben ser igual a 1");

    }

}
