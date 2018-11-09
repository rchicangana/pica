/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.negocio;

import com.toures.dto.NovedadDTO;
import com.toures.dao.NovedadDAO;
import com.toures.entidades.Novedad;
import com.toures.util.TransformacionDozer;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jpabl
 */
@Stateless
public class TxNovedades {
    

    @EJB
    private NovedadDAO nov;
    
    public String CrearNovedad(NovedadDTO novedad ){
        nov.crearNovedad(TransformacionDozer.transformar(novedad, Novedad.class));
        return "Novedad creada exitosamente";
    }
    
    public NovedadDTO consultarNovedad (int id){
        return TransformacionDozer.transformar(nov.ConsultarNovedadPorID(id), NovedadDTO.class);
    }
    
    public List<NovedadDTO> consultarNovedadesPorFecha (Date fechaIni,Date fechaFin){
        return TransformacionDozer.transformar(nov.ConsultarNovedadesPorFecha(fechaIni,fechaFin), NovedadDTO.class);
    }
    
    public List<NovedadDTO> consultarNovedadesPorEntidad (String entidad){
        return TransformacionDozer.transformar(nov.ConsultarNovedadesPorEntidad(entidad), NovedadDTO.class);
    }
    
    public List<NovedadDTO> consultarNovedadesPorFiltro (String entidad,Date fechaIni,Date fechaFin){
        return TransformacionDozer.transformar(nov.ConsultarNovedadesPorFiltro(entidad,fechaIni,fechaFin), NovedadDTO.class);
    }    
    
    public String ActualizarNovedad(NovedadDTO novedad ){
        nov.actualizarNovedad(TransformacionDozer.transformar(novedad, Novedad.class));
       /* Novedad log = new Novedad(0, new Date(),"Novedades", "Novedad no existe", "Nuevo cliente creado con id "+cliente.getTipoDocumento()+" - " + cliente.getNoDocumento());
        nov.crearNovedad(log);*/
        return "Novedad Actualizado exitosamente";
    }
    
    
}
