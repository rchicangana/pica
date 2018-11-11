/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.servicios;

import co.com.touresbalon.productservice.dto.BoleteriaDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.logica.BoleteriaLogica;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("boleteria")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BoleteriaService {
    
    @EJB
    private BoleteriaLogica boleteriaLogica;
    
    
    @GET
    @Path("consultar/{idProducto}")
    public BoleteriaDTO consultar(@PathParam("idProducto") Long idProducto){
        return boleteriaLogica.consultar(idProducto);
    }
    
    @POST
    @Path("guardar")
    public MensajeDTO guardar(BoleteriaDTO entrada){
        return boleteriaLogica.guardar(entrada);
    }
            
    
}
