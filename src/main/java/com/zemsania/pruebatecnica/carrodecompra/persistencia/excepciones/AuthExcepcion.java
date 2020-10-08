package com.zemsania.pruebatecnica.carrodecompra.persistencia.excepciones;

import com.zemsania.pruebatecnica.carrodecompra.servicios.AuthServices.AuthServices;

public class AuthExcepcion extends Exception {
    static final public String USUARIO_NO_ENCONTRADO = "El usuario digitado no se encontro en el archivo";

    public AuthExcepcion(String mensaje){
        super(mensaje);
    }
}
