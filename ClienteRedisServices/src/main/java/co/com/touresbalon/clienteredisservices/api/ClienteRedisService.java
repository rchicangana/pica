/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.clienteredisservices.api;

import co.com.touresbalon.clienteredisservices.dto.ListDTO;
import co.com.touresbalon.clienteredisservices.dto.MensajeValorDTO;
import co.com.touresbalon.clienteredisservices.exceptions.ErrorConsultaException;
import java.util.List;

/**
 *
 * @author rchic
 */
public interface ClienteRedisService {
    
    /**
     * Permite crear una llave valor en redis
     * @param key
     * @param value
     * @return
     * @throws ErrorConsultaException 
     */
    public boolean putKV(String key, String value) throws ErrorConsultaException;
    
    /**
     * Permite consultar una llave  valor en redis
     * @param key
     * @return
     * @throws ErrorConsultaException 
     */
    public MensajeValorDTO getKV(String key) throws ErrorConsultaException;
    
    /**
     * Permite crear una lista de strings en redis
     * @param listName
     * @param data
     * @return
     * @throws ErrorConsultaException 
     */
    public boolean putList(String listName, List<String> data) throws ErrorConsultaException;
    
    /**
     * permite obtener una lista
     * @param listName
     * @param firstResult
     * @param lastResult
     * @return
     * @throws ErrorConsultaException 
     */
    public ListDTO getList(String listName, int firstResult, int lastResult) throws ErrorConsultaException;
    
    
    /**
     * permite borrar una lista completa
     * @param listName
     * @return
     * @throws ErrorConsultaException 
     */
    public boolean removeList(String listName) throws ErrorConsultaException;
    
    
    
}
