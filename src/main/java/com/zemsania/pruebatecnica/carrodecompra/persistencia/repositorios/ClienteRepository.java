package com.zemsania.pruebatecnica.carrodecompra.persistencia.repositorios;

import com.zemsania.pruebatecnica.carrodecompra.modelos.Cliente;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Service
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
