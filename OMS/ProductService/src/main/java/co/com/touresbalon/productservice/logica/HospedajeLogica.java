/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.HospedajeDAO;
import co.com.touresbalon.productservice.dto.HospedajeDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.dto.TipoProductoDTO;
import co.com.touresbalon.productservice.entidades.Hospedaje;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class HospedajeLogica {
    
    @EJB
    private HospedajeDAO hospedajeDAO;
    
    public List<HospedajeDTO> consultar(){
        return TransformacionDozer.transformar(hospedajeDAO.findAll(), HospedajeDTO.class);
    }
    
    public MensajeDTO guardar(HospedajeDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        try {
            Hospedaje hospedaje = TransformacionDozer.transformar(entrada, Hospedaje.class);
            hospedajeDAO.guardar(hospedaje);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(hospedaje, HospedajeDTO.class));
            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
        
    }
    
    public MensajeDTO editar(HospedajeDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        try {
            Hospedaje hospedaje = TransformacionDozer.transformar(entrada, Hospedaje.class);
            hospedajeDAO.actualizar(hospedaje);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(hospedaje, HospedajeDTO.class));
            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
        
    }
    
    
}
