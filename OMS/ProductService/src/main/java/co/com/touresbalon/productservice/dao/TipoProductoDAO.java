/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.TipoProducto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class TipoProductoDAO {
    
    @PersistenceContext()
    private  EntityManager em;
    
    
    public List<TipoProducto> FindAll(){
        return em.createNamedQuery("TipoProducto.findAll")
                .getResultList(); 
    }
    
    
    public TipoProducto findByID(Long id){
        return em.find(TipoProducto.class, id);
    }
    
    public TipoProducto guardar(TipoProducto entidad){
        em.persist(entidad);
        return entidad;
    }
    
    public void editar(TipoProducto entidad){
        em.merge(entidad);
    }
    
    public void eliminar(TipoProducto entidad){
        em.remove(entidad);
    }
    
}
