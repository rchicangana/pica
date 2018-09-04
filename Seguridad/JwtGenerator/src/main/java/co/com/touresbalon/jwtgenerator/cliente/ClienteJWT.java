/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.jwtgenerator.cliente;

import co.com.touresbalon.jwtgenerator.dto.TokenJwtDTO;
import co.com.touresbalon.jwtgenerator.exception.ErrorJWTException;



/**
 * runt.com.co
 *
 * @author rchicangana
 */
public interface ClienteJWT {

    /**
     * Permite generar un token JSON WEB Token
     * @return
     * @throws ErrorJWTException 
     */
    public String generarToken() throws ErrorJWTException;

    /**
     * Permite leer un Json Web Token
     * @param token
     * @param key
     * @return
     * @throws ErrorJWTException 
     */
    public TokenJwtDTO validarToken(final String token, final String key) throws ErrorJWTException;

}
