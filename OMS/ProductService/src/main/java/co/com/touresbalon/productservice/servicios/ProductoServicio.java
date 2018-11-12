/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.servicios;

import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.dto.ProductoDTO;
import co.com.touresbalon.productservice.logica.ProductoLogica;
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
    
    @GET
    @Path("buscar/{inicio}/{fin}")
    public MensajeDTO buscar(@PathParam("inicio") Integer inicio, @PathParam("fin") Integer fin) {
        return productoLogica.buscarProdcuto(inicio, fin);
    }
    
    @GET
    @Path("topFive")
    public MensajeDTO getTopFive(){
        return productoLogica.getTopFive();
    }
    
    @GET
    @Path("topFiveProductos")
    public MensajeDTO getTopFiveProductos(){
        return productoLogica.getTopFiveProductos();
    }
    
    @GET
    @Path("topFiveProducto/{producto}")
    public MensajeDTO getTopFiveProducto(@PathParam("producto") Long idProducto){
        return productoLogica.getTopFiveProducto(idProducto);
    }
    
    
    @GET
    @Path("topCategorias/{fechaini}/{fechafin}")
    public MensajeDTO getTTopCategorias(@PathParam("fechaini") String fechaini, @PathParam("fechafin") String fechafin){
        return productoLogica.getTopFiveCategoria(fechaini, fechafin);
    }
    
    @GET
    @Path("topProductos/{fechaini}/{fechafin}")
    public MensajeDTO getTTopProductos(@PathParam("fechaini") String fechaini, @PathParam("fechafin") String fechafin){
        return productoLogica.getTopProdcutos(fechaini, fechafin);
    }
    
    @POST
    @Path("guardar")
    public MensajeDTO guardar(ProductoDTO entrada){
        return productoLogica.guardarProducto(entrada);
    }
    
    @PUT
    @Path("editar")
    public MensajeDTO editar(ProductoDTO entrada){
        return productoLogica.actualizarProducto(entrada);
    }
    

}
