/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.servicios;

import co.com.touresbalon.productservice.dto.ItinerarioDTO;
import co.com.touresbalon.productservice.dto.ItinerarioFrontDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.logica.ItinerarioLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
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
@Path("itinerario")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItinerarioService {
    
    @EJB
    private ItinerarioLogica itinerarioLogica;
    
    @GET
    @Path("consultar/{idProducto}")
    public List<ItinerarioFrontDTO> consultar(@PathParam("idProducto") Long idProducto){
        return itinerarioLogica.consultar(idProducto);
    }
    
    @POST
    @Path("guardar")
    public MensajeDTO guardar(ItinerarioFrontDTO itinerarioDTO){
        return itinerarioLogica.guardarItinerario(itinerarioDTO);
    }
    
    @PUT
    @Path("actualizar")
    public MensajeDTO actualizar(ItinerarioDTO itinerarioDTO){
        return itinerarioLogica.actualizarItinerario(itinerarioDTO);
    }
    
}
