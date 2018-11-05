/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.Hospedaje;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class HospedajeDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    
    public List<Hospedaje> findAll(){
        return em.createNamedQuery("Hospedaje.findAll")
                .getResultList();
    }
    
    public Hospedaje findByID(Long id){
        return em.find(Hospedaje.class, id);
    }
    
    /**
     * 
     * @param entidad
     * @return 
     */
    public Hospedaje guardar(Hospedaje entidad){
        em.persist(entidad);
        return entidad;
    }
    
    /**
     * 
     * @param entidad 
     */
    public void actualizar(Hospedaje entidad){
        em.merge(entidad);
    }
    
    public void delete(Hospedaje entidad){
        em.merge(entidad);
    }
    
}
