/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.interfazcontable.dao;

import co.com.touresbalon.interfazcontable.dto.InfoDTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class NativasDAO {

    @PersistenceContext
    private EntityManager em;

    private static String SQL_NATIVO_ORDENES = "select prod.id_producto, prod.nombre_producto, ord.no_orden, to_char(ord.fecha_creacion,'ddmmyyyy') as fecha, ord.numero_solicitud, det.valor\n"
            + "from detalle_orden_compra det\n"
            + "inner join orden_compra ord on ord.no_orden = det.no_orden\n"
            + "inner join producto prod on prod.id_producto = det.id_producto\n"
            + "inner join tipo_producto tipo on tipo.ID_TIPO_PRODUCTO = prod.ID_TIPO_PRODUCTO\n"
            + "where ord.id_estado_orden_compra=4\n"
            + "and ord.fecha_creacion = to_date(?,'ddmmyyyy')\n"
            + "and prod.estado = 1";
    
    public List<InfoDTO> consultarInfo(String fecha){
        
        List<Object[]> datos = em.createNativeQuery(SQL_NATIVO_ORDENES)
                .setParameter(1, fecha)
                .getResultList();
        List<InfoDTO> salida = new ArrayList<>();
        for (Object[] o : datos) {
            InfoDTO top = new InfoDTO();
            top.setIdProdcuto(((BigDecimal) o[0]).longValue());
            top.setNombre((String) o[1]);
            top.setNroOrden(((BigDecimal) o[2]).longValue());
            top.setFecha((String) o[3]);
            top.setNroSolicitud(((BigDecimal) o[4]).longValue());
            top.setValor(((BigDecimal) o[5]).longValue());
            salida.add(top);
        }
        return salida;
        
    }

}
