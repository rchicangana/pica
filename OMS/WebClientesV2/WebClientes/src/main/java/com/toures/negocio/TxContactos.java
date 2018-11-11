/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.negocio;

import com.toures.dao.ClienteDAO;
import com.toures.dto.ContactoDTO;
import com.toures.dao.ContactoDAO;
import com.toures.dto.RespuestaRs;
import com.toures.entidades.Categoria;
import com.toures.entidades.Contacto;
import com.toures.util.FechasUtil;
import com.toures.util.TransformacionDozer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jpabl
 */
@Stateless
public class TxContactos {
    
    @EJB
    private ContactoDAO cont;
    
    @EJB
    private ClienteDAO cli;

    
    public RespuestaRs CrearContacto(ContactoDTO contacto ){
        cont.crearContacto(new Contacto(contacto.getDestinatario(), 
                                        contacto.getTipoDireccion(), 
                                        contacto.getDireccion(),
                                        contacto.getTelefono(),
                                        contacto.getCelular(),
                                        contacto.getIdCiudad(), 
                                        new Date(), 
                                        new Date(),
                                        cli.ConsultarClientePorID(contacto.getIdCliente()))
                          );
        return new RespuestaRs("ok", "Contacto creado exitosamente");
    }
    
    public List<ContactoDTO> ConsultarContactosPorCliente (int id){
        List<Contacto> lista = cont.ConsultarContactosPorCliente(cli.ConsultarClientePorID(id));
        List<ContactoDTO> objs = new ArrayList();
        for(Contacto obj: lista){
            objs.add(new ContactoDTO(obj.getIdContacto(), 
                                    obj.getDestinatario(), 
                                    obj.getTipoDireccion(),
                                    obj.getDireccion(),
                                    obj.getTelefono(),
                                    obj.getCelular(),
                                    obj.getIdCiudad(),
                                    FechasUtil.dateToString(obj.getFechaCreacion()), 
                                    FechasUtil.dateToString(obj.getFechaUltModificacion()),
                                    obj.getIdCliente().getIdCliente())
            );
        }
        
        return objs;
    }
    
    public ContactoDTO ConsultarContacto (int id){
        Contacto obj = cont.ConsultarContactoPorID(id);
        return new ContactoDTO( obj.getIdContacto(), 
                                obj.getDestinatario(), 
                                obj.getTipoDireccion(),
                                obj.getDireccion(),
                                obj.getTelefono(),
                                obj.getCelular(),
                                obj.getIdCiudad(),
                                FechasUtil.dateToString(obj.getFechaCreacion()), 
                                FechasUtil.dateToString(obj.getFechaUltModificacion()),
                                obj.getIdCliente().getIdCliente());
                
    }
    
    public RespuestaRs ActualizarContacto(ContactoDTO contacto ){
        Contacto obj = cont.ConsultarContactoPorID(contacto.getIdContacto());
                    obj.setIdContacto(contacto.getIdContacto()); 
                    obj.setDestinatario(contacto.getDestinatario()); 
                    obj.setTipoDireccion(contacto.getTipoDireccion());
                    obj.setDireccion(contacto.getDireccion());
                    obj.setTelefono(contacto.getTelefono());
                    obj.setCelular(contacto.getCelular());
                    obj.setIdCiudad(contacto.getIdCiudad());
                    obj.setFechaUltModificacion(new Date());
                    obj.setIdCliente(cli.ConsultarClientePorID(contacto.getIdCliente()));
        cont.actualizarContacto(obj);
        
        return new RespuestaRs("ok","Contacto Actualizado exitosamente");
    }
    
        public RespuestaRs EliminarContacto(ContactoDTO contacto ){
        Contacto obj = cont.ConsultarContactoPorID(contacto.getIdContacto());
        cont.EliminarContacto(obj);
        return new RespuestaRs("ok","Contacto Eliminado exitosamente");
    }
    
    
}
