/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.servicios;

import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.dto.PaisDTO;
import co.com.touresbalon.productservice.logica.PaisLogica;
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
 * @author rchicangana
 */
@Stateless
@Path("pais")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaisService {
    
    @EJB
    private PaisLogica paisLogica;
    
    /**
     * 
     * @return 
     */
    @GET
    @Path("consultar")
    public List<PaisDTO> consultar(){
        return paisLogica.consultar();
    }
    
    @POST
    @Path("guardar")
    public MensajeDTO guardar(PaisDTO entrada){
        return paisLogica.guardar(entrada);
    }
    
    @PUT
    @Path("editar")
    public MensajeDTO editar(PaisDTO entrada){
        return paisLogica.editar(entrada);
    }
}
