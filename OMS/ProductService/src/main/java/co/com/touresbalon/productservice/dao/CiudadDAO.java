/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.Ciudad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchicangana
 */
@Stateless
public class CiudadDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    
    /**
     * 
     * @param idPais
     * @return 
     */
    public List<Ciudad> finaByPais(Long idPais){
        return em.createNamedQuery("Ciudad.findByIdPais")
                .setParameter("idPais", idPais)
                .getResultList();
                
    }
    
    /**
     * 
     * @param idCiudad
     * @return 
     */
    public Ciudad findByID(Long idCiudad){
        return em.find(Ciudad.class, idCiudad);
    }
    
    
    public Ciudad guardar(Ciudad entidad){
        em.persist(entidad);
        return entidad;        
    }
    
    public void editar(Ciudad entidad){
        em.merge(entidad);
    }
            
    
}
