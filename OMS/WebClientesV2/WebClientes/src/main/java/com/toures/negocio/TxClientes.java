/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.negocio;

import com.toures.dto.ClienteDTO;
import com.toures.dao.ClienteDAO;
import com.toures.dao.CategoriaDAO;
import com.toures.dto.RespuestaRs;
import com.toures.entidades.Cliente;
import com.toures.entidades.Categoria;
import com.toures.util.FechasUtil;
import com.toures.util.TransformacionDozer;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jpabl
 */
@Stateless
public class TxClientes {
    
    @EJB
    private ClienteDAO cli;
    @EJB
    private CategoriaDAO cat;
    
    public RespuestaRs CrearCliente(ClienteDTO cliente ){
        Categoria obj = cat.ConsultarCategoriaPorID(cliente.getIdCategoria());
        Cliente existe = cli.ConsultarClientesPorIdentificacion(cliente.getTipoDocumento(), cliente.getNoDocumento());
        if ( existe != null)
            return new RespuestaRs("Error","Ya existe un cliente con ese tipo y numero de identificacion"); 
        else{
            cli.crearCliente(new Cliente(cliente.getTipoDocumento(), 
                                         cliente.getNoDocumento(),
                                         cliente.getNombres(),
                                         cliente.getApellido1(),
                                         cliente.getApellido2(),
                                         cliente.getRazonSocial(), 
                                         cliente.getEstado(), 
                                         new Date(), 
                                         new Date(),
                                         obj));
            return new RespuestaRs("ok","Cliente creado exitosamente");  
        }

    }
    
    public ClienteDTO ConsultarCliente (String tipoId, String NoId){
        Cliente obj = cli.ConsultarClientesPorIdentificacion(tipoId, NoId);
        if(obj != null)
        return new ClienteDTO(obj.getIdCliente(), 
                              obj.getTipoDocumento(),
                              obj.getNoDocumento(),
                              obj.getNombres(),
                              obj.getApellido1(), 
                              obj.getApellido2(), 
                              obj.getRazonSocial(), 
                              obj.getEstado(), 
                              obj.getIdContactoDef(), 
                              FechasUtil.dateToString(obj.getFechaCreacion()), 
                              FechasUtil.dateToString(obj.getFechaUltModificacion()), 
                              obj.getIdCategoria().getIdCategoria());
        else 
            return null;
    }
    public ClienteDTO ConsultarCliente (int id){
        Cliente obj = cli.ConsultarClientePorID(id);
        return new ClienteDTO(obj.getIdCliente(), 
                              obj.getTipoDocumento(),
                              obj.getNoDocumento(),
                              obj.getNombres(),
                              obj.getApellido1(), 
                              obj.getApellido2(), 
                              obj.getRazonSocial(), 
                              obj.getEstado(), 
                              obj.getIdContactoDef(), 
                              FechasUtil.dateToString(obj.getFechaCreacion()), 
                              FechasUtil.dateToString(obj.getFechaUltModificacion()), 
                              obj.getIdCategoria().getIdCategoria());
    }    
    public RespuestaRs ActualizarCliente(ClienteDTO cliente ){
        System.out.println("Id Cliente " + cliente.getIdCliente());
        System.out.println("Id categoria " + cliente.getIdCategoria());
        Cliente obj = cli.ConsultarClientePorID(cliente.getIdCliente());
                    obj.setTipoDocumento(cliente.getTipoDocumento());
                    obj.setNoDocumento(cliente.getNoDocumento());
                    obj.setNombres(cliente.getNombres());
                    obj.setApellido1(cliente.getApellido1()); 
                    obj.setApellido2(cliente.getApellido2()); 
                    obj.setRazonSocial(cliente.getRazonSocial()); 
                    obj.setEstado(cliente.getEstado()); 
                    obj.setIdContactoDef(cliente.getIdContactoDef());  
                    obj.setFechaUltModificacion(new Date()); 
                    obj.setIdCategoria(cat.ConsultarCategoriaPorID(cliente.getIdCategoria()));
                    cli.actualizarCliente(obj);
        
        
        return new RespuestaRs("ok","Cliente Actualizado exitosamente");
    }
    
    
}
