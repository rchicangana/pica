/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.jwtgenerator.impl;


import co.com.touresbalon.jwtgenerator.cliente.ClienteJWT;
import co.com.touresbalon.jwtgenerator.comun.Constantes;
import co.com.touresbalon.jwtgenerator.dto.TokenJwtDTO;
import co.com.touresbalon.jwtgenerator.exception.ErrorJWTException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * runt.com.co
 *
 * @author rchicangana
 */
public class ClienteJWTImpl implements ClienteJWT {

    private final String key;
    private final TokenJwtDTO token;

    /**
     *
     * @param key
     * @param token
     */
    public ClienteJWTImpl(String key, TokenJwtDTO token) {
        this.key = key;
        this.token = token;
    }

    @Override
    public String generarToken() throws ErrorJWTException {
        return createJWT(token, key);
    }

    @Override
    public TokenJwtDTO validarToken(String token, String key) throws ErrorJWTException {
        return parseJWT(token, key);
    }

    /**
     *
     * @param token
     * @param llaveSimetrica
     * @return
     */
    private static String createJWT(TokenJwtDTO token, String llaveSimetrica) {

        //generamos el Algoritmo
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

        //Generamos la firma
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(llaveSimetrica);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //Agregamos los CLAIMS
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(Constantes.IP, token.getIp());
        claims.put(Constantes.USERNAME, token.getUsername());
        claims.put(Constantes.PASSWORD, token.getPassword());

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(token.getId())
                .setIssuedAt(now)
                .setSubject(token.getSubject())
                .setIssuer(token.getIssuer())
                .signWith(signatureAlgorithm, signingKey);

        //si se especifico fecha de expiracion
        if (token.getExpiration() >= 0) {
            long expMillis = nowMillis + token.getExpiration();
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        //creamos el token
        return builder.compact();
    }

    /**
     *
     * @param token
     * @param llaveSimetrica
     * @return
     */
    private static TokenJwtDTO parseJWT(String token, String llaveSimetrica) throws ErrorJWTException {
        TokenJwtDTO salida = new TokenJwtDTO();
        try {

            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(llaveSimetrica))
                    .parseClaimsJws(token).getBody();
            
            salida.setId(claims.getId());
            salida.setSubject(claims.getSubject());
            salida.setIssuer(claims.getIssuer());
            salida.setIssuedAt(claims.getIssuedAt());
            salida.setExpiration(claims.getExpiration() == null ? null : claims.getExpiration().getTime());
            salida.setIp((String) claims.get(Constantes.IP));
            salida.setNotBefore(claims.getNotBefore());
            salida.setPassword((String) claims.get(Constantes.PASSWORD));
            salida.setUsername((String) claims.get(Constantes.USERNAME));
            return salida;
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            Logger.getLogger(ClienteJWTImpl.class.getName()).log(Level.INFO,"Token con problemas:",e);
            throw new ErrorJWTException(e.getLocalizedMessage());
        }

    }

}
