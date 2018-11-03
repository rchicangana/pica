/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.PaisDAO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.dto.PaisDTO;
import co.com.touresbalon.productservice.entidades.Pais;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchicangana
 */
@Stateless
public class PaisLogica {
    
    @EJB
    private PaisDAO paisDAO;
    
    
    /**
     * 
     * @return 
     */
    public List<PaisDTO> consultar(){
        return TransformacionDozer.transformar(paisDAO.findAll(), PaisDTO.class);
    }
    
    /**
     * 
     * @param entrada
     * @return 
     */
    public MensajeDTO guardar(PaisDTO entrada){
         MensajeDTO salida = new MensajeDTO();
        try {
            Pais pais = TransformacionDozer.transformar(entrada, Pais.class);
            paisDAO.guardar(pais);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(pais, PaisDTO.class));  
            
        
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
    public MensajeDTO editar(PaisDTO entrada){
         MensajeDTO salida = new MensajeDTO();
        try {
            Pais pais = TransformacionDozer.transformar(entrada, Pais.class);
            paisDAO.editar(pais);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(pais, PaisDTO.class));  
            
        
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        
        return salida;
    }
    
}
