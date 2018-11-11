/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.ws;

import com.toures.dto.CategoriaDTO;
import com.toures.dto.RespuestaRs;
import com.toures.negocio.TxCategorias;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jpabl
 */
@Path("CategoriasTx")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaWS {
    
    @EJB
    private TxCategorias tx;
    
    @POST
    @Path("Crear")
    public RespuestaRs CrearCategoria(CategoriaDTO categoria){
        return tx.crearCategoria(categoria);
    }
    
    @POST
    @Path("Actualizar")
    public RespuestaRs ActualizarCategoria(CategoriaDTO categoria){
        return tx.actualizarCategoria(categoria);
    }
    
    @GET
    @Path("Consultar/{nombre}")
    public CategoriaDTO ConsultarCategoria(@PathParam("nombre") String nombre){
        return tx.consultarCategoria(nombre);
    }
    
    @GET
    @Path("Listar")
    public List<CategoriaDTO> ListarCategoria(){
        return tx.listarCategorias();
    }
    
    @GET
    @Path("ConsultarID/{id}")
    public CategoriaDTO ConsultarCategoria(@PathParam("id") int id){
        return tx.consultarCategoria(id);
    }
    
    
}
