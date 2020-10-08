package com.zemsania.pruebatecnica.carrodecompra.controladores;

import com.zemsania.pruebatecnica.carrodecompra.modelos.Cliente;
import com.zemsania.pruebatecnica.carrodecompra.modelos.Producto;
import com.zemsania.pruebatecnica.carrodecompra.modelos.Venta;
import com.zemsania.pruebatecnica.carrodecompra.servicios.ServiciosCarro.ImplServiciosCarroCompra;
import com.zemsania.pruebatecnica.carrodecompra.servicios.ServiciosCarro.ServiciosCarroCompra;
import org.json.JSONObject;
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
            JSONObject errorJSON = new JSONObject();
            errorJSON.put("HttpStatus",HttpStatus.FORBIDDEN);
            errorJSON.put("Message","Ya hay un cliente registrado con el DNI, EMAIL o TELEFONO");
            errorJSON.put("Code",HttpStatus.FORBIDDEN.value());
            errorJSON.put("BackendMessage",e.getMessage());
            return new ResponseEntity<>(errorJSON.toMap(),HttpStatus.FORBIDDEN);
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

    @RequestMapping(value = "/añadirProducto",method = RequestMethod.POST)
    public ResponseEntity<?> añadirProducto(@RequestBody Producto producto){
        try{
            serviciosCarroCompra.añadirProducto(producto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/obtenerProducto/{idProducto}",method = RequestMethod.GET)
    public ResponseEntity<?> añadirProducto(@PathVariable int idProducto){
        try{
            return new ResponseEntity<>(serviciosCarroCompra.obtenerProducto(idProducto),HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/eliminarProducto",method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarProducto(@RequestBody Producto producto){
        try{
            serviciosCarroCompra.eliminarProducto(producto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/actualizarProducto",method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto){
        try{
            serviciosCarroCompra.actualizarProducto(producto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
