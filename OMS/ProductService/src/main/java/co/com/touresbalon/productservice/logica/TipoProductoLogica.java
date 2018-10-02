/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.TipoProductoDAO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.dto.TipoProductoDTO;
import co.com.touresbalon.productservice.entidades.TipoProducto;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class TipoProductoLogica {
    
    @EJB
    private TipoProductoDAO tipoProductoDAO;
    
    
    public List<TipoProductoDTO> consultarTIposProducto(){
        return TransformacionDozer.transformar(tipoProductoDAO.FindAll(), TipoProductoDTO.class);
    }
    
    
    public MensajeDTO guardar(TipoProductoDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        try {
            TipoProducto tipo = TransformacionDozer.transformar(entrada, TipoProducto.class);
            tipoProductoDAO.guardar(tipo);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(tipo, TipoProductoDTO.class));
        
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;
    }
    
    public MensajeDTO editar(TipoProductoDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        try {
            TipoProducto tipo = TransformacionDozer.transformar(entrada, TipoProducto.class);
            tipoProductoDAO.editar(tipo);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(tipo, TipoProductoDTO.class));
        
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;
    }
    
}
