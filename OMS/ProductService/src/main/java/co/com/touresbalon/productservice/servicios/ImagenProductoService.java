/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.servicios;

import co.com.touresbalon.productservice.dto.ImagenProductoDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.logica.ImagenProductoLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("imagenProducto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ImagenProductoService {
    
    @EJB
    private ImagenProductoLogica imagenProductoLogica;
    
    @GET
    @Path("consultar/{idProducto}")
    public List<ImagenProductoDTO> consultarImagenProducto(@PathParam("idProducto") Long idProducto){
        return imagenProductoLogica.finaAllProducto(idProducto);
    }
    
    @POST
    @Path("guardar")
    public MensajeDTO guardarImagenProducto(ImagenProductoDTO entrada){
        return imagenProductoLogica.guardar(entrada);
    }
    
    @DELETE
    @Path("eliminar/{idImagenProducto}")
    public MensajeDTO eliminarImagenProducto(@PathParam("idImagenProducto") Long idImagenProducto){
        return imagenProductoLogica.eliminar(idImagenProducto);
    }
    
    
   
    
    
}
