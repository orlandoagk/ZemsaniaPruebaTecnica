package com.zemsania.pruebatecnica.carrodecompra.persistencia.repositorios;

import com.zemsania.pruebatecnica.carrodecompra.modelos.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Integer> {
}
