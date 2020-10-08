package com.zemsania.pruebatecnica.carrodecompra.servicios.AuthServices;

import com.zemsania.pruebatecnica.carrodecompra.persistencia.AuthPersistencia;
import com.zemsania.pruebatecnica.carrodecompra.persistencia.excepciones.AuthExcepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ImplAuthServices implements AuthServices {

    @Autowired
    AuthPersistencia authPersitencia;

    public boolean loginCorrecto(String username, String password){
        boolean loginCorrecto = false;
        try {
            String passwordAComparar = authPersitencia.getContraseñaUsuario(username);
            if(password.equals(passwordAComparar)){
                loginCorrecto = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AuthExcepcion authExcepcion) {
            //Manejar el logger
            authExcepcion.printStackTrace();
        }
        return loginCorrecto;
    }
}
