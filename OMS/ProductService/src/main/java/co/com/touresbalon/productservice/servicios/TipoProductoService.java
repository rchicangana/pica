/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.servicios;

import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.dto.TipoProductoDTO;
import co.com.touresbalon.productservice.logica.TipoProductoLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("tipoProducto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoProductoService {
    
    @EJB
    private TipoProductoLogica tipoProductoLogica;
    
    @GET
    @Path("consultar")
    public List<TipoProductoDTO> consultar(){
        return tipoProductoLogica.consultarTIposProducto();
    }
    
    
    @POST
    @Path("guardar")
    public MensajeDTO guardar(TipoProductoDTO entrada){
        return tipoProductoLogica.guardar(entrada);
    }
    
    @PUT
    @Path("editar")
    public MensajeDTO editar(TipoProductoDTO entrada){
        return tipoProductoLogica.editar(entrada);
    }
            
}
