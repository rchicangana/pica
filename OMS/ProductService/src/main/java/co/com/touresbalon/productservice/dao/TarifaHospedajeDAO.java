/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.TarifaHospedaje;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */

@Stateless
public class TarifaHospedajeDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<TarifaHospedaje> findByHabitacion(Long idHabitacion){
        return em.createNamedQuery("TarifaHospedaje.findByIdHabitacion")
                .setParameter("idHabitacion", idHabitacion)
                .getResultList();
    }
    
    public TarifaHospedaje findById(Long id){
        return em.find(TarifaHospedaje.class, id);
    }            
    
    
    public TarifaHospedaje guardar(TarifaHospedaje entidad){
        em.persist(entidad);
        return entidad;
    }
    
    public void actualizar(TarifaHospedaje entidad){
        em.merge(entidad);
    }
    
    public void eliminar(TarifaHospedaje entidad){
        em.remove(entidad);
    }
}
