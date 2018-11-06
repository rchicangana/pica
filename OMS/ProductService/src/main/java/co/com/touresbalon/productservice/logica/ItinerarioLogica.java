/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.ItinerarioDAO;
import co.com.touresbalon.productservice.dao.ProductoDAO;
import co.com.touresbalon.productservice.dao.RutaDAO;
import co.com.touresbalon.productservice.dao.TarifaHospedajeDAO;
import co.com.touresbalon.productservice.dao.TarifaTransporteDAO;
import co.com.touresbalon.productservice.dto.CiudadDTO;
import co.com.touresbalon.productservice.dto.EmpresaDTO;
import co.com.touresbalon.productservice.dto.HospedajeDTO;
import co.com.touresbalon.productservice.dto.ItinerarioDTO;
import co.com.touresbalon.productservice.dto.ItinerarioFrontDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.entidades.Ciudad;
import co.com.touresbalon.productservice.entidades.Empresa;
import co.com.touresbalon.productservice.entidades.Hospedaje;
import co.com.touresbalon.productservice.entidades.Itinerario;
import co.com.touresbalon.productservice.entidades.Producto;
import co.com.touresbalon.productservice.entidades.Ruta;
import co.com.touresbalon.productservice.entidades.TarifaHospedaje;
import co.com.touresbalon.productservice.entidades.TarifaTransporte;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchicangana
 */
@Stateless
public class ItinerarioLogica {
    
    @EJB
    private ItinerarioDAO itinerarioDAO;
    
    @EJB
    private RutaDAO rutaDAO;
    
    @EJB
    private TarifaHospedajeDAO tarifaHospedajeDAO;
    
    @EJB
    private TarifaTransporteDAO tarifaTransporteDAO;
    
    @EJB
    private ProductoDAO productoDAO;
    
    
    public List<ItinerarioFrontDTO> consultar(Long idProdcuto){
        List<ItinerarioFrontDTO> salida = new ArrayList<>();
        List<Itinerario> itinerarios = itinerarioDAO.findByProducto(idProdcuto);
        for (Itinerario itinerario : itinerarios) {
            ItinerarioFrontDTO item = new ItinerarioFrontDTO();
            item.setIdItinerario(itinerario.getIdItinerario());
            item.setDescripcion(itinerario.getDescripcion());
            item.setIdProducto(itinerario.getIdProducto());
            List<Ruta> rutas = rutaDAO.findByItinerario(itinerario.getIdItinerario());
            if(rutas!=null && !rutas.isEmpty()){
                item.setIdCiudadOrigen(TransformacionDozer.transformar(rutas.get(0).getIdCiudadOrigen(), CiudadDTO.class));
                item.setIdEmpresa(TransformacionDozer.transformar(rutas.get(0).getIdEmpresa(),EmpresaDTO.class));
                TarifaTransporte tarifaTransporte = tarifaTransporteDAO.findByRuta(rutas.get(0).getIdRuta());
                item.setTarifaTransporte(tarifaTransporte.getPrecio().longValue());
            }
            item.setIdHospedaje(TransformacionDozer.transformar(itinerario.getIdHospedaje(), HospedajeDTO.class));
            if(itinerario.getIdHospedaje().getHabitacionList()!=null && !itinerario.getIdHospedaje().getHabitacionList().isEmpty()){
                List<TarifaHospedaje> tarifaHospedaje = tarifaHospedajeDAO.findByHabitacion(itinerario.getIdHospedaje().getHabitacionList().get(0).getIdHabitacion());
                if(tarifaHospedaje!=null && !tarifaHospedaje.isEmpty()){
                    item.setTarifaHospedaje(tarifaHospedaje.get(0).getPrecio().longValue());
                }
            }    
            item.setIdCiudad(TransformacionDozer.transformar(itinerario.getIdCiudad(), CiudadDTO.class));
            salida.add(item);
            
        }
        
        
        return salida;
    }
    
    /**
     * 
     * @param entrada
     * @return 
     */
    public MensajeDTO guardarItinerario(ItinerarioFrontDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            //consultamos el producto
            Producto producto = productoDAO.findByCodigo(entrada.getIdProducto());
            Itinerario itinerario = new Itinerario();
            itinerario.setDescripcion(entrada.getDescripcion());
            itinerario.setFechaInicio(producto.getFechaLlegada());
            itinerario.setFechaSalida(producto.getFechaSalida());
            itinerario.setIdCiudad(TransformacionDozer.transformar(entrada.getIdCiudad(), Ciudad.class));
            itinerario.setIdHospedaje(TransformacionDozer.transformar(entrada.getIdHospedaje(), Hospedaje.class));
            itinerario.setIdProducto(producto.getIdProducto());
            itinerarioDAO.guardar(itinerario);
            //Guardamos las rutas
            Ruta ruta = new Ruta();
            ruta.setDescripcion(entrada.getDescripcion());
            ruta.setIdCiudadDestino(TransformacionDozer.transformar(entrada.getIdCiudad(), Ciudad.class));
            ruta.setIdCiudadOrigen(TransformacionDozer.transformar(entrada.getIdCiudadOrigen(), Ciudad.class));
            ruta.setIdEmpresa(TransformacionDozer.transformar(entrada.getIdEmpresa(), Empresa.class));
            ruta.setIdItinerario(itinerario);
            rutaDAO.guardar(ruta);
            TarifaTransporte transporte = new TarifaTransporte();
            transporte.setFechaVigencia(producto.getFechaSalida());
            transporte.setIdRuta(ruta);
            transporte.setPrecio(new BigDecimal(entrada.getTarifaTransporte()));
            tarifaTransporteDAO.guardar(transporte);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(itinerario, ItinerarioDTO.class));            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage()); 
        }
        
        return salida;
    }
    
    /**
     * 
     * @param entrada
     * @return 
     */
    public MensajeDTO actualizarItinerario(ItinerarioDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            Itinerario itinerario = TransformacionDozer.transformar(entrada, Itinerario.class);
            itinerarioDAO.actualizar(itinerario);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(itinerario, ItinerarioDTO.class));            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
    
    
}
