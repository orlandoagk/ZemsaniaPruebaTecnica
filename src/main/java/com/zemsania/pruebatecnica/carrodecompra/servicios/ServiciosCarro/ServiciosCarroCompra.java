package com.zemsania.pruebatecnica.carrodecompra.servicios.ServiciosCarro;

import com.zemsania.pruebatecnica.carrodecompra.modelos.Cliente;
import com.zemsania.pruebatecnica.carrodecompra.persistencia.CarroCompraPersistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public interface ServiciosCarroCompra {
    public void añadirCliente(Cliente cliente);

}
