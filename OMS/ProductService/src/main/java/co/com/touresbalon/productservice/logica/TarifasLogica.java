/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.BoleteriaDAO;
import co.com.touresbalon.productservice.dao.ProductoDAO;
import co.com.touresbalon.productservice.dao.RutaDAO;
import co.com.touresbalon.productservice.dao.TarifaHospedajeDAO;
import co.com.touresbalon.productservice.dao.TarifaTransporteDAO;
import co.com.touresbalon.productservice.dto.BoleteriaDTO;
import co.com.touresbalon.productservice.dto.HabitacionDTO;
import co.com.touresbalon.productservice.dto.ItinerarioDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.dto.RutaDTO;
import co.com.touresbalon.productservice.dto.TarifaHospedajeDTO;
import co.com.touresbalon.productservice.dto.TarifaProductoDTO;
import co.com.touresbalon.productservice.dto.TarifaTransporteDTO;
import co.com.touresbalon.productservice.entidades.Boleteria;
import co.com.touresbalon.productservice.entidades.Producto;
import co.com.touresbalon.productservice.entidades.Ruta;
import co.com.touresbalon.productservice.entidades.TarifaHospedaje;
import co.com.touresbalon.productservice.entidades.TarifaTransporte;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */

@Stateless
public class TarifasLogica {
    
    @EJB
    private ProductoDAO productoDAO;
    
    @EJB
    private RutaDAO rutaDAO;
    
    @EJB
    private TarifaHospedajeDAO tarifaHospedajeDAO;
    
    @EJB
    private TarifaTransporteDAO tarifaTransporteDAO;
    
    @EJB
    private BoleteriaDAO boleteriaDAO;
    
    
    
    public MensajeDTO consultarTarifaProducto(Long idProducto){
        MensajeDTO salida = new MensajeDTO();
        TarifaProductoDTO tarifa = new TarifaProductoDTO();
        Long total=0L;
        try {
            Producto producto = productoDAO.findByCodigo(idProducto);
            if(producto!=null){
                tarifa.setItinerarioDTOlist(TransformacionDozer.transformar(producto.getItinerarioList(), ItinerarioDTO.class));
                for (ItinerarioDTO itinerarioDTO : tarifa.getItinerarioDTOlist()) {
                    List<Ruta> rutas = rutaDAO.findByItinerario(idProducto);
                    if(rutas!=null && !rutas.isEmpty()){
                        RutaDTO ruta = TransformacionDozer.transformar(rutas.get(0), RutaDTO.class);
                        TarifaTransporte tarifaTransporte = tarifaTransporteDAO.findById(ruta.getIdRuta());
                        if(tarifaTransporte!=null){
                            total=total+tarifaTransporte.getPrecio().longValue();
                            ruta.setTraifaTransporteDTO(TransformacionDozer.transformar(tarifaTransporte, TarifaTransporteDTO.class));
                        }
                        itinerarioDTO.setRutaDTO(ruta);
                        
                    }
                    for (HabitacionDTO habitacionDTO : itinerarioDTO.getIdHospedaje().getHabitacionList()) {
                        List<TarifaHospedaje> tarifaHospedajes = tarifaHospedajeDAO.findByHabitacion(habitacionDTO.getIdHabitacion());
                        if(tarifaHospedajes!=null && !tarifaHospedajes.isEmpty()){
                             total=total+tarifaHospedajes.get(0).getPrecio().longValue();
                            TarifaHospedajeDTO tarifaHospedaje = TransformacionDozer.transformar(tarifaHospedajes.get(0), TarifaHospedajeDTO.class);
                            habitacionDTO.setTarifaHospedajeDTO(tarifaHospedaje);
                        }
                    }
                    Boleteria boleteria = boleteriaDAO.findByProducto(producto.getIdProducto());
                    if(boleteria!=null){
                        total=total+boleteria.getValor();
                        tarifa.setBoleteriaDTO(TransformacionDozer.transformar(boleteria, BoleteriaDTO.class));
                    }
                }
            }
            tarifa.setTotal(total);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(tarifa);
                    
            
            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
}
