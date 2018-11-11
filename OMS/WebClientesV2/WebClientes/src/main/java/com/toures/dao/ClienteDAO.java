/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.dao;

import com.toures.entidades.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jpabl
 */
@Stateless
public class ClienteDAO {
 
    
    @PersistenceContext
    private EntityManager em;
    
    public void crearCliente(Cliente cliente){
        try{
            em.persist(cliente);
        }catch(Exception e){
            System.out.println("Error Creando cliente ");
            e.printStackTrace();
        }
            
    }
    
    public void actualizarCliente(Cliente cliente){
        try{
            em.merge(cliente);
        }catch(Exception e){
            System.out.println("Error Actualizando cliente ");
            e.printStackTrace();
        }
    }
    
    public Cliente ConsultarClientePorID(int id){
        try{
        return(Cliente)em.createNamedQuery("Cliente.findByIdCliente")
                .setParameter("idCliente", id)
                .getSingleResult();
        }catch(NoResultException nre){
            
        }
        return null;

        }
    
    public Cliente ConsultarClientesPorIdentificacion(String tipoId,String id){
        try{
            return(Cliente)em.createNamedQuery("Cliente.findByIdentificacion")
                    .setParameter("tipoDocumento", tipoId)
                    .setParameter("noDocumento", id)
                    .getSingleResult();
        }catch(NoResultException nre){
            
        }
        return null;
    }

    public void EliminarCliente(Cliente cliente){
        em.remove(cliente);   
    }      
}
