/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.Habitacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchicangana
 */
@Stateless
public class HabitacionDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    
    /**
     * 
     * @param idHospedaje
     * @return 
     */
    public List<Habitacion> findByHospedaje(Long idHospedaje){
        return em.createNamedQuery("Habitacion.findByIdHospedaje")
                .setParameter("idHospedaje", idHospedaje)
                .getResultList();
    }
    
    /**
     * 
     * @param entrada
     * @return 
     */
    public Habitacion guardar(Habitacion entrada){
        em.persist(entrada);
        return entrada;
    }
    
    /**
     * 
     * @param entrada 
     */
    public void editar(Habitacion entrada){
        em.merge(entrada);
    }
    
}
