/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.clienteredisservices.logica;

import co.com.touresbalon.clienteredisservices.api.ClienteRedisService;

/**
 *
 * @author rchic
 */
public class ClienteRedisServiceBuilder {

    private String servidor;
    private String contexto = "RedisServices";
    private int puerto = 8080;
    
    public ClienteRedisServiceBuilder servidor(final String servidor) {
        this.servidor = servidor;
        return this;
    }

    /**
     * Establece el contexto de consulta del servicio
     *
     * @param contexto el contexto de consulta del servicio
     * @return
     */
    public ClienteRedisServiceBuilder contexto(final String contexto) {
        this.contexto = contexto;
        return this;
    }

    /**
     * Establece el puerto donde se enviarán las perticiones
     *
     * @param puerto puerto
     * @return
     */
    public ClienteRedisServiceBuilder puerto(final int puerto) {
        this.puerto = puerto;
        return this;
    }
    
    public ClienteRedisService build() {
       
            return new ClienteRedisServiceImpl(servidor, puerto, contexto);
    }
    
}
