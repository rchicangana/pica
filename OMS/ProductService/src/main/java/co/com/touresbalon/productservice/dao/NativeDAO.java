/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.dto.TopFiveDTO;
import co.com.touresbalon.productservice.entidades.ImagenProducto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class NativeDAO {

    @EJB
    private ImagenProductoDAO imagenProductoDAO;

    @PersistenceContext
    private EntityManager em;

    private static final String SQL_NATIVO_TOP_5_PRODUCTOS_VENDIDOS = "select cantidad, idproducto, nombreproducto from (\n"
            + "select count(1) as cantidad, det.id_producto as idproducto, prod.nombre_producto as nombreproducto\n"
            + "from detalle_orden_compra det\n"
            + "inner join orden_compra ord on ord.no_orden = det.no_orden\n"
            + "inner join producto prod on prod.id_producto = det.id_producto\n"
            + "where ord.id_estado_orden_compra=4\n"
            + "and prod.estado = 1\n"
            + "GROUP BY det.id_producto, prod.nombre_producto\n"
            + "order by cantidad desc\n"
            + ") where rownum <= 5\n"
            + "order by cantidad";

    private static final String SQL_NATIVO_TOP_5_VENTAS_POR_PRODUCTO = "select cantidad, idproducto, nombreproducto from (\n"
            + "select count(1) as cantidad, det.id_producto as idproducto, prod.nombre_producto as nombreproducto\n"
            + "from detalle_orden_compra det\n"
            + "inner join orden_compra ord on ord.no_orden = det.no_orden\n"
            + "inner join producto prod on prod.id_producto = det.id_producto\n"
            + "where ord.id_estado_orden_compra=4\n"
            + "and prod.estado = 1\n"
            + "and exists (select 1 from detalle_orden_compra det2 where det2.no_orden=det.no_orden and det2.id_producto=?)\n"
            + "and prod.id_producto<>?\n"
            + "GROUP BY det.id_producto, prod.nombre_producto\n"
            + "order by cantidad desc\n"
            + ") where rownum <= 5\n"
            + "order by cantidad";

    public static final String SQL_NATIVO_RANKING_TIPO_PRODCUTOS = "select count(1) as cantidad, tipo.nombre\n"
            + "from detalle_orden_compra det\n"
            + "inner join orden_compra ord on ord.no_orden = det.no_orden\n"
            + "inner join producto prod on prod.id_producto = det.id_producto\n"
            + "inner join tipo_producto tipo on tipo.ID_TIPO_PRODUCTO = prod.ID_TIPO_PRODUCTO\n"
            + "where ord.id_estado_orden_compra=4\n"
            + "and ord.fecha_creacion between to_date( ? ,'ddmmyyyy') and to_date( ? ,'ddmmyyyy')\n"
            + "and prod.estado = 1\n"
            + "GROUP BY tipo.nombre\n"
            + "order by cantidad desc";

    public static final String SQL_NATIVO_RANKING_PRODUCTOS= "select count(1) as cantidad, prod.id_producto, prod.nombre_producto\n"
            + "from detalle_orden_compra det\n"
            + "inner join orden_compra ord on ord.no_orden = det.no_orden\n"
            + "inner join producto prod on prod.id_producto = det.id_producto\n"
            + "inner join tipo_producto tipo on tipo.ID_TIPO_PRODUCTO = prod.ID_TIPO_PRODUCTO\n"
            + "where ord.id_estado_orden_compra=4\n"
            + "and ord.fecha_creacion between to_date(?,'ddmmyyyy') and to_date(?,'ddmmyyyy')\n"
            + "and prod.estado = 1\n"
            + "GROUP BY prod.id_producto, prod.nombre_producto\n"
            + "order by cantidad desc";
    
    public List<TopFiveDTO> consultarRankingCategorias(String fechaIni, String fechaFin) {
        List<Object[]> datos = em.createNativeQuery(SQL_NATIVO_RANKING_TIPO_PRODCUTOS)
                .setParameter(1, fechaIni)
                .setParameter(2, fechaFin)
                .getResultList();
        List<TopFiveDTO> salida = new ArrayList<>();
        for (Object[] o : datos) {
            TopFiveDTO top = new TopFiveDTO();
            top.setCantidad(((BigDecimal) o[0]).longValue());
            top.setNombre((String) o[1]);
            salida.add(top);
        }
        return salida;
    }
    
     public List<TopFiveDTO> consultarRankingProductos(String fechaIni, String fechaFin) {
        List<Object[]> datos = em.createNativeQuery(SQL_NATIVO_RANKING_PRODUCTOS)
                .setParameter(1, fechaIni)
                .setParameter(2, fechaFin)
                .getResultList();
        List<TopFiveDTO> salida = new ArrayList<>();
        for (Object[] o : datos) {
            TopFiveDTO top = new TopFiveDTO();
            top.setCantidad(((BigDecimal) o[0]).longValue());
            top.setIdProducto(((BigDecimal) o[1]).longValue());
            top.setNombre((String) o[2]);
            salida.add(top);
        }
        return salida;
    }

    public List<TopFiveDTO> consultarTopFive() {
        List<Object[]> datos = em.createNativeQuery(SQL_NATIVO_TOP_5_PRODUCTOS_VENDIDOS)
                .getResultList();
        List<TopFiveDTO> salida = new ArrayList<>();
        for (Object[] o : datos) {
            TopFiveDTO top = new TopFiveDTO();
            top.setCantidad(((BigDecimal) o[0]).longValue());
            top.setIdProducto(((BigDecimal) o[1]).longValue());
            top.setNombre((String) o[2]);
            //consultamos imagen
            List<ImagenProducto> imagenes = imagenProductoDAO.findAllPrincipal(((BigDecimal) o[1]).longValue());
            if (imagenes != null && !imagenes.isEmpty()) {
                top.setImagen(imagenes.get(0).getImagen());
            }
            salida.add(top);
        }
        return salida;
    }

    public List<TopFiveDTO> consultarTopFiveProducto(Long idProducto) {
        List<Object[]> datos = em.createNativeQuery(SQL_NATIVO_TOP_5_VENTAS_POR_PRODUCTO)
                .setParameter(1, idProducto)
                .setParameter(2, idProducto)
                .getResultList();
        List<TopFiveDTO> salida = new ArrayList<>();
        for (Object[] o : datos) {
            TopFiveDTO top = new TopFiveDTO();
            top.setCantidad(((BigDecimal) o[0]).longValue());
            top.setIdProducto(((BigDecimal) o[1]).longValue());
            top.setNombre((String) o[2]);
            //consultamos imagen
            List<ImagenProducto> imagenes = imagenProductoDAO.findAllPrincipal(((BigDecimal) o[1]).longValue());
            if (imagenes != null && !imagenes.isEmpty()) {
                top.setImagen(imagenes.get(0).getImagen());
            }
            salida.add(top);
        }
        return salida;
    }

}
