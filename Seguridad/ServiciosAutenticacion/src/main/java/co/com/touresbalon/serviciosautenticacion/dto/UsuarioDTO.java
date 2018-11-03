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
public class UsuarioDTO {
    
    private Long idUsuario;
    private String nombre;
    private String email;
    private String login;
    private EstadoUserDTO idEstadoUser;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public EstadoUserDTO getIdEstadoUser() {
        return idEstadoUser;
    }

    public void setIdEstadoUser(EstadoUserDTO idEstadoUser) {
        this.idEstadoUser = idEstadoUser;
    }
    
    
    
    
    
}
