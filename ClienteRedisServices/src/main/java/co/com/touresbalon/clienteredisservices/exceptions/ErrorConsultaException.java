package co.com.touresbalon.clienteredisservices.exceptions;

/**
 * @author rch
 */
public class ErrorConsultaException extends Exception {

    public ErrorConsultaException(String message) {
        super(message);
    }

    public ErrorConsultaException(String message, Throwable cause) {
        super(message, cause);
    }

}
