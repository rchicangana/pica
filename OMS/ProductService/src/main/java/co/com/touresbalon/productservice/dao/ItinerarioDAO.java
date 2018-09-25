/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.Itinerario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchicangana
 */
@Stateless
public class ItinerarioDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    
    /**
     * 
     * @param id
     * @return 
     */
    public Itinerario findByID(Long id){
        return em.find(Itinerario.class, id);
    }
    
    /**
     * 
     * @param entidad
     * @return 
     */
    public Itinerario guardar(Itinerario entidad){
        em.persist(entidad);
        return entidad;
    }
    
    /**
     * 
     * @param entidad 
     */
    public void actualizar(Itinerario entidad){
        em.merge(entidad);
    }
    
    public void delete(Itinerario entidad){
        em.merge(entidad);
    }
    
}
