package com.zemsania.pruebatecnica.carrodecompra.persistencia;

import com.zemsania.pruebatecnica.carrodecompra.persistencia.excepciones.AuthExcepcion;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class AuthPersistencia {

    public String getContraseñaUsuario(String username) throws IOException, AuthExcepcion {
        File file = new File("usuarioscontrasenas.txt");

        BufferedReader br = null;

        br = new BufferedReader(new FileReader(file));

        String st;
        String contraseñaUsuario = "";
        while ((st = br.readLine()) != null){
            String usernameTMP = st.split(" ")[0];
            String contraseñaTMP = st.split(" ")[1];
            if(username.equals(usernameTMP)){
                contraseñaUsuario = contraseñaTMP;
            }

        }

        if(contraseñaUsuario.equals("")){
            throw new AuthExcepcion(AuthExcepcion.USUARIO_NO_ENCONTRADO);
        }
        return contraseñaUsuario;
    }
}
