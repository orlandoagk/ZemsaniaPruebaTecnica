package com.zemsania.pruebatecnica.carrodecompra.controladores;


import com.sun.deploy.net.HttpResponse;
import com.zemsania.pruebatecnica.carrodecompra.configuraciones.JWTAuthorizationFilter;
import com.zemsania.pruebatecnica.carrodecompra.modelos.JWToken;
import com.zemsania.pruebatecnica.carrodecompra.servicios.AuthServices.AuthServices;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServices authServices;

    Logger log4j2 = LogManager.getRootLogger();

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody JWToken jwToken){
        try {
            if (authServices.loginCorrecto(jwToken.getUsername(), jwToken.getPassword())) {
                String token = getJWTToken(jwToken.getUsername());
                jwToken.setPassword(null);
                jwToken.setToken(token);
                log4j2.debug("El inicio de sesion fue existoso");
                return new ResponseEntity<>(jwToken, HttpStatus.OK);
            } else {

                log4j2.info("datos incorrectos en el logeo");
                System.out.println("Usuario o contraseña incorrecta");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception e){
            log4j2.error("error en logeo");
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    public  String getJWTToken(String username) {
        String secretKey = "zemsaniaSecret";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId(username)
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
