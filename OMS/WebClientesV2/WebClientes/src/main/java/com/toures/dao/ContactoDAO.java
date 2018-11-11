/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.dao;

import com.toures.entidades.Cliente;
import com.toures.entidades.Contacto;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jpabl
 */
@Stateless
public class ContactoDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void crearContacto(Contacto contacto){
            em.persist(contacto);  
    }
    
    public void actualizarContacto(Contacto contacto){
        try{
            em.merge(contacto);
        }catch(Exception e){
            System.out.println("Error Actualizando contacto ");
            e.printStackTrace();
        }
    }
    
    public Contacto ConsultarContactoPorID(int id){
        return(Contacto)em.createNamedQuery("Contacto.findByIdContacto")
                .setParameter("idContacto", id)
                .getSingleResult();
    }
    
    public List<Contacto> ConsultarContactosPorCliente(Cliente id){
        return(List<Contacto>)em.createNamedQuery("Contacto.findByIdCliente")
                .setParameter("idCliente", id)
                .getResultList();
    }

    public void EliminarContacto(Contacto contacto){
        em.remove(contacto);   
    }    
}
