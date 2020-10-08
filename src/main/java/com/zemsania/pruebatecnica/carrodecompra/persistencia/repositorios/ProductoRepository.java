package com.zemsania.pruebatecnica.carrodecompra.persistencia.repositorios;

import com.zemsania.pruebatecnica.carrodecompra.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
