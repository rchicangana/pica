/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.dto;

import java.util.List;

/**
 *
 * @author rchic
 */
public class LoginOutDTO {
    
    private UsuarioDTO usuario;
    private String tokenJwt;
    private List<UsuarioRoleDTO> roles;

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public String getTokenJwt() {
        return tokenJwt;
    }

    public void setTokenJwt(String tokenJwt) {
        this.tokenJwt = tokenJwt;
    }

    public List<UsuarioRoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<UsuarioRoleDTO> roles) {
        this.roles = roles;
    }
    
    
    
    
}
