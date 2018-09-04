/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.touresbalon.jwtgenerator.exception;

/**
 * runt.com.co
 * @author rchicangana
 */
public class ErrorJWTException extends Exception {
    private static final long serialVersionUID = 1L;

    public ErrorJWTException(final String message) {
        super(message);
    }

    public ErrorJWTException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    

}
