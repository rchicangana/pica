/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.servicios;

import co.com.touresbalon.productservice.dto.CiudadDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.logica.CiudadLogica;
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
 * @author rchicangana
 */
@Stateless
@Path("ciudad")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CiudadService {
    
    @EJB
    private CiudadLogica ciudadLogica;
    
    
    /**
     * 
     * @param idPais
     * @return 
     */
    @GET
    @Path("consultar/{idPais}")
    public List<CiudadDTO> consultar(@PathParam("idPais") Long idPais){
        return ciudadLogica.consultar(idPais);
    }
    
    /**
     * 
     * @param entrada
     * @return 
     */
    @POST
    @Path("guardar")
    public MensajeDTO guardar(CiudadDTO entrada){
        return ciudadLogica.guardar(entrada);
                
    }
    
    
    /***
     * 
     * @param entrada
     * @return 
     */
    @PUT
    @Path("editar")
    public MensajeDTO editar(CiudadDTO entrada){
        return ciudadLogica.editar(entrada);
                
    }
    
    
    
    
}
