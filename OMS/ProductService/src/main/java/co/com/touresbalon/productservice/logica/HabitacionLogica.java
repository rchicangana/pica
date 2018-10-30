/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.HabitacionDAO;
import co.com.touresbalon.productservice.dto.HabitacionDTO;
import co.com.touresbalon.productservice.dto.HospedajeDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.entidades.Habitacion;
import co.com.touresbalon.productservice.entidades.Hospedaje;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchicangana
 */
@Stateless
public class HabitacionLogica {
    
    @EJB
    private HabitacionDAO habitacionDAO;
    
    /**
     * 
     * @param idHospedaje
     * @return 
     */
    public List<HabitacionDTO> consultarPorHospedaje(Long idHospedaje){
        return TransformacionDozer.transformar(habitacionDAO.findByHospedaje(idHospedaje), HabitacionDTO.class);
    }
    
    public MensajeDTO guardar(HabitacionDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        try {
            Habitacion habitacion = TransformacionDozer.transformar(entrada, Habitacion.class);
            habitacionDAO.guardar(habitacion);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(habitacion, HabitacionDTO.class));  
            
        
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
    public MensajeDTO editar(HabitacionDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        try {
            Habitacion habitacion = TransformacionDozer.transformar(entrada, Habitacion.class);
            habitacionDAO.editar(habitacion);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(habitacion, HabitacionDTO.class));  
            
        
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        
        return salida;
    }
    
    
}
