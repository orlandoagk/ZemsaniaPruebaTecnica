package com.zemsania.pruebatecnica.carrodecompra.controladores;

import com.zemsania.pruebatecnica.carrodecompra.modelos.Cliente;
import com.zemsania.pruebatecnica.carrodecompra.modelos.Venta;
import com.zemsania.pruebatecnica.carrodecompra.servicios.ServiciosCarro.ImplServiciosCarroCompra;
import com.zemsania.pruebatecnica.carrodecompra.servicios.ServiciosCarro.ServiciosCarroCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrocompra")
public class CarroCompraControlador {
    @Autowired
    private ImplServiciosCarroCompra serviciosCarroCompra;


    @RequestMapping(value = "/nuevoCliente",method = RequestMethod.POST)
    public ResponseEntity<?> nuevoCliente(@RequestBody Cliente cliente){
        try{
            serviciosCarroCompra.añadirCliente(cliente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    @RequestMapping(value = "/nuevaVenta/{dni}",method = RequestMethod.POST)
    public ResponseEntity<?> nuevaVenta(@RequestBody Venta venta, @PathVariable String dni){
        try{
            serviciosCarroCompra.añadirVenta(venta,dni);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/obtenerVentasDelCliente/{dni}",method = RequestMethod.GET)
    public ResponseEntity<?> obtenerVentasDelCliente(@PathVariable String dni){
        try{

            return new ResponseEntity<>(serviciosCarroCompra.obtenerVentasDeCliente(dni),HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
