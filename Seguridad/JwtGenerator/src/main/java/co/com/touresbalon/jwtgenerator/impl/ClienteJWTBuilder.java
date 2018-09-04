/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.touresbalon.jwtgenerator.impl;

import co.com.touresbalon.jwtgenerator.cliente.ClienteJWT;
import co.com.touresbalon.jwtgenerator.dto.TokenJwtDTO;
import co.com.touresbalon.jwtgenerator.exception.ConfiguracionInvalidaException;


/**
 * runt.com.co
 * @author rchicangana
 */
public class ClienteJWTBuilder {
    
    private String llaveSimetrica;
    private TokenJwtDTO token;
    
    public ClienteJWTBuilder setLlaveSimetrica(final String llaveSimetrica){
        this.llaveSimetrica = llaveSimetrica;
        return this;
    }
    
    public ClienteJWTBuilder setToken(final TokenJwtDTO token){
        this.token = token;
        return this;
    }
    
    public ClienteJWT build() {
        if (llaveSimetrica == null) {
            throw new ConfiguracionInvalidaException("Debe establecer la llave simetrica");
        } else {
            return new ClienteJWTImpl(llaveSimetrica, token);
        } 
    }

}
