/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.CiudadDAO;
import co.com.touresbalon.productservice.dto.CiudadDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.entidades.Ciudad;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchicangana
 */
@Stateless
public class CiudadLogica {
    
    @EJB
    private CiudadDAO ciudadDAO;
    
    
    /**
     * 
     * @param idPais
     * @return 
     */
    public List<CiudadDTO> consultar(Long idPais){
        return TransformacionDozer.transformar(ciudadDAO.finaByPais(idPais), CiudadDTO.class);
    }
    
    /**
     * 
     * @param entrada
     * @return 
     */
    public MensajeDTO guardar(CiudadDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            Ciudad ciudad = TransformacionDozer.transformar(entrada, Ciudad.class);
            ciudadDAO.guardar(ciudad);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(ciudad, CiudadDTO.class));
            
        } catch (Exception e) {
            
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
    
    public MensajeDTO editar(CiudadDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            Ciudad ciudad = TransformacionDozer.transformar(entrada, Ciudad.class);
            ciudadDAO.editar(ciudad);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(ciudad, CiudadDTO.class));
            
        } catch (Exception e) {
            
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
    
}
