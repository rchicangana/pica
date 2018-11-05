/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.TarifaTransporte;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class TarifaTransporteDAO {

    @PersistenceContext
    private EntityManager em;

    public TarifaTransporte findByRuta(Long idRuta) {
        try {
            return (TarifaTransporte)em.createNamedQuery("TarifaTransporte.findByIdRuta")
                .setParameter("idRuta", idRuta)
                .setMaxResults(1)
                .getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    }

    public TarifaTransporte findById(Long id) {
        return em.find(TarifaTransporte.class, id);
    }

    public TarifaTransporte guardar(TarifaTransporte entidad) {
        em.persist(entidad);
        return entidad;
    }

    public void actualizar(TarifaTransporte entidad) {
        em.merge(entidad);
    }

    public void eliminar(TarifaTransporte entidad) {
        em.remove(entidad);
    }

}
