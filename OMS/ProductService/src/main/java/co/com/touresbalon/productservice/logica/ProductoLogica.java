/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.ProductoDAO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.dto.ProductoDTO;
import co.com.touresbalon.productservice.entidades.Producto;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchicangana
 */
@Stateless
public class ProductoLogica {

    @EJB
    private ProductoDAO productoDAO;

    /**
     * 
     * @param codigo
     * @return 
     */
    public MensajeDTO buscarProdcutoporCodigo(final Long codigo) {

        MensajeDTO salida = new MensajeDTO();
        try {

            Producto producto = productoDAO.findByCodigo(codigo);
            if (producto == null) {
                salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
                salida.setMensaje(ConstantesComunes.MSG_SIN_DATOS);
            } else {
                salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
                salida.setObject(TransformacionDozer.transformar(producto, ProductoDTO.class));
            }

        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;

    }

    /**
     * 
     * @param nombre
     * @param inicio
     * @param fin
     * @return 
     */
    public MensajeDTO buscarProdcutoporDescripcion(final String nombre, final Integer inicio, final Integer fin) {

        MensajeDTO salida = new MensajeDTO();
        try {

            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(productoDAO.finByDesProductos(nombre, inicio, fin), ProductoDTO.class));

        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;

    }

}
