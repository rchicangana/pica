/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.dao;

import co.com.touresbalon.serviciosautenticacion.dto.UsuarioRoleDTO;
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
public class RolesDAO {

    @PersistenceContext
    private EntityManager em;

    private static final String SQL_NATIVO_ROLES = "select rol.role, men.nombre, men.ultimo_nivel, men.url\n"
            + "from usuario usu\n"
            + "inner join usuario_role usurole on usurole.id_usuario = usu.id_usuario\n"
            + "inner join role rol on rol.id_role = usurole.id_role\n"
            + "inner join menu_role menurole on menurole.id_role = rol.id_role\n"
            + "inner join menu men on men.id_menu = menurole.id_menu\n"
            + "where usu.id_usuario = ?";
    
    public List<UsuarioRoleDTO> getRolesUsuario(Long idUsuario){
        List<Object[]> datos = em.createNativeQuery(SQL_NATIVO_ROLES)
                .setParameter(1, idUsuario)
                .getResultList();
        List<UsuarioRoleDTO> salida = new ArrayList<>();
        for (Object[] o : datos) {
            UsuarioRoleDTO top = new UsuarioRoleDTO();
            top.setRole(((String) o[0]));
            top.setOpcion(((String) o[1]));
            top.setUltimoNivel((String) o[2]);
            top.setUrl((String) o[3]);
            salida.add(top);
        }
        
        return salida;
    }

}
