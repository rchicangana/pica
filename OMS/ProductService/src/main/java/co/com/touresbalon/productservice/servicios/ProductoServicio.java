/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.servicios;

import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.logica.ProductoLogica;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchicangana
 */
@Stateless
@Path("producto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoServicio {

    @EJB
    private ProductoLogica productoLogica;

    /**
     * 
     * @param codigo
     * @return 
     */
    @GET
    @Path("buscarProducto/{codigo}")
    public MensajeDTO buscarporCodigo(@PathParam("codigo") Long codigo) {
        return productoLogica.buscarProdcutoporCodigo(codigo);
    }

    
    /**
     * 
     * @param inicio
     * @param fin
     * @param descripcion
     * @return 
     */
    @GET
    @Path("buscarDescripcion/{inicio}/{fin}/{descripcion}")
    public MensajeDTO buscarporDescripcion(@PathParam("inicio") Integer inicio, @PathParam("fin") Integer fin, @PathParam("descripcion") String descripcion) {
        return productoLogica.buscarProdcutoporDescripcion(descripcion, inicio, fin);
    }

}