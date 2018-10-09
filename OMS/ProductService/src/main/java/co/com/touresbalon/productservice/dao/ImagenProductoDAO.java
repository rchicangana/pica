/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.ImagenProducto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchicangana
 */
@Stateless
public class ImagenProductoDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    
    public List<ImagenProducto> findAll(Long idProducto){
        return em.createNamedQuery("ImagenProducto.findByAllbyIdProducto")
                .setParameter("idProducto", idProducto)
                .getResultList();
    }
    
    public ImagenProducto findByID(Long id){
        return em.find(ImagenProducto.class, id);
    }
    
    public ImagenProducto guardar(ImagenProducto entidad){
        em.persist(entidad);
        return entidad;
    }
    
    public void eliminar(ImagenProducto entidad){
        em.remove(entidad);
    }
    
}
