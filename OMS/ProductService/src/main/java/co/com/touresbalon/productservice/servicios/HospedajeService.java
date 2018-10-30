/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.servicios;

import co.com.touresbalon.productservice.dto.HospedajeDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.logica.HospedajeLogica;
import java.util.List;
import javax.ejb.EJB;
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
@Path("hospedaje")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HospedajeService {
    
    @EJB
    private HospedajeLogica hospedajeLogica;
    
    @GET
    @Path("consultar")
    public List<HospedajeDTO> consultar(){
        return hospedajeLogica.consultar();
    }
    
    @POST
    @Path("guardar")
    public MensajeDTO guardar(HospedajeDTO entrada){
        return hospedajeLogica.guardar(entrada);
    }
    
    @PUT
    @Path("editar")
    public MensajeDTO editar(HospedajeDTO entrada){
        return hospedajeLogica.editar(entrada);
    }
    
    
    
    
}
