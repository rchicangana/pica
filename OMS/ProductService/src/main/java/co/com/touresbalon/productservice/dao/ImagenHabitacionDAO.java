/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.ImagenHabitacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchicangana
 */
@Stateless
public class ImagenHabitacionDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<ImagenHabitacion> findAll(Long idHabitacion){
        return em.createNamedQuery("ImagenHabitacion.findByIdHabitacion")
                .setParameter("idHabitacion", idHabitacion)
                .getResultList();
    }
    
    public ImagenHabitacion findByID(Long id){
        return em.find(ImagenHabitacion.class, id);
    }
    
    public ImagenHabitacion guardar(ImagenHabitacion entidad){
        em.persist(entidad);
        return entidad;
    }
    
    public void eliminar(ImagenHabitacion entidad){
        em.remove(entidad);
    }
    
}
