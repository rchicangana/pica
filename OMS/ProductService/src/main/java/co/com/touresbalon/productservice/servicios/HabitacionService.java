/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.servicios;

import co.com.touresbalon.productservice.dto.HabitacionDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.logica.HabitacionLogica;
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
@Path("habitacion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HabitacionService {
    
    @EJB
    private HabitacionLogica habitacionLogica;
    
    /**
     * 
     * @param idHospedaje
     * @return 
     */
    @GET
    @Path("consultar/{idHospedaje}")
    public List<HabitacionDTO> consultar(@PathParam("idHospedaje") Long idHospedaje){
        return habitacionLogica.consultarPorHospedaje(idHospedaje);
    }
    
    /**
     * 
     * @param entrada
     * @return 
     */
    @POST
    @Path("guardar")
    public MensajeDTO guardar(HabitacionDTO entrada){
        return habitacionLogica.guardar(entrada);
    }
    
    /**
     * 
     * @param entrada
     * @return 
     */
    @PUT
    @Path("editar")
    public MensajeDTO editar(HabitacionDTO entrada){
        return habitacionLogica.editar(entrada);
    }
    
    
}
