/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.ItinerarioDAO;
import co.com.touresbalon.productservice.dto.ItinerarioDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.entidades.Itinerario;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchicangana
 */
@Stateless
public class ItinerarioLogica {
    
    @EJB
    private ItinerarioDAO itinerarioDAO;
    
    
    
    
    /**
     * 
     * @param entrada
     * @return 
     */
    public MensajeDTO guardarItinerario(ItinerarioDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            Itinerario itinerario = TransformacionDozer.transformar(entrada, Itinerario.class);
            itinerarioDAO.guardar(itinerario);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(itinerario, ItinerarioDTO.class));            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage()); 
        }
        
        return salida;
    }
    
    /**
     * 
     * @param entrada
     * @return 
     */
    public MensajeDTO actualizarItinerario(ItinerarioDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            Itinerario itinerario = TransformacionDozer.transformar(entrada, Itinerario.class);
            itinerarioDAO.actualizar(itinerario);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(itinerario, ItinerarioDTO.class));            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
}
