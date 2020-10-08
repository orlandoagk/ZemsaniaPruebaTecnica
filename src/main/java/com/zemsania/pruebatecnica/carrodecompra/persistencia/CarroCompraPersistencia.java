package com.zemsania.pruebatecnica.carrodecompra.persistencia;

import com.zemsania.pruebatecnica.carrodecompra.modelos.Cliente;
import com.zemsania.pruebatecnica.carrodecompra.modelos.Venta;
import com.zemsania.pruebatecnica.carrodecompra.persistencia.repositorios.ClienteRepository;
import com.zemsania.pruebatecnica.carrodecompra.persistencia.repositorios.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroCompraPersistencia {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VentaRepository ventaRepository;

    public void añadirCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public Cliente obtenerCliente(String dni){
        List<Cliente> clientes = clienteRepository.findAll();
        Cliente cliente = null;
        for(Cliente c:clientes){
            if(c.getDni().equals(dni)){
                cliente = c;
                break;
            }
        }
        return cliente;
    }

    public void añadirVenta(Venta venta, String dni){
        Cliente cliente = obtenerCliente(dni);
        cliente.getVentas().add(venta);
        venta.setIdCliente(cliente);
        ventaRepository.save(venta);
        clienteRepository.saveAndFlush(cliente);
    }

    public List<Venta> obtenerVentasUsuario(String dni){
        Cliente cliente = obtenerCliente(dni);
        return cliente.getVentas();
    }


}
