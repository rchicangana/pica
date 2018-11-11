/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.BoleteriaDAO;
import co.com.touresbalon.productservice.dao.ProductoDAO;
import co.com.touresbalon.productservice.dto.BoleteriaDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.entidades.Boleteria;
import co.com.touresbalon.productservice.entidades.Producto;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class BoleteriaLogica {
    
    @EJB
    private BoleteriaDAO boleteriaDAO;
    
    @EJB
    private ProductoDAO productoDAO;
    
    public BoleteriaDTO consultar(Long idProducto){
        return TransformacionDozer.transformar(boleteriaDAO.findByProducto(idProducto), BoleteriaDTO.class);
    }
    
    /**
     * 
     * @param entrada
     * @return 
     */
    public MensajeDTO guardar(BoleteriaDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        try {
            
            Boleteria boleteria = TransformacionDozer.transformar(entrada, Boleteria.class);
            boleteriaDAO.guardar(boleteria);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(salida);
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
}
