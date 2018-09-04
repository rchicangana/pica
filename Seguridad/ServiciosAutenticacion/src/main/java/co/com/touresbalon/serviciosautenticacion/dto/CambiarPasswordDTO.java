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
public class CambiarPasswordDTO {
    
    private String login;
    private String passwordAnterior;
    private String nuevoPassword;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordAnterior() {
        return passwordAnterior;
    }

    public void setPasswordAnterior(String passwordAnterior) {
        this.passwordAnterior = passwordAnterior;
    }

    public String getNuevoPassword() {
        return nuevoPassword;
    }

    public void setNuevoPassword(String nuevoPassword) {
        this.nuevoPassword = nuevoPassword;
    }
    
    
    
}
