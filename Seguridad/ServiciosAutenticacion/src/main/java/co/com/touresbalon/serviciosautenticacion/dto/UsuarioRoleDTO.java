/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.dto;

/**
 *
 * @author rchic
 */
public class UsuarioRoleDTO {
    private String role;
    private String opcion;
    private String url;
    private String ultimoNivel;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUltimoNivel() {
        return ultimoNivel;
    }

    public void setUltimoNivel(String ultimoNivel) {
        this.ultimoNivel = ultimoNivel;
    }
    
    
    
    
}
