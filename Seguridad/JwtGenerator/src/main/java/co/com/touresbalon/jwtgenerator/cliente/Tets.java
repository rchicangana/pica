/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.touresbalon.jwtgenerator.cliente;


import co.com.touresbalon.jwtgenerator.dto.TokenJwtDTO;
import co.com.touresbalon.jwtgenerator.impl.ClienteJWTBuilder;
import java.util.Date;
import java.util.UUID;

/**
 * runt.com.co
 * @author rchicangana
 */
public class Tets {
    
    public static void main(String[] args) {
        ClienteJWTBuilder clienteBuilder = new ClienteJWTBuilder();
        TokenJwtDTO token = new TokenJwtDTO();
        token.setId(UUID.randomUUID().toString());
        token.setIp("192.168.1.1");
        token.setAudience("Aui");
        token.setExpiration(1500L);
        token.setIssuedAt(new Date());
        token.setIssuer("Iusser");
        token.setNotBefore(new Date());
        token.setPassword("asdasd");
        token.setSubject("RCH");
        token.setUsername("RCH");
        
        ClienteJWT cliente = clienteBuilder.setLlaveSimetrica("admin123")
                .setToken(token)
                .build();
        
        try {
            String tokenGen = cliente.generarToken();
            System.out.println(tokenGen);
            TokenJwtDTO leido = cliente.validarToken(tokenGen, "admin123");
            System.out.println("Id " + leido.getId());
            System.out.println("Ip " + leido.getIp());
            System.out.println("username " + leido.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
