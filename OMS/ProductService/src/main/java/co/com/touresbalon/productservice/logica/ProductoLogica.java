/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.clienteredisservices.api.ClienteRedisService;
import co.com.touresbalon.clienteredisservices.dto.ListDTO;
import co.com.touresbalon.clienteredisservices.logica.ClienteRedisServiceBuilder;
import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.NativeDAO;
import co.com.touresbalon.productservice.dao.ProductoDAO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.dto.ProductoDTO;
import co.com.touresbalon.productservice.dto.TopFiveDTO;
import co.com.touresbalon.productservice.entidades.Producto;
import co.com.touresbalon.productservice.entidades.TipoProducto;
import co.com.touresbalon.productservice.util.FechaUtil;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchicangana
 */
@Stateless
public class ProductoLogica {
    
    private static final Logger LOG = Logger.getLogger(ProductoLogica.class.getName());
    
    @EJB
    private ProductoDAO productoDAO;
    
    @EJB
    private NativeDAO nativeDAO;

    /**
     *
     * @param codigo
     * @return
     */
    public MensajeDTO buscarProdcutoporCodigo(final Long codigo) {
        
        MensajeDTO salida = new MensajeDTO();
        try {
            
            Producto producto = productoDAO.findByCodigo(codigo);
            if (producto == null) {
                salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
                salida.setMensaje(ConstantesComunes.MSG_SIN_DATOS);
            } else {
                salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
                salida.setObject(TransformacionDozer.transformar(producto, ProductoDTO.class));
            }
            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;
        
    }

    /**
     *
     * @param nombre
     * @param inicio
     * @param fin
     * @return
     */
    public MensajeDTO buscarProdcutoporDescripcion(final String nombre, final Integer inicio, final Integer fin) {
        
        MensajeDTO salida = new MensajeDTO();
        try {
            
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(productoDAO.finByDesProductos(nombre.replaceAll("\\*", "%"), inicio, fin), ProductoDTO.class));
            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;
        
    }
    
    public MensajeDTO buscarProdcuto(final Integer inicio, final Integer fin) {
        
        MensajeDTO salida = new MensajeDTO();
        try {
            
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(productoDAO.finByProductos(inicio, fin), ProductoDTO.class));
            if(inicio==0){
                salida.setCantidad(productoDAO.countAll());
            }
            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;
        
    }
    
    public MensajeDTO guardarProducto(ProductoDTO entrada) {
        MensajeDTO salida = new MensajeDTO();
        
        try {
            Producto producto = TransformacionDozer.transformar(entrada, Producto.class);
            producto.setItinerarioList(null);
            productoDAO.guardar(producto);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(producto, ProductoDTO.class));
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
        
    }
    
    public MensajeDTO actualizarProducto(ProductoDTO entrada) {
        MensajeDTO salida = new MensajeDTO();
        
        try {
            Producto producto = productoDAO.findByCodigo(entrada.getIdProducto());
            producto.setFechaLlegada(FechaUtil.stringToDate(entrada.getFechaLlegada(), ConstantesComunes.FORMATO_FECHA));
            producto.setFechaSalida(FechaUtil.stringToDate(entrada.getFechaSalida(), ConstantesComunes.FORMATO_FECHA));
            producto.setIdTipoProducto(TransformacionDozer.transformar(entrada.getIdTipoProducto(), TipoProducto.class));
            producto.setNombreProducto(entrada.getNombreProducto());
            producto.setDescripcion(entrada.getDescripcion());
            productoDAO.actualizar(producto);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(producto, ProductoDTO.class));
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
    public MensajeDTO delete(ProductoDTO entrada) {
        MensajeDTO salida = new MensajeDTO();
        
        try {
            Producto producto = productoDAO.findByCodigo(entrada.getIdProducto());
            productoDAO.borrar(producto);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
        
    }
    
    public MensajeDTO getTopFive() {
        MensajeDTO salida = new MensajeDTO();
        try {
            Gson g = new Gson();
            final ClienteRedisServiceBuilder builder = new ClienteRedisServiceBuilder();
            ClienteRedisService cliente = builder.servidor("localhost").puerto(8080).build();
            ListDTO datos = cliente.getList("TOPFIVE", 0, 4);
            List<TopFiveDTO> productos = new ArrayList<>();
            for (String dato : datos.getDatos()) {
                productos.add(g.fromJson(dato, TopFiveDTO.class));
            }
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(productos);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al recuperar Top Five", e);
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;
    }
    
    public MensajeDTO getTopFiveProducto(Long idProducto) {
        MensajeDTO salida = new MensajeDTO();
        try {
            
            List<TopFiveDTO> productos = nativeDAO.consultarTopFiveProducto(idProducto);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(productos);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al recuperar Top Five por producto", e);
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;
    }
    
    
}
