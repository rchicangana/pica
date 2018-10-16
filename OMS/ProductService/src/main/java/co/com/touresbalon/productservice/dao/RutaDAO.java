/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.Ruta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class RutaDAO {
    
    @PersistenceContext
    private EntityManager em;

    public List<Ruta> findByItinerario(Long idItinerario) {
        return em.createNamedQuery("Ruta.findByItinerario")
                .setParameter("idItinerario", idItinerario)
                .getResultList();
    }

    public Ruta findById(Long id) {
        return em.find(Ruta.class, id);
    }

    public Ruta guardar(Ruta entidad) {
        em.persist(entidad);
        return entidad;
    }

    public void actualizar(Ruta entidad) {
        em.merge(entidad);
    }

    public void eliminar(Ruta entidad) {
        em.remove(entidad);
    }
    
}
