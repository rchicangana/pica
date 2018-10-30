/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.redisservices.redis.dto;

/**
 *
 * @author rchic
 */
public class MensajeValorDTO {
    
    
    private String valor;

    public MensajeValorDTO() {
    }
    
    

    public MensajeValorDTO(String valor) {
        this.valor = valor;
    }
    
    

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
