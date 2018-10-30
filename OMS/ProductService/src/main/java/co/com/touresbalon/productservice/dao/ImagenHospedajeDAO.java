/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.ImagenHospedaje;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchicangana
 */
@Stateless
public class ImagenHospedajeDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    
    public List<ImagenHospedaje> findAllByHospedaje(Long idHospedaje){
        return em.createNamedQuery("ImagenHospedaje.findByAllbyHospedaje")
                .setParameter("idHospedaje", idHospedaje)
                .getResultList();
    }
    
    public ImagenHospedaje findbyID(Long idImagen){
        return em.find(ImagenHospedaje.class, idImagen);
    }
    
    
    public ImagenHospedaje guardar(ImagenHospedaje entidad){
        em.persist(entidad);
        return entidad;
    }
    
    public void update(ImagenHospedaje entidad){
        em.merge(entidad);
    }
    
    public void delete(ImagenHospedaje entidad){
        em.remove(entidad);
    }
    
    
    
    
}
